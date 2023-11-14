/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChiTietPhieu_DAO;
import DTO.ChiTietPhieu;
import DTO.PhieuNhap;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ChiTietPhieuNhap_BUS {
    ChiTietPhieu_DAO ctpn_DAO = new ChiTietPhieu_DAO();
    ArrayList<ChiTietPhieu> list = new ArrayList<>();
    int a;
    public ArrayList<ChiTietPhieu> getALLChiTietPhieuNhap(){
        return ctpn_DAO.getListChiTietPhieuNhap(a);
    }
    
    public ArrayList<ChiTietPhieu> getTheoMaPhieuNhap(PhieuNhap pn){
        ArrayList<ChiTietPhieu> list1 = new ArrayList<>();
        for(ChiTietPhieu s : list){
            if(pn.getMaPhieu()== s.getMaPhieu()){
                list1.add(s);
            }
        }
        return list1;
    }
    
    public String addChiTietPhieuNhap(ChiTietPhieu s){
        if(ctpn_DAO.addChiTietPhieuNhap(s)){
            return "Thêm chi tiết phiếu nhập thành công";
        }
        return "Xảy ra lỗi";
    }
    
    public void deleteChiTietPhieuNhap(PhieuNhap s){
        if(ctpn_DAO.deleteChiTietPhieuNhap(s.getMaPhieu())){
            
        }
    }
    
}
