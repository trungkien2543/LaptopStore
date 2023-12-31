/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Laptop_DAO;
import DTO.Laptop;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Laptop_BUS {
    
    Laptop_DAO laptopDAO = new Laptop_DAO();
    
    public ArrayList<Laptop> getAllLaptop(){
        return laptopDAO.getListLaptop();
    }
    
    public String addLaptop(Laptop laptop, String kiemtra){
        if(laptop.getRAM()<=0){
            return"Ram phải lớn hơn 0!";
        }
        if(laptop.getGia()<=0){
            return "Giá phải lớn hơn 0!";
        }
        
        if(kiemtra.equals("add")){
            if(laptopDAO.addLaptop(laptop)){
                return "Thêm thành công";
            }
        }
        else{
            if(laptopDAO.editLaptopDaXoa(laptop)){
                return "Thêm thành công";
            }
        }
        return "Thêm thất bại";
    }
    public String editLaptop(Laptop laptop){
        if(laptop.getRAM()<=0){
            return"Ram phải lớn hơn 0!";
        }
        if(laptop.getGia()<=0){
            return "Giá phải lớn hơn 0!";
        }
        
        if(laptopDAO.editLaptop(laptop)){
            return "Sửa thành công";
        }
        return "Sửa thất bại";
    }
    public boolean TruSoLuongTonKho(int sl,String id){
        return new Laptop_DAO().TruSoLuongTonKho(sl, id);
    }
    
}
