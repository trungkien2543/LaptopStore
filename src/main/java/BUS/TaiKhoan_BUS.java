package BUS;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.TaiKhoan_DAO;
import DTO.TaiKhoan;

public class TaiKhoan_BUS {
	private TaiKhoan_DAO hdDAO;
	private List<TaiKhoan> danhSachTK;
	
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
}
