/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class ChiTietLaptop {
    private String IDRieng, TrangThai, MauLapTop;
    private Date NgayNhap;

    public ChiTietLaptop(String IDRieng, String TrangThai, String MauLapTop, Date NgayNhap) {
        this.IDRieng = IDRieng;
        this.TrangThai = TrangThai;
        this.MauLapTop = MauLapTop;
        this.NgayNhap = NgayNhap;
    }

    public ChiTietLaptop() {
    }

    

    public String getIDRieng() {
        return IDRieng;
    }

    public void setIDRieng(String IDRieng) {
        this.IDRieng = IDRieng;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMauLapTop() {
        return MauLapTop;
    }

    public void setMauLapTop(String MauLapTop) {
        this.MauLapTop = MauLapTop;
    }


    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }
    
    
    
}
