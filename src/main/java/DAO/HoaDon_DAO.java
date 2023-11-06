/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.HoaDon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;

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
        int MaHD = 0;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                MaHD = rs.getInt(1)+1;
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return (MaHD);
    }
    
    public boolean ThemHoaDon(HoaDon hd){
        String sql = "insert into HoaDon (MaHoaDon,NgayLap,TongTien,SoLuong,NhanVien,KhachHang) values (?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, hd.getMaHD());
            ps.setObject(2, hd.getNgayLap());
            ps.setInt(3, hd.getTongTien());
            ps.setInt(4, hd.getSoLuong());
            ps.setString(5,hd.getNhanVien());
            ps.setString(6, hd.getKhachHang());
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }


}
