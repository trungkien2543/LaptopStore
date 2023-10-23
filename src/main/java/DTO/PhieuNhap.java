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
public class PhieuNhap {
    private int MaPhieu, TongTien;
    private Date NgayNhap;
    private String NhaCungCap, NhanVien;

    public PhieuNhap(int MaPhieu, int TongTien, Date NgayNhap, String NhaCungCap, String NhanVien) {
        this.MaPhieu = MaPhieu;
        this.TongTien = TongTien;
        this.NgayNhap = NgayNhap;
        this.NhaCungCap = NhaCungCap;
        this.NhanVien = NhanVien;
    }

    public int getMaPhieu() {
        return MaPhieu;
    }

    public void setMaPhieu(int MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public String getNhaCungCap() {
        return NhaCungCap;
    }

    public void setNhaCungCap(String NhaCungCap) {
        this.NhaCungCap = NhaCungCap;
    }

    public String getNhanVien() {
        return NhanVien;
    }

    public void setNhanVien(String NhanVien) {
        this.NhanVien = NhanVien;
    }
    
    
    
}
