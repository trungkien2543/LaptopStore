/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChiTietLaptop_DAO;
import DAO.Laptop_DAO;
import DTO.ChiTietLaptop_DTO;
import DTO.Laptop;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ChiTietLaptop_BUS {
     ArrayList<ChiTietLaptop_DTO> list;
    
    public ChiTietLaptop_BUS(){
        
    }
    
    public ArrayList<ChiTietLaptop_DTO> getListChiTietLaptop(){
        ArrayList<ChiTietLaptop_DTO> list = new ChiTietLaptop_DAO().getListChiTietLaptop();
        
        return list;
    }
    
    public boolean CapNhatTrangThai(String trangthai, String idRieng){
        return new ChiTietLaptop_DAO().CapNhatTrangThai(trangthai, idRieng);
    }
    
    
    
}
