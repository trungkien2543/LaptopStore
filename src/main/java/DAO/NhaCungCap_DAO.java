/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.PhieuNhap;
import GUI.NhaCungCap;

/**
 *
 * @author DELL
 */
public class NhaCungCap_DAO {
    
    Connection con;

    public NhaCungCap_DAO() {
        con = new SQLConnection().getCon();  
    }
    
    public ArrayList<DTO.NhaCungCap> getListNhaCungCap() {
    	ArrayList<DTO.NhaCungCap> list = new ArrayList<>();
    	
    	String sql = "Select * from NhaCungCap";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            	DTO.NhaCungCap pn = new DTO.NhaCungCap();
                pn.setMaNCC(rs.getString(1));
                pn.setTenNCC(rs.getString(2));
                pn.setDiaChi(rs.getString(3));
                pn.setSDT(rs.getString(4));
                pn.setEmail(rs.getString(5));
                pn.setTrangThai(rs.getString(6));
                list.add(pn);
            }    
        }
        catch(Exception e){
            e.printStackTrace();   
        }
    	return list;

	}
}
