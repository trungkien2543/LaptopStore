/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
public class KhachHang {
    private String MaKH, Ten, SDT, DiaChi, TrangThai;
    private int TichDiem;

    public KhachHang(String MaKH, String Ten, String SDT, String DiaChi, String TrangThai, int TichDiem) {
        this.MaKH = MaKH;
        this.Ten = Ten;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.TrangThai = TrangThai;
        this.TichDiem = TichDiem;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
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

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getTichDiem() {
        return TichDiem;
    }

    public void setTichDiem(int TichDiem) {
        this.TichDiem = TichDiem;
    }
    
    
    
}
