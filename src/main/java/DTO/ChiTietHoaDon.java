/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
public class ChiTietHoaDon {
    private String IDRieng;
    private int MaHD, Gia;

    public ChiTietHoaDon(String IDRieng, int MaHD, int Gia) {
        this.IDRieng = IDRieng;
        this.MaHD = MaHD;
        this.Gia = Gia;
    }

    public String getIDRieng() {
        return IDRieng;
    }

    public void setIDRieng(String IDRieng) {
        this.IDRieng = IDRieng;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }
    
    
    
}
