/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhaCungCap_DAO;
import DTO.NhaCungCap;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class NhaCungCap_BUS {
    private ArrayList<NhaCungCap> list;
    
    public NhaCungCap_BUS() {
        list = new NhaCungCap_DAO().getListNhaCungCap();
    }
    
     public ArrayList<NhaCungCap> getAllNhaCungCap() {
        list = new NhaCungCap_DAO().getListNhaCungCap();
        return list;
    }
    
    public ArrayList<NhaCungCap> getListNhaCungCap() {
        list = new NhaCungCap_DAO().getListNhaCungCap();
        return list;
    }
    
    public boolean KiemTraMa(String MaNCC){
        for (NhaCungCap ncc: list){
            if (ncc.getMaNCC().equals(MaNCC)){
                return true;
            }
        }
        return false;
    }
    
    
    
    public String addNhaCungCap(NhaCungCap ncc) {
        if (ncc.getTenNCC().isEmpty() || ncc.getSDT().isEmpty() || ncc.getDiaChi().isEmpty() || ncc.getEmail().isEmpty()) {
            return "Không được để trống thông tin";
        }
        
        //Kiểm tra mã ncc
        if(KiemTraMa(ncc.getMaNCC())){
            return "Mã nhà cung cấp đã tồn tại";
        }
        
        Long sdt;
      
        // Kiểm tra số điện thoại có chứa chữ không
        try {
            sdt = Long.parseLong(ncc.getSDT());
        } catch (NumberFormatException e) {
            return "Số điện thoại chỉ chứa số";
        }

        // Kiểm tra số điện thoại có đủ 10 số không
        if (ncc.getSDT().length() != 10) {
            return "Số điện thoại chỉ gồm 10 số";
        }
        
        //Kiểm tra email
        if (!ncc.getEmail().contains("@gmail.com")){
            return "Email nhập sai cú pháp";
        }

        // Thực hiện thêm vào cơ sở dữ liệu
        if (new NhaCungCap_DAO().addNhaCungCap(ncc)) {
            return "Thêm nhà cung cấp thành công";
        }
        return "Thêm nhà cung cấp thất bại";
    }

    public String capNhatNhaCungCap(NhaCungCap ncc) {
        if (ncc.getTenNCC().isEmpty() || ncc.getSDT().isEmpty() || ncc.getDiaChi().isEmpty() || ncc.getEmail().isEmpty()) {
            return "Không được để trống thông tin";
        }

        // Kiểm tra số điện thoại có chứa chữ không
        try {
            Long.parseLong(ncc.getSDT());
        } catch (NumberFormatException e) {
            return "Số điện thoại chỉ chứa số";
        }

        // Kiểm tra số điện thoại có đủ số ký tự không
        if (ncc.getSDT().length() != 10) {
            return "Số điện thoại chỉ gồm 10 số";
        }
        
        //Kiểm tra email
        if (!ncc.getEmail().contains("@gmail.com")){
            return "Email nhập sai cú pháp";
        }

        // Thực hiện cập nhật cơ sở dữ liệu
        if (new NhaCungCap_DAO().updateCungCap(ncc)) {
            return "Cập nhật thành công";
        }
        return "Cập nhật thất bại";
    }
    
    public String xoaNhaCungCap(String ncc){
        if (new NhaCungCap_DAO().deleteCungCap(ncc)){
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }
}
