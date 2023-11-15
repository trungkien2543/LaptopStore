/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TaiKhoan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class TaiKhoan_DAO {
    Connection con;

    public TaiKhoan_DAO() {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLCuaHangLaptop;user=sa;password=1;"  + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;"); 
            } 
        catch(Exception e){
            System.out.println(e); 
        }       
    }
    
    public ArrayList<TaiKhoan> getListTaiKhoan(){
        ArrayList<TaiKhoan> list = new ArrayList<>();
        String sql = "select * from TaiKhoan";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                TaiKhoan s = new TaiKhoan();
                s.setTenDN(rs.getString(1));
                s.setMatKhau(rs.getString(2));
                s.setPhanQuyen(rs.getString(3));
                list.add(s);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }   
       
    public boolean addTaiKhoan(TaiKhoan tk){
        
        String sql = "insert into TaiKhoan (TenDangNhap, MatKhau, PhanQuyen) values (?,?,?)";
        try{
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, tk.getTenDN());
            ps.setString(2, tk.getMatKhau());
            ps.setString(3, tk.getPhanQuyen());
            
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delTaiKhoan(TaiKhoan tk){
        
        String sql = "delete from TaiKhoan where TenDangNhap = ?";
        try{
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, tk.getTenDN());
            
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean alterTaiKhoan(TaiKhoan tk){
        
        String sql = "update TaiKhoan set MatKhau = ?, PhanQuyen = ? where TenDangNhap = ?";
        try{
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, tk.getMatKhau());
            ps.setString(2, tk.getPhanQuyen());
            ps.setString(3, tk.getTenDN());
            
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public TaiKhoan findTaiKhoan(String tenDN){
        TaiKhoan s = new TaiKhoan();
        String sql = "select * from TaiKhoan where TenDangNhap = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tenDN);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                s.setTenDN(rs.getString(1));
                s.setMatKhau(rs.getString(2));
                s.setPhanQuyen(rs.getString(3));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return s;
    }
}
