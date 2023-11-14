/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.HoaDon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class HoaDon_DAO {
    
    Connection con;

    public HoaDon_DAO() {
        con = new SQLConnection().getCon();    
    }
    public ArrayList<HoaDon> getListHoaDon(){
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "Select * from HoaDon";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt(1));
                hd.setNgayLap(rs.getTimestamp(2).toLocalDateTime());
                hd.setTongTien(rs.getInt(3));
                hd.setSoLuong(rs.getInt(4));
                hd.setNhanVien(rs.getString(5));
                hd.setKhachHang(rs.getString(6));
                list.add(hd);
            }    
        }
        catch(Exception e){
            e.printStackTrace();   
        }
        return list;
    }
    public int LayMaHoaDon(){
        String sql = "select max(MaHoaDon) from HoaDon";
        int MaHD = 0;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                MaHD = rs.getInt(1)+1;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return (MaHD);
    }
    
    public boolean ThemHoaDon(HoaDon hd){
        String sql = "insert into HoaDon (MaHoaDon,NgayLap,TongTien,SoLuong,NhanVien,KhachHang) values (?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, hd.getMaHD());
            ps.setObject(2, hd.getNgayLap());
            ps.setInt(3, hd.getTongTien());
            ps.setInt(4, hd.getSoLuong());
            ps.setString(5,hd.getNhanVien());
            ps.setString(6, hd.getKhachHang());
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteHoaDon(int mahoadon){
        String sql = "delete from HoaDon where MaHoaDon = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, mahoadon);
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<HoaDon> TimKiem(String Loai,String From,String To){
        ArrayList<HoaDon> list_find = new ArrayList<>();
        try{
            String sql = "select * from HoaDon where "+Loai+" between ? and ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, From);
            ps.setString(2, To);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDon s = new HoaDon(rs.getInt(1), rs.getInt(4), rs.getInt(3),rs.getTimestamp(2).toLocalDateTime(), rs.getString(5), rs.getString(6));
                list_find.add(s);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list_find;
    }
    
    public static void main(String[] args) {
        ArrayList<HoaDon> list =  new HoaDon_DAO().TimKiem("SoLuong", "0" , "10");
        DateTimeFormatter NgayGio = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(NgayGio.format(list.get(0).getNgayLap()));
    }

}
