/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ThongKeDoanhThu;
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
    
    
    public ArrayList<ThongKeTinhHinh> getListTop5(String from, String to){
        ArrayList<ThongKeTinhHinh> list = new ArrayList<>();
        String sql = "SELECT TOP 5 Laptop.id, COUNT(ChiTietLaptop.idRieng) AS SoLuong " +
             "FROM ChiTietLaptop, ChiTietHoaDon, Laptop, HoaDon " +
             "WHERE ChiTietLaptop.idRieng = ChiTietHoaDon.idRieng " +
             "AND Laptop.id = ChiTietLaptop.MauLaptop " +
             "AND HoaDon.MaHoaDon = ChiTietHoaDon.MaHoaDon " +
             "AND NgayLap BETWEEN '" + from + "' AND '" + to + "' " +
             "GROUP BY Laptop.id " +
             "ORDER BY SoLuong DESC;";

        
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
    
    public ArrayList<ThongKeDoanhThu> getListDoanThu(int nam){
        ArrayList<ThongKeDoanhThu> list = new ArrayList<>();
        String sql = "SELECT COALESCE(PN.thang, HD.thang) AS thang, " +
                              "COALESCE(PN.TienNhap, 0) AS TienNhap, " +
                              "COALESCE(HD.TienBan, 0) AS TienBan " +
                              "FROM (SELECT MONTH(NgayNhap) AS thang, SUM(TongTien) AS TienNhap " +
                              "FROM PhieuNhap WHERE YEAR(NgayNhap) = ? " +
                              "GROUP BY MONTH(NgayNhap)) AS PN " +
                              "FULL OUTER JOIN (SELECT MONTH(NgayLap) AS thang, SUM(TongTien) AS TienBan " +
                              "FROM HoaDon WHERE YEAR(NgayLap) = ? " +
                              "GROUP BY MONTH(NgayLap)) AS HD ON PN.thang = HD.thang " +
                              "ORDER BY thang";

        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nam);
            ps.setInt(2,nam);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ThongKeDoanhThu s = new ThongKeDoanhThu(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                list.add(s);
            }    
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
        
    }
    
    
    public static void main(String[] args) {
        ArrayList<ThongKeDoanhThu> list = new ThongKe_DAO().getListDoanThu(2023);
        for (ThongKeDoanhThu s : list){
            System.out.println(s.DoanhThu());
        }
    }
    
    
}
