/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhachHang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class KhachHang_DAO {
    
    Connection con;

    public KhachHang_DAO() {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLCuaHangLaptop;user=sa;password=1;"  + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;"); 
            } 
        catch(Exception e){
            System.out.println(e); 
        }       
    }
    
    public ArrayList<KhachHang> getListKhachHang(){
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = "select * from KhachHang";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                KhachHang s = new KhachHang();
                s.setMaKH(rs.getString(1));
                s.setTen(rs.getString(2));
                s.setSDT(rs.getString(3));
                s.setTichDiem(rs.getInt(4));
                s.setDiaChi(rs.getString(5));
                s.setTrangThai(rs.getString(6));
                list.add(s);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }   
    
    
    public boolean addKhachHang(KhachHang kh){
        
        String sql = "insert into KhachHang (idKhachHang,Ten,SDT,TichDiem,DiaChi,TrangThai) values (?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getTen());
            ps.setString(3, kh.getSDT());
            ps.setInt(4, kh.getTichDiem());
            ps.setString(5, kh.getDiaChi());
            ps.setString(6, kh.getTrangThai());
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }

    
    public boolean TichDiem(int Diem, String MaKH){
        String sql = "update  KhachHang set TichDiem = ? where idKhachHang = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Diem);
            ps.setString(2, MaKH);
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
