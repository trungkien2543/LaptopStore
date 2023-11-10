/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ThongKe_DAO;
import DTO.ThongKeTinhHinh;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class ThongKe_BUS {
    
    final static  DateFormat ChuyenNgaySQL = new SimpleDateFormat("MM/dd/yyyy");

    public ThongKe_BUS() {
    }
    
    public ArrayList<ThongKeTinhHinh> getListTinhHinh(Date from, Date to){
        String From_str = ChuyenNgaySQL.format(from);
        String To_str = ChuyenNgaySQL.format(to)+" 23:59:59";
        System.out.println(From_str + "                           "+To_str);
        return new ThongKe_DAO().getListTinhHinh(From_str, To_str);
    }
    
}
