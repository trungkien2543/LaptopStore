/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
public class ChiTietPhieu {
    private String IDRieng;
    private int Gia, MaPhieu,SoLuong;
    public ChiTietPhieu(){
        this.IDRieng=null;
        this.Gia=0;
        this.MaPhieu=0;
        this.SoLuong=0;
    }

    public ChiTietPhieu(String IDRieng, int Gia, int MaPhieu,int SoLuong) {
        this.IDRieng = IDRieng;
        this.Gia = Gia;
        this.MaPhieu = MaPhieu;
        this.SoLuong=SoLuong;
    }

    public String getIDRieng() {
        return IDRieng;
    }

    public void setIDRieng(String IDRieng) {
        this.IDRieng = IDRieng;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public int getMaPhieu() {
        return MaPhieu;
    }

    public void setMaPhieu(int MaPhieu) {
        this.MaPhieu = MaPhieu;
    }
    
    public int getSoLuong(){
        return SoLuong;
    }
    
    public void setSoLuong(int SoLuong){
        this.SoLuong=SoLuong;
    }
    
}
