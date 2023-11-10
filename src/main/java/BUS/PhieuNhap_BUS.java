/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PhieuNhap_DAO;
import DTO.PhieuNhap;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class PhieuNhap_BUS {
    PhieuNhap_DAO pnDAO = new PhieuNhap_DAO();
    
    public ArrayList<PhieuNhap> getAllPhieuNhap(){
        return pnDAO.getListPhieuNhap();
    }
    
    public String getNewCode(){
        int NewCode = pnDAO.getMaxMaPhieuNhap()+1;
        return Integer.toString(NewCode);
    }
//    public String addPhieuNhap(DTOPhieuNhap pn){
//        if(pnDAO.insertPhieuNhap(pn)){
//            return "Thêm phiếu nhập thành công";
//        }
//        return "Thêm phiếu nhập thất bại";
//    }
//    
//    public void deletePhieuNhap(DTOPhieuNhap pn){
//        if(pnDAO.deletePhieuNhap(pn.getMaPhieu())){
//            
//        }
//    }
//    
//    public ArrayList<DTOPhieuNhap> getListTimKiem(String Loai, String From, String To){
//        return pnDAO.TimKiem(Loai, From, To);
//    }
//    
//     public ArrayList<DTOThongKeSoTien> getListThongKe(){
//        return pnDAO.getListThongKe();
//    }
    
}
