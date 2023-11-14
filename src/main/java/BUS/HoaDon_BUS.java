/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HoaDon_DAO;
import DTO.HoaDon;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class HoaDon_BUS {
    HoaDon_DAO hdDAO = new HoaDon_DAO();
    public ArrayList<HoaDon> getAllHoaDon(){
        return hdDAO.getListHoaDon();
    }
     public ArrayList<HoaDon> getListTimKiem(String Loai, String From, String To){
        return hdDAO.TimKiem(Loai, From, To);
    }
    public HoaDon_BUS() {
        
    }
    
    public int LayMaHoaDon(){
        return new HoaDon_DAO().LayMaHoaDon() + 1;
    }
    
    public boolean ThemHoaDon(HoaDon hd){
        return new HoaDon_DAO().ThemHoaDon(hd);
    }
}
