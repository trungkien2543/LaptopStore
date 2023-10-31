/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhachHang_DAO;
import DTO.KhachHang;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class KhachHang_BUS {
    ArrayList<KhachHang> list;
    
    public KhachHang_BUS(){
        
    }
    
    public ArrayList<KhachHang> getListKhachHang(){
        list = new KhachHang_DAO().getListKhachHang();
        
        return list;
    }
    
    public String addKH(KhachHang kh){
        
        
        
        return "Thêm Khách hàng thất bại";
    }
}
