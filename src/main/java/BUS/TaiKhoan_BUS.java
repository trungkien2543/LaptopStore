package BUS;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.TaiKhoan_DAO;
import DTO.NhanVien;
import DTO.TaiKhoan;

public class TaiKhoan_BUS {
	private TaiKhoan_DAO hdDAO;
	private List<TaiKhoan> danhSachTK;
	List<TaiKhoan> list;
	
	public TaiKhoan_BUS(){
		hdDAO = new TaiKhoan_DAO();
		danhSachTK = getListTaiKhoan();
	}
	
	
	public List<TaiKhoan> getdanhSachTK() {
		return danhSachTK;
	}
	public void setdanhSachTK(List<TaiKhoan> danhSachTK) {
		this.danhSachTK = danhSachTK;
	}
	public List<TaiKhoan> getListTaiKhoan(){
		return hdDAO.getListTaiKhoan();
	}
	
	public void addHoaDon(TaiKhoan hd){
//		hdDAO.addHoaDon(hd);
		danhSachTK.add(hd);
	}
	
//	public void deleteHoaDonByMaHD(String maHD) {
//		for(TaiKhoan hd : danhSachTK )
//        {
//            if(hd.getMaHD().equals(maHD))
//            {
//            	ChiTietHoaDonBUS cthdBUS = new ChiTietHoaDonBUS();
//            	cthdBUS.deleteCTHDByMaHD(maHD);
//            	
//            	danhSachTK.remove(hd);
//            	hdDAO.deleteHoaDonByMaHD(maHD);
//                return;
//            }
//        }
//	}
	public NhanVien getNhanVienByTenDangNhap(String tenDangNhap) {
		return hdDAO.getNhanVienByTenDangNhap(tenDangNhap);
	}
	public NhanVien getNhanVienByEmail(String email) {
        return hdDAO.getNhanVienByEmail(email);
    }
	public TaiKhoan get(String Ma)
    {
        for(TaiKhoan tk : danhSachTK )
        {
            if(tk.getTenDN().equals(Ma))
            {
                return tk;
            }
        }
        return null;
    }
	
	public void set_table(JTable table) {
		table.removeAll();
		for(TaiKhoan hdDTO : danhSachTK) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[] {
        			hdDTO.getTenDN(),
        			hdDTO.getMatKhau(),
        			hdDTO.getPhanQuyen()
        			});
		}
	}
	
	
	
	public List<TaiKhoan> getListTaiKhoan2(){
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
        List<TaiKhoan> listTK = getListTaiKhoan2();
        ArrayList<TaiKhoan> searchTK = new ArrayList<TaiKhoan>();
        for( int i=0 ; i<listTK.size() ; i++ ) {
        	String tenDN = String.valueOf(listTK.get(i).getTenDN() );
        	if( tenDN.contains(tendn) )
        		searchTK.add(listTK.get(i) );
        }
        return searchTK;
    }
    
    public ArrayList<TaiKhoan> timTK_PhanQuyen(String pq){
        List<TaiKhoan> listTK = getListTaiKhoan2();
        ArrayList<TaiKhoan> searchTK = new ArrayList<TaiKhoan>();
        for( int i=0 ; i<listTK.size() ; i++ ) {
        	String phanquyen = String.valueOf(listTK.get(i).getPhanQuyen() );
        	if( phanquyen.contains(pq) )
        		searchTK.add(listTK.get(i) );
        }
        return searchTK;
    }
}
