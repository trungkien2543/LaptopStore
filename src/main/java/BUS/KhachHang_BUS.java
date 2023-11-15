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
    
    public String addKH_BanHang(KhachHang kh){
        if (kh.getSDT().isEmpty() || kh.getTen().isEmpty() || kh.getDiaChi().isEmpty()){
            return "Không được để trống thông tin";
        }
        // Kiểm tra số điện thoại có chứa chữ không
        try{
            int x = Integer.parseInt(kh.getSDT());
        }
        catch(NumberFormatException e){
            return "Số điện thoại chỉ chứa số";
        }
        // Kiểm tra số điện thoại có đủ 10 hoặc 11 số ko
        if (kh.getSDT().length() != 10){
            return "Số điện thoại chỉ gồm 10";
        }
        
        // Thêm 1 số thông tin cơ bản để khởi tạo
        kh.setMaKH(Integer.toString(new KhachHang_DAO().LayMaKH() + 1));
        kh.setTrangThai("1");
        kh.setTichDiem(0);
        // Thực hiện thêm vào database
        if (new KhachHang_DAO().addKhachHang(kh)){
            return "Thêm khách hàng thành công";
        }
        return "Thêm Khách hàng thất bại";
    }
    
    public boolean TichDiem(int DiemHT, int DiemThem, String MaKH){
        return new KhachHang_DAO().TichDiem(DiemHT+DiemThem, MaKH);
    }
    
    public String updateUser(KhachHang kh){
        if (kh.getSDT().isEmpty() || kh.getTen().isEmpty() || kh.getDiaChi().isEmpty()){
            return "Không được để trống thông tin";
        }
        // Kiểm tra số điện thoại có chứa chữ không
        try{
            int x = Integer.parseInt(kh.getSDT());
        }
        catch(NumberFormatException e){
            return "Số điện thoại chỉ chứa số";
        }
        // Kiểm tra số điện thoại có đủ 10 hoặc 11 số ko
        if (kh.getSDT().length() != 10){
            return "Số điện thoại chỉ gồm 10";
        }
        
        // Thêm 1 số thông tin cơ bản để khởi tạo
//        kh.setMaKH(kh.getSDT());

        // Thực hiện thêm vào database
        if (new KhachHang_DAO().updateUser(kh)){
            return "Success";
        }
        return "Fail";
    }
}
