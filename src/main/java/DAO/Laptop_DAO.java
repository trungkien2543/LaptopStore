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
public class Laptop_DAO {
    
    Connection con;
    
    public Laptop_DAO(){
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
                s.setSoLuongTonKho(rs.getInt(3));
                s.setCPU(rs.getString(4));
                s.setRAM(rs.getInt(5));
                s.setGPU(rs.getString(6));
                s.setTrangThai(rs.getString(7));
                list.add(s);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean addLaptop(Laptop laptop){
        
        String sql = "insert into Laptop (id,Ten,SoLuongTonKho,CPU,RAM,GPU,TrangThai) values (?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, laptop.getID());
            ps.setString(2, laptop.getTen());
            ps.setInt(3, laptop.getSoLuongTonKho());
            ps.setString(4, laptop.getCPU());
            ps.setInt(5, laptop.getRAM());
            ps.setString(6, laptop.getGPU());
            ps.setString(7, laptop.getTrangThai());
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    
    public boolean deleteLaptop(String ID){
        String sql = "update  Laptop set TrangThai = 'DaXoa'"+" where id=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ID);
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean editLaptop(Laptop s){
        String sql = "update  Laptop set Ten = ?,SoLuongTonKho=?, CPU=?, RAM=?, GPU=? where id=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getTen());
            ps.setInt(2, s.getSoLuongTonKho());
            ps.setString(3, s.getCPU());
            ps.setInt(4, s.getRAM());
            ps.setString(5, s.getGPU());
            ps.setString(6, s.getID());
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
     }
    
    
    public boolean TruSoLuongTonKho(int sl,String id){
        String sql = "update  Laptop set SoLuongTonKho=? where id=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, sl);
            ps.setString(2, id);
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
