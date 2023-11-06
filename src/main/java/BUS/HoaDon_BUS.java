/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HoaDon_DAO;
import DTO.HoaDon;

/**
 *
 * @author DELL
 */
public class HoaDon_BUS {
    

    public HoaDon_BUS() {
        
    }
    
    public int LayMaHoaDon(){
        return new HoaDon_DAO().LayMaHoaDon();
    }
    
    public boolean ThemHoaDon(HoaDon hd){
        return new HoaDon_DAO().ThemHoaDon(hd);
    }
}
