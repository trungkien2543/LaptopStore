/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ChiTietHoaDon_DAO {
    
    Connection con;

    public ChiTietHoaDon_DAO() {
        con = new SQLConnection().getCon();
    }
    public ArrayList<ChiTietHoaDon> getListChiTietHoaDon(int MaHD){
        ArrayList<ChiTietHoaDon> list = new ArrayList<>();
        String sql ="Select * from HoaDon where MaHoaDon=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, MaHD);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setIDRieng(rs.getString(1));
                cthd.setMaHD(rs.getInt(2));
                cthd.setGia(rs.getInt(3));
                list.add(cthd);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public boolean ThemChiTietHoaDon(ChiTietHoaDon ct){
        String sql = "insert into ChiTietHoaDon (idRieng,MaHoaDon,Gia) values (?,?,?)";
        try{
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, ct.getIDRieng());
            ps.setInt(2, ct.getMaHD());
            ps.setInt(3, ct.getGia());
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
      
}
