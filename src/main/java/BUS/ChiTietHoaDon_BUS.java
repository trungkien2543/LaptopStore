/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChiTietHoaDon_DAO;
import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ChiTietHoaDon_BUS {
    ChiTietHoaDon_DAO cthd_DAO = new ChiTietHoaDon_DAO();
    ArrayList<ChiTietHoaDon> list = new ArrayList<>();
    int a;
    public ArrayList<ChiTietHoaDon> getALLChiTietHoaDon(int a){
        return cthd_DAO.getListChiTietHoaDon(a);
    }
    
    public boolean ThemChiTietHoaDon(ChiTietHoaDon ct){
       return new ChiTietHoaDon_DAO().ThemChiTietHoaDon(ct);
    }
    
}
