/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

public class Laptop_DTO {
    private String ID, Ten, CPU, GPU, TrangThai;
    private int SoLuongTonKho, RAM,Gia;

    public Laptop_DTO(String ID, String Ten, String CPU, String GPU, String TrangThai, int SoLuongTonKho, int Gia, int RAM) {
        this.ID = ID;
        this.Ten = Ten;
        this.CPU = CPU;
        this.GPU = GPU;
        this.TrangThai = "1";
        this.SoLuongTonKho = 0;
        this.Gia=0;
        this.RAM = RAM;
    }

    public Laptop_DTO() {
      
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getSoLuongTonKho() {
        return SoLuongTonKho;
    }

    public void setSoLuongTonKho(int SoLuongTonKho) {
        this.SoLuongTonKho = SoLuongTonKho;
    }
    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }
    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }
    
    
   
    
}
