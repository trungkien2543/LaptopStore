/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChiTietHoaDon_DAO;
import DTO.ChiTietHoaDon;

/**
 *
 * @author DELL
 */
public class ChiTietHoaDon_BUS {

    public ChiTietHoaDon_BUS() {
    }
    
    public boolean ThemChiTietHoaDon(ChiTietHoaDon ct){
       return new ChiTietHoaDon_DAO().ThemChiTietHoaDon(ct);
    }
    
}
