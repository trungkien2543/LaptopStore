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

/**
 *
 * @author DELL
 */
public class ChiTietHoaDon_DAO {
    
    Connection con;

    public ChiTietHoaDon_DAO() {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLCuaHangLaptop;user=sa;password=1;"  + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;"); 
            } 
        catch(Exception e){
            System.out.println(e); 
        }       
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
