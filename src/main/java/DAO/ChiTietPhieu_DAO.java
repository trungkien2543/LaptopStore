/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DELL
 */
public class ChiTietPhieu_DAO {
    
    Connection con;

    public ChiTietPhieu_DAO() {
        con = new SQLConnection().getCon(); 
    }
    
}
