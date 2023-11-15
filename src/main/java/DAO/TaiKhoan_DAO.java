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
			ps = con.prepareStatement(selectSQL);
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
    public NhanVien getNhanVienByTenDangNhap(String tenDangNhap) {
        NhanVien nhanVien = null;
        String sql = "SELECT nv.* FROM NhanVien nv INNER JOIN TaiKhoan tk ON nv.idNhanVien = tk.TenDangNhap WHERE tk.TenDangNhap = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setString(1, tenDangNhap);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Lấy thông tin từ ResultSet và tạo đối tượng NhanVien
                    nhanVien = new NhanVien(
                            resultSet.getString("idNhanVien"),
                            resultSet.getString("TenNhanVien"),
                            resultSet.getString("SDT"),
                            resultSet.getString("DiaChi"),
                            resultSet.getString("NgaySinh"),
                            resultSet.getString("CCCD"),
                            resultSet.getString("Email"),
                            resultSet.getString("TrangThai"),
                            resultSet.getBoolean("GioiTinh")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanVien;
    }

    public NhanVien getNhanVienByEmail(String email) {
        NhanVien nhanVien = null;
        String sql = "SELECT * FROM NhanVien WHERE Email = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
        	
            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Lấy thông tin từ ResultSet và tạo đối tượng NhanVien
                    nhanVien = new NhanVien(
                            resultSet.getString("idNhanVien"),
                            resultSet.getString("TenNhanVien"),
                            resultSet.getString("SDT"),
                            resultSet.getString("DiaChi"),
                            resultSet.getString("NgaySinh"),
                            resultSet.getString("CCCD"),
                            resultSet.getString("Email"),
                            resultSet.getString("TrangThai"),
                            resultSet.getBoolean("GioiTinh")
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nhanVien;
    }
    public static void main(String[] args) {
		System.out.println(new TaiKhoan_DAO().getNhanVienByEmail("trankhanhduy12a12@gmail.com"));
	}
    // test github from eclipse
}
