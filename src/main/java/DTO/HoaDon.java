/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDateTime;
import java.util.Date;



/**
 *
 * @author DELL
 */
public class HoaDon {
    private int MaHD, SoLuong, TongTien;
    private LocalDateTime NgayLap;
    private String KhachHang, NhanVien;

    public HoaDon(int MaHD, int SoLuong, int TongTien, LocalDateTime NgayLap, String KhachHang, String NhanVien) {
        this.MaHD = MaHD;
        this.SoLuong = SoLuong;
        this.TongTien = TongTien;
        this.NgayLap = NgayLap;
        this.KhachHang = KhachHang;
        this.NhanVien = NhanVien;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public LocalDateTime getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(LocalDateTime NgayLap) {
        this.NgayLap = NgayLap;
    }

    public String getKhachHang() {
        return KhachHang;
    }

    public void setKhachHang(String KhachHang) {
        this.KhachHang = KhachHang;
    }

    public String getNhanVien() {
        return NhanVien;
    }

    public void setNhanVien(String NhanVien) {
        this.NhanVien = NhanVien;
    }
    
    
    
}
