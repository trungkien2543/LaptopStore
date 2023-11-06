/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Laptop_DAO;
import DTO.Laptop;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Laptop_BUS {
    
    ArrayList<Laptop> list;
    
    public Laptop_BUS(){
        
    }
    
    public ArrayList<Laptop> getListLaptop(){
        list = new Laptop_DAO().getListLaptop();
        
        return list;
    }
    
    public String addLaptop(Laptop laptop){
        return "Thêm laptop thất bại";
    }
    
    public boolean TruSoLuongTonKho(int sl,String id){
        return new Laptop_DAO().TruSoLuongTonKho(sl, id);
    }
    
}
