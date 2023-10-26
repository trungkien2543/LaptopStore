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

/**
 *
 * @author DELL
 */
public class ChiTietLaptop_DAO {
    
    Connection con;

    public ChiTietLaptop_DAO() {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLCuaHangLaptop;user=sa;password=1;"  + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;"); 
            } 
        catch(Exception e){
            System.out.println(e); 
        }       
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
                s.setGia(rs.getInt(2));
                s.setNgayNhap(rs.getDate(3));
                s.setTrangThai(rs.getString(4));
                s.setMauLapTop(rs.getString(5));
                list.add(s);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    
    
}
