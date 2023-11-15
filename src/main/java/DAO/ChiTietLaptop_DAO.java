/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietLaptop;
import DTO.Laptop;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class ChiTietLaptop_DAO {
    
    Connection con;

    public ChiTietLaptop_DAO() {
        con = new SQLConnection().getCon();   
    }
    
    public ArrayList<ChiTietLaptop> getListChiTietLaptop(){
        ArrayList<ChiTietLaptop> list = new ArrayList<>();
        String sql = "select * from ChiTietLaptop";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ChiTietLaptop s = new ChiTietLaptop();
                s.setIDRieng(rs.getString(1));
                s.setNgayNhap(rs.getDate(2));
                s.setTrangThai(rs.getString(3));
                s.setMauLapTop(rs.getString(4));
                list.add(s);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    
    public boolean CapNhatTrangThai(String TrangThai,String idRieng){
        String sql = "update  ChiTietLaptop set TrangThai=? where idRieng=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,TrangThai);
            ps.setString(2, idRieng);
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean addChiTietLaptop(ChiTietLaptop ct) {
    	String sql = "insert into ChiTietLapTop (idRieng, NgayNhap, TrangThai, MauLaptop) values (?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, ct.getIDRieng());
            ps.setDate(2, new java.sql.Date(new Date().getTime()));
            ps.setString(3, ct.getTrangThai());
            ps.setString(4, ct.getMauLapTop());
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
	}
    
}
