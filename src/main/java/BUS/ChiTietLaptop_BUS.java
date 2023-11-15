/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChiTietLaptop_DAO;
import DAO.Laptop_DAO;
import DTO.ChiTietLaptop;
import DTO.Laptop;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ChiTietLaptop_BUS {
     ArrayList<ChiTietLaptop> list;
    
    public ChiTietLaptop_BUS(){
        
    }
    
    public ArrayList<ChiTietLaptop> getListChiTietLaptop(){
        ArrayList<ChiTietLaptop> list = new ChiTietLaptop_DAO().getListChiTietLaptop();
        
        return list;
    }
    
    public boolean CapNhatTrangThai(String trangthai, String idRieng){
        return new ChiTietLaptop_DAO().CapNhatTrangThai(trangthai, idRieng);
    }
    
    public boolean addChiTietLaptop(DTO.ChiTietLaptop ct) {
    	return new ChiTietLaptop_DAO().addChiTietLaptop(ct);
	}
    
}
