/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVien;
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
public class NhanVien_DAO {
    
    Connection con;

    public NhanVien_DAO() {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLCuaHangLaptop;user=sa;password=1;"  + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;"); 
            } 
        catch(Exception e){
            System.out.println(e); 
        }       
    }
    
    
    public ArrayList<NhanVien> getListNhanVien(){
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "select * from NhanVien";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                NhanVien s = new NhanVien();
                s.setMaNV(rs.getString(1));
                s.setTenNV(rs.getString(2));
                s.setSDT(rs.getString(3));
                s.setDiaChi(rs.getString(4));
                s.setNgaySinh(rs.getString(5));
                s.setGioiTinh(rs.getBoolean(6));
                s.setCCCD(rs.getString(7));
                s.setEmail(rs.getString(8));
                s.setTrangThai(rs.getString(9));
                list.add(s);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }   
    
    public ArrayList<NhanVien> getListNhanVien_now(){
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "select * from NhanVien where TrangThai = 1";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                NhanVien s = new NhanVien();
                s.setMaNV(rs.getString(1));
                s.setTenNV(rs.getString(2));
                s.setSDT(rs.getString(3));
                s.setDiaChi(rs.getString(4));
                s.setNgaySinh(rs.getString(5));
                s.setGioiTinh(rs.getBoolean(6));
                s.setCCCD(rs.getString(7));
                s.setEmail(rs.getString(8));
                s.setTrangThai(rs.getString(9));
                list.add(s);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }  
       
    
    public boolean addNhanVien(NhanVien nv){
        
        String sql = "insert into NhanVien (idNhanVien,TenNhanVien,SDT,DiaChi,NgaySinh,GioiTinh,CCCD,Email,TrangThai) values (?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getTenNV());
            ps.setString(3, nv.getSDT());
            ps.setString(4, nv.getDiaChi());
            ps.setString(5, nv.getNgaySinh());
            ps.setBoolean(6, nv.isGioiTinh());
            ps.setString(7, nv.getCCCD());
            ps.setString(8, nv.getEmail());
            ps.setString(9, "1");
            
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delNhanVien(NhanVien nv){
        
        String sql = "update NhanVien set TrangThai = 0 where idNhanVien = ?";
        try{
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, nv.getMaNV());
            
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean alterNhanVien(NhanVien nv){
        
        String sql = "update NhanVien set TenNhanVien = ?, SDT = ?, DiaChi = ?, NgaySinh = ?, GioiTinh = ?, CCCD = ?, Email = ? where idNhanVien = ?";
        try{
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, nv.getTenNV());
            ps.setString(2, nv.getSDT());
            ps.setString(3, nv.getDiaChi());
            ps.setString(4, nv.getNgaySinh());
            ps.setBoolean(5, nv.isGioiTinh());
            ps.setString(6, nv.getCCCD());
            ps.setString(7, nv.getEmail());
            ps.setString(8, nv.getMaNV());
            
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public NhanVien findNhanVien(String id){
        
        NhanVien s = new NhanVien();
        String sql = "select * from NhanVien where idNhanVien = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                s.setMaNV(rs.getString(1));
                s.setTenNV(rs.getString(2));
                s.setSDT(rs.getString(3));
                s.setDiaChi(rs.getString(4));
                s.setNgaySinh(rs.getString(5));
                s.setGioiTinh(rs.getBoolean(6));
                s.setCCCD(rs.getString(7));
                s.setEmail(rs.getString(8));
                s.setTrangThai(rs.getString(9));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return s;
    }
    
    public ArrayList<String> getListNhanVien_noTK(){
        ArrayList<String> list = new ArrayList<>();
        String sql = "select * from NhanVien where idNhanVien not in (select idNhanVien from NhanVien inner join TaiKhoan on NhanVien.idNhanVien = TaiKhoan.TenDangNhap) and TrangThai = 1";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
            	String s = rs.getString(1);
                list.add(s);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }   
    
    
}
