/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
public class ThongKeDoanhThu {
    private int Thang;
    private long TienNhap, TienBan;

    public ThongKeDoanhThu(int Thang, long TienNhap, long TienBan) {
        this.Thang = Thang;
        this.TienNhap = TienNhap;
        this.TienBan = TienBan;
    }

    public int getThang() {
        return Thang;
    }

    public void setThang(int Thang) {
        this.Thang = Thang;
    }

    public long getTienNhap() {
        return TienNhap;
    }

    public void setTienNhap(long TienNhap) {
        this.TienNhap = TienNhap;
    }

    public long getTienBan() {
        return TienBan;
    }

    public void setTienBan(long TienBan) {
        this.TienBan = TienBan;
    }
    
    public long DoanhThu(){
        return this.TienBan - this.TienNhap;
    }
}
