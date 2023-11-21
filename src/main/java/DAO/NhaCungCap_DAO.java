/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhaCungCap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class NhaCungCap_DAO {
    
    Connection con;

    public NhaCungCap_DAO() {
        con = new SQLConnection().getCon(); 
    }
    public ArrayList<NhaCungCap> getListNhaCungCap() {
        ArrayList<NhaCungCap> list = new ArrayList<>();
        String sql = "SELECT * FROM NhaCungCap";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getString("IdNCC"));
                ncc.setTenNCC(rs.getString("TenNCC"));
                ncc.setSDT(rs.getString("SDT"));
                ncc.setDiaChi(rs.getString("DiaChi"));
                ncc.setEmail(rs.getString("Email"));
                ncc.setTrangThai(rs.getString("TrangThai"));
                list.add(ncc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean addNhaCungCap(NhaCungCap ncc) {
        String sql = "INSERT INTO NhaCungCap (IdNCC, TenNCC, SDT, DiaChi, Email, TrangThai) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getMaNCC());
            ps.setString(2, ncc.getTenNCC());
            ps.setString(3, ncc.getSDT());
            ps.setString(4, ncc.getDiaChi());
            ps.setString(5, ncc.getEmail());
            ps.setString(6, ncc.getTrangThai());
            return ps.executeUpdate() > 0;
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateCungCap(NhaCungCap ncc) {
        String sql = "UPDATE NhaCungCap SET TenNCCp=?, SDT=?, DiaChi=?, Email=?, TrangThai=? WHERE IdNCC=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getTenNCC());
            ps.setString(2, ncc.getSDT());
            ps.setString(3, ncc.getDiaChi());
            ps.setString(4, ncc.getEmail());
            ps.setString(5, ncc.getTrangThai());
            ps.setString(6, ncc.getMaNCC());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}


