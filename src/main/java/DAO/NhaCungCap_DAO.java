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
public class NhaCungCap_DAO {
    
    Connection con;

    public NhaCungCap_DAO() {
        con = new SQLConnection().getCon();  
    }
}
