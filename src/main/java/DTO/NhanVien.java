/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
public class NhanVien {
    private String MaNV, TenNV, SDT, DiaChi, NgaySinh, CCCD, Email, TrangThai;
    private boolean GioiTinh;

    public NhanVien(String MaNV, String TenNV, String SDT, String DiaChi, String NgaySinh, String CCCD, String Email, String TrangThai, boolean GioiTinh) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.NgaySinh = NgaySinh;
        this.CCCD = CCCD;
        this.Email = Email;
        this.TrangThai = TrangThai;
        this.GioiTinh = GioiTinh;
    }

    public NhanVien() {
        
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
    
    
    
}
