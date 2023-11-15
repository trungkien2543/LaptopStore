/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
public class TaiKhoan {
    
    private String TenDN, MatKhau, PhanQuyen;

    public TaiKhoan(String TenDN, String MatKhau, String PhanQuyen) {
        this.TenDN = TenDN;
        this.MatKhau = MatKhau;
        this.PhanQuyen = PhanQuyen;
    }
    
    public TaiKhoan(){
           
    }
       
    public String getTenDN() {
        return TenDN;
    }

    public void setTenDN(String TenDN) {
        this.TenDN = TenDN;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getPhanQuyen() {
        return PhanQuyen;
    }

    public void setPhanQuyen(String PhanQuyen) {
        this.PhanQuyen = PhanQuyen;
    }
    
    
    
}
