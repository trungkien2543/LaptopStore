/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhieuNhap;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class PhieuNhap_DAO {
    
    Connection con;

    public PhieuNhap_DAO() {
        con = new SQLConnection().getCon();
    }
    public ArrayList<PhieuNhap> getListPhieuNhap(){
        ArrayList<PhieuNhap> list = new ArrayList<>();
        String sql = "Select * from PhieuNhap";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhieuNhap pn = new PhieuNhap();
                pn.setMaPhieu(rs.getInt(1));
                pn.setNgayNhap(rs.getDate(2));
                pn.setTongTien(rs.getInt(3));
                pn.setNhaCungCap(rs.getString(4));
                pn.setNhanVien(rs.getString(5));
                list.add(pn);
            }    
        }
        catch(Exception e){
            e.printStackTrace();   
        }
        return list;
    }
    public boolean insertPhieuNhap(PhieuNhap s){
        String sql = "insert into PhieuNhap(MaPhieu,NgayNhap,TongTien,NhaCungCap,NhanVien) values(?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, s.getMaPhieu());
            ps.setDate(2, new Date(s.getNgayNhap().getTime()));
            ps.setInt(3,s.getTongTien());
            ps.setString(4, s.getNhaCungCap());
            ps.setString(5, s.getNhanVien());
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public int getMaxMaPhieuNhap(){
        String sql = "select Max(MaPhieu) from PhieuNhap";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt(1);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
