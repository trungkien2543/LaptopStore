/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ThongKeTinhHinh;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ThongKe_DAO {
    Connection con;

    public ThongKe_DAO() {
        con = new SQLConnection().getCon();
    }
    
    public ArrayList<ThongKeTinhHinh> getListTinhHinh(String from, String to){
        ArrayList<ThongKeTinhHinh> list = new ArrayList<>();
        String sql = "SELECT Laptop.id, COUNT(ChiTietLaptop.idRieng) as 'So Hang Da Ban' " +
             "FROM ChiTietLapTop, ChiTietHoaDon, Laptop, HoaDon " +
             "WHERE ChiTietLapTop.idRieng = ChiTietHoaDon.idRieng " +
             "AND Laptop.id = ChiTietLapTop.MauLaptop " +
             "AND HoaDon.MaHoaDon = ChiTietHoaDon.MaHoaDon AND NgayLap BETWEEN '" + from + "' AND '" + to + "' " +
             "GROUP BY Laptop.id";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ThongKeTinhHinh s = new ThongKeTinhHinh(rs.getString(1), rs.getInt(2));
                list.add(s);
            }    
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
        
    }
    
    
}
