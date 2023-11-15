package BUS;

import java.util.ArrayList;

import DAO.NhaCungCap_DAO;

public class NhaCungCap_BUS {
	NhaCungCap_DAO pnDAO = new NhaCungCap_DAO();
    
    public ArrayList<DTO.NhaCungCap> getAllNhaCungCap(){
        return pnDAO.getListNhaCungCap();
    }
}
