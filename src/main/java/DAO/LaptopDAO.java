/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

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
public class LaptopDAO {
    
    Connection con;
    
    public LaptopDAO(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLCuaHangLaptop;user=sa;password=1;"  + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;"); 
            } 
        catch(Exception e){
            System.out.println(e); 
        }
    }       
    
    public ArrayList<Laptop> getListLaptop(){
        ArrayList<Laptop> list = new ArrayList<>();
        String sql = "select * from Laptop";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Laptop s = new Laptop();
                s.setID(rs.getString(1));
                s.setTen(rs.getString(2));
                s.setSoLuongTonKho(3);
                s.setCPU(rs.getString(4));
                s.setRAM(rs.getInt(5));
                s.setGPU(rs.getString(6));
                s.setTrangThai(rs.getString(7));
                
                
                System.out.println(s.getID());
                list.add(s);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
}
