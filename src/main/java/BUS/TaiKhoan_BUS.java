/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.TaiKhoan_DAO;
import DTO.NhanVien;
import DTO.TaiKhoan;
import java.util.ArrayList;


public class TaiKhoan_BUS {
    ArrayList<TaiKhoan> list;
    
    public TaiKhoan_BUS(){
        
    }
    
    public ArrayList<TaiKhoan> getListTaiKhoan(){
        list = new TaiKhoan_DAO().getListTaiKhoan();
        return list;
    }
    
    
    public String themTK(TaiKhoan tk){
        if( new TaiKhoan_DAO().addTaiKhoan(tk) ){
            return "Thêm thành công !";
        }
        return "Thêm thất bại";
    }
    
    public String xoaTK(TaiKhoan tk){
        if( new TaiKhoan_DAO().delTaiKhoan(tk) ){
            return "Xóa thành công !";
        }
        return "Xóa thất bại";
    }
    
    public String suaTK(TaiKhoan tk){
        if( new TaiKhoan_DAO().alterTaiKhoan(tk) ){
            return "Sửa thành công !";
        }
        return "Sửa thất bại";
    }
    
    public TaiKhoan timTK( String tendn ) {
    	return new TaiKhoan_DAO().findTaiKhoan(tendn);
    }
    
    public ArrayList<TaiKhoan> timTK_TenDN(String tendn){
        ArrayList<TaiKhoan> listTK = getListTaiKhoan();
        ArrayList<TaiKhoan> searchTK = new ArrayList<TaiKhoan>();
        for( int i=0 ; i<listTK.size() ; i++ ) {
        	String tenDN = String.valueOf(listTK.get(i).getTenDN() );
        	if( tenDN.contains(tendn) )
        		searchTK.add(listTK.get(i) );
        }
        return searchTK;
    }
    
    public ArrayList<TaiKhoan> timTK_PhanQuyen(String pq){
        ArrayList<TaiKhoan> listTK = getListTaiKhoan();
        ArrayList<TaiKhoan> searchTK = new ArrayList<TaiKhoan>();
        for( int i=0 ; i<listTK.size() ; i++ ) {
        	String phanquyen = String.valueOf(listTK.get(i).getPhanQuyen() );
        	if( phanquyen.contains(pq) )
        		searchTK.add(listTK.get(i) );
        }
        return searchTK;
    }
}
