/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietPhieu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ChiTietPhieu_DAO {
    
    Connection con;

    public ChiTietPhieu_DAO() {
        con = new SQLConnection().getCon(); 
    }
    public ArrayList<ChiTietPhieu> getListChiTietPhieuNhap(int MaPhieu){
        ArrayList<ChiTietPhieu> list = new ArrayList<>();
        String sql ="Select * from ChiTietPhieu where MaPhieu=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, MaPhieu);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ChiTietPhieu ctpn = new ChiTietPhieu();
                ctpn.setID(rs.getString(1));
                ctpn.setMaPhieu(rs.getInt(2));
                ctpn.setSoLuong(rs.getInt(3));
                ctpn.setGia(rs.getInt(4));
                list.add(ctpn);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean addChiTietPhieuNhap(ChiTietPhieu s){
        String sql = "insert into ChiTietPhieu(id, MaPhieu, SoLuong, Gia) values (?,?,?,?) ";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getID());
            ps.setInt(2,s.getMaPhieu());
            ps.setInt(3, s.getSoLuong());
            ps.setInt(4, s.getGia());
            return ps.executeUpdate() > 0;    
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteChiTietPhieuNhap(int maphieunhap){
        String sql = "delete from ChiTietPhieu where MaPhieu = ? ";
        try{
            PreparedStatement ps =  con.prepareStatement(sql);
            ps.setInt(2, maphieunhap);
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
}
