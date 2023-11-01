/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class HoaDon_DAO {
    
    Connection con;

    public HoaDon_DAO() {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLCuaHangLaptop;user=sa;password=1;"  + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;"); 
            } 
        catch(Exception e){
            System.out.println(e); 
        }       
    }
    
    public int LayMaHoaDon(){
        String sql = "select max(MaHoaDon) from HoaDon";
        String MaHD = "1";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                MaHD = rs.getString(1);
                System.out.println();
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return Integer.parseInt(MaHD);
    }
}
