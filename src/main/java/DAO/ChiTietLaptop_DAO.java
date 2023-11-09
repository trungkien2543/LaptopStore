/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietLaptop_DTO;
import DTO.Laptop_DTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ChiTietLaptop_DAO {
    
    Connection con;

    public ChiTietLaptop_DAO() {
        con = new SQLConnection().getCon();   
    }
    
    public ArrayList<ChiTietLaptop_DTO> getListChiTietLaptop(){
        ArrayList<ChiTietLaptop_DTO> list = new ArrayList<>();
        String sql = "select * from ChiTietLaptop";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ChiTietLaptop_DTO s = new ChiTietLaptop_DTO();
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
    
    
}
