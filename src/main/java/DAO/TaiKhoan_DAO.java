/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.*;

/**
 *
 * @author DELL
 */
public class TaiKhoan_DAO {
    Connection con;

    public TaiKhoan_DAO() {
        con = new SQLConnection().getCon();
    }
    public List<TaiKhoan> getListTaiKhoan() {
        List<TaiKhoan> taiKhoanList = new ArrayList<>();
        String selectSQL = "SELECT * FROM TaiKhoan";
		PreparedStatement ps;
		try {
			ps = new SQLConnection().getCon().prepareStatement(selectSQL);
			ResultSet rs = ps.executeQuery();
	        
	        // Lặp qua các hàng kết quả và thêm vào danh sách
	        while (rs.next()) {
	            String TenDN = rs.getString("TenDangNhap");
	            String MatKhau = rs.getString("MatKhau");
	            String PhanQuyen = rs.getString("PhanQuyen");
	            TaiKhoan taiKhoan = new TaiKhoan(TenDN, MatKhau, PhanQuyen);
	            taiKhoanList.add(taiKhoan);
	        }
	            
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return taiKhoanList;
	}
}
