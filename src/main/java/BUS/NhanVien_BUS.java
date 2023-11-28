/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.NhanVien_DAO;
import DTO.NhanVien;
import DTO.TaiKhoan;


import java.util.ArrayList;
import java.io.IOException;
import java.time.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class NhanVien_BUS {
    ArrayList<NhanVien> list;
    
    public NhanVien_BUS(){
        
    }
    
    public ArrayList<NhanVien> getListNhanVien(){
        list = new NhanVien_DAO().getListNhanVien();
        return list;
    }
    public ArrayList<NhanVien> getListNhanVien_now(){
        list = new NhanVien_DAO().getListNhanVien_now();
        return list;
    }
    
    
    
    public String themNV(NhanVien nv){
    	String[] date = nv.getNgaySinh().split("/");
        String day = date[0];
        String month = date[1];
        String year = date[2];
        nv.setNgaySinh(month+"/"+day+"/"+year);
        if( new NhanVien_DAO().addNhanVien(nv) ){
            return "Thêm thành công !";
        }
        return "Thêm thất bại";
    }
    public String themNV_excel(NhanVien nv){
    	String[] date = nv.getNgaySinh().split("-");
        String day = date[1];
        String month = date[1];
        String year = date[0];
        nv.setNgaySinh(month+"/"+day+"/"+year);
        if( new NhanVien_DAO().addNhanVien(nv) ){
            return "Thêm thành công !";
        }
        return "Thêm thất bại";
    }
    
    public String xoaNV(NhanVien nv){
        if( new NhanVien_DAO().delNhanVien(nv) ){
            return "Xóa thành công !";
        }
        return "Xóa thất bại";
    }
    
    public String suaNV(NhanVien nv){
    	String[] date = nv.getNgaySinh().split("/");
        String day = date[0];
        String month = date[1];
        String year = date[2];
        nv.setNgaySinh(month+"/"+day+"/"+year);
        if( new NhanVien_DAO().alterNhanVien(nv) ){
            return "Sửa thành công !";
        }
        return "Sửa thất bại";
    }
    
    public ArrayList<NhanVien> timNV_MaNV(String id){
        ArrayList<NhanVien> listNV = getListNhanVien_now();
        ArrayList<NhanVien> searchNV = new ArrayList<NhanVien>();
        for( int i=0 ; i<listNV.size() ; i++ ) {
        	String maNV = String.valueOf(listNV.get(i).getMaNV() );
        	if( maNV.toLowerCase().contains(id.toLowerCase()) )
        		searchNV.add(listNV.get(i) );
        }
        return searchNV;
    }
    
    public ArrayList<NhanVien> timNV_TenNV(String id){
        ArrayList<NhanVien> listNV = getListNhanVien_now();
        ArrayList<NhanVien> searchNV = new ArrayList<NhanVien>();
        for( int i=0 ; i<listNV.size() ; i++ ) {
        	String tenNV = String.valueOf(listNV.get(i).getTenNV() );
        	if( tenNV.toLowerCase().contains(id.toLowerCase()) )
        		searchNV.add(listNV.get(i) );
        }
        return searchNV;
    }
    
    public String[] getListNhanVien_maNV_noTK() {
    	ArrayList<String> data = new NhanVien_DAO().getListNhanVien_noTK();
    	int n = data.size();
    	String list_maNV[] = new String[n];
    	for( int i=0 ; i<n ; i++ ) 
    		list_maNV[i] = data.get(i);
    	return list_maNV;
    }
    
    
    public String checkNV(NhanVien nv){
        if( !checkNV_SDT(nv.getSDT()) )
            return "Số điện thoại không hợp lệ !";
        if( !checkNV_NS(nv.getNgaySinh()) )
            return "Ngày sinh không hợp lệ !";
        if( !checkNV_CCCD(nv.getCCCD()) )
            return "CCCD không hợp lệ !";
        if( !checkNV_Email(nv.getEmail()) )
            return "Email không hợp lệ !";
        return "1";
    }
    
    public boolean checkNV_SDT(String sdt){
        if( !sdt.matches("[0-9]{10}") )
            return false;
        return true;
    }
    public boolean checkNV_NS(String ngaysinh){
        if( ngaysinh.matches("(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/([12]\\d{3})") ){
            String[] date = ngaysinh.split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            if( month == 4 || month == 6 || month == 9 || month == 11 ){
                if( day > 30 )
                    return false;
            }
            else if( month == 2 )
                if( day > 28 )
                    return false;
            else
                if( day > 31 )
                    return false;
            LocalDate date_now = LocalDate.now();
            int day_now = date_now.getDayOfMonth();
            int month_now = date_now.getMonth().getValue();
            int year_now = date_now.getYear();
            if( year_now < year )
                return false;
            if( year_now == year && month_now < month )
                return false;
            if( year_now == year && month_now == month && day_now < day )
                return false;         
        }
        else
        {
            return false;
        }
        return true;
    }
    public boolean checkNV_CCCD(String cccd){
        if( !cccd.matches("[0-9]{12}") )
            return false;
        return true;
    }
    public boolean checkNV_Email(String email){
        if( !email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"))
            return false;
        return true;
    }
    
	public static final int COLUMN_INDEX_MaNV = 0;
    public static final int COLUMN_INDEX_TenNV = 1;
    public static final int COLUMN_INDEX_GioiTinh = 2;
    public static final int COLUMN_INDEX_SDT = 3;
    public static final int COLUMN_INDEX_DiaChi = 4;
    public static final int COLUMN_INDEX_NgaySinh = 5;
    public static final int COLUMN_INDEX_CCCD = 6;
    public static final int COLUMN_INDEX_Email = 7;
    public String import_excel( String excelFilePath ) throws IOException{
    	try {
	    	// Get file
	        InputStream inputStream = new FileInputStream(new File(excelFilePath));
	        Workbook workbook = getWorkbook(inputStream, excelFilePath);
	        Sheet sheet = workbook.getSheetAt(0);
	        Iterator<Row> iterator = sheet.iterator();
	        while (iterator.hasNext()) {
	            Row nextRow = iterator.next();
	            if (nextRow.getRowNum() == 0) {
	                // Ignore header
	                continue;
	            }
	 
	            // Get all cells
	            Iterator<Cell> cellIterator = nextRow.cellIterator();
	            NhanVien nv = new NhanVien();
	            while (cellIterator.hasNext()) {
	                //Read cell
	                Cell cell = cellIterator.next();
	                Object cellValue = getCellValue(cell);
	                if (cellValue == null || cellValue.toString().isEmpty()) {
	                    continue;
	                }
	                // Set value for NhanVien object
	                int columnIndex = cell.getColumnIndex();
	                switch (columnIndex) {
	                case COLUMN_INDEX_MaNV:
	                	nv.setMaNV((String) getCellValue(cell));
	                    break;
	                case COLUMN_INDEX_TenNV:
	                	nv.setTenNV((String) getCellValue(cell));
	                    break;
	                case COLUMN_INDEX_GioiTinh:
	                	String gioitinh = (String) getCellValue(cell);
	                	if( gioitinh.equals("Nam") )
	                		nv.setGioiTinh(true);
	                	else
	                		nv.setGioiTinh(false);
	                    break;
	                case COLUMN_INDEX_SDT:
	                	nv.setSDT((String) getCellValue(cell));
	                    break;
	                case COLUMN_INDEX_DiaChi:
	                	nv.setDiaChi((String) getCellValue(cell));
	                    break;
	                case COLUMN_INDEX_NgaySinh:
	                	nv.setNgaySinh((String) getCellValue(cell));
	                    break;
	                case COLUMN_INDEX_CCCD:
	                	nv.setCCCD((String) getCellValue(cell));
	                    break;
	                case COLUMN_INDEX_Email:
	                	nv.setEmail((String) getCellValue(cell));
	                    break;
	                default:
	                    break;
	                }
	                nv.setTrangThai("1");
	            }
	            TaiKhoan tk = new TaiKhoan(nv.getMaNV(),"123456","Nhanvien");
	            System.out.println("1");
	            System.out.println(nv.getMaNV());
	            System.out.println(nv.getTenNV());
	            System.out.println(nv.isGioiTinh());
	            System.out.println(nv.getSDT());
	            System.out.println(nv.getDiaChi());
	            System.out.println(nv.getNgaySinh());
	            System.out.println(nv.getCCCD());
	            System.out.println(nv.getEmail());
	            themNV_excel(nv);
	            System.out.println("2");
	            new TaiKhoan_BUS().themTK(tk);
	            System.out.println("3");
	        }
	        workbook.close();
	        inputStream.close();
	    	return "Import thành công ! ";
    	}
    	catch( Exception e ) {
    		return "Import thất bại ! ";
    	}
    }
    
    private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
 
        return workbook;
    }
    private static Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellType();
        Object cellValue = null;
        switch (cellType) {
        case BOOLEAN:
            cellValue = cell.getBooleanCellValue();
            break;
        case FORMULA:
            Workbook workbook = cell.getSheet().getWorkbook();
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            cellValue = evaluator.evaluate(cell).getNumberValue();
            break;
        case NUMERIC:
            cellValue = cell.getNumericCellValue();
            break;
        case STRING:
            cellValue = cell.getStringCellValue();
            break;
        case _NONE:
        case BLANK:
        case ERROR:
            break;
        default:
            break;
        }
 
        return cellValue;
    }
    
    
    public String export_excel( ArrayList<NhanVien> list, String excelFilePath ){
    	// Create Workbook
    	try {
	        Workbook workbook = getWorkbook(excelFilePath);
	 
	        // Create sheet
	        Sheet sheet = workbook.createSheet("Nhân viên"); // Create sheet with sheet name
	 
	        int rowIndex = 0;
	         
	        // Write header
	        writeHeader(sheet, rowIndex);
	 
	        // Write data
	        rowIndex++;
	        for (NhanVien nv : list) {
	            // Create row
	            Row row = sheet.createRow(rowIndex);
	            // Write data on row
	            writeBook(nv, row);
	            rowIndex++;
	        }
	 
	        // Auto resize column witdth
	        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
	        autosizeColumn(sheet, numberOfColumn);
	 
	        // Create file excel
	        createOutputFile(workbook, excelFilePath);
	    	return "Export thành công !";
    	}
    	catch( Exception e ) {
    		return "Export thất bại !";
    	}
    }
    private static Workbook getWorkbook(String excelFilePath) throws IOException {
        Workbook workbook = null;
 
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
 
        return workbook;
    }
    
 // Write header with format
    private static void writeHeader(Sheet sheet, int rowIndex) {
        // create CellStyle
         
        // Create row
        Row row = sheet.createRow(rowIndex);
         
        // Create cells
        Cell cell = row.createCell(COLUMN_INDEX_MaNV);
        cell.setCellValue("ID");
 
        cell = row.createCell(COLUMN_INDEX_TenNV);
        cell.setCellValue("Họ tên");
 
        cell = row.createCell(COLUMN_INDEX_GioiTinh);
        cell.setCellValue("Giới tính");
 
        cell = row.createCell(COLUMN_INDEX_SDT);
        cell.setCellValue("SDT");
 
        cell = row.createCell(COLUMN_INDEX_DiaChi);
        cell.setCellValue("Địa chỉ");
        
        cell = row.createCell(COLUMN_INDEX_NgaySinh);
        cell.setCellValue("Ngày sinh");
        
        cell = row.createCell(COLUMN_INDEX_CCCD);
        cell.setCellValue("CCCD");
        
        cell = row.createCell(COLUMN_INDEX_Email);
        cell.setCellValue("Email");
    }
    
 // Write data
    private static void writeBook(NhanVien nv, Row row) {
         
        Cell cell = row.createCell(COLUMN_INDEX_MaNV);
        cell.setCellValue(nv.getMaNV());
 
        cell = row.createCell(COLUMN_INDEX_TenNV);
        cell.setCellValue(nv.getTenNV());
 
        cell = row.createCell(COLUMN_INDEX_GioiTinh);
        if( nv.isGioiTinh() )
        	cell.setCellValue("Nam");
        else
        	cell.setCellValue("Nữ");
 
        cell = row.createCell(COLUMN_INDEX_SDT);
        cell.setCellValue(nv.getSDT());
        
        cell = row.createCell(COLUMN_INDEX_DiaChi);
        cell.setCellValue(nv.getDiaChi());
        
        cell = row.createCell(COLUMN_INDEX_NgaySinh);
        cell.setCellValue(nv.getNgaySinh());
        
        cell = row.createCell(COLUMN_INDEX_CCCD);
        cell.setCellValue(nv.getCCCD());
        
        cell = row.createCell(COLUMN_INDEX_Email);
        cell.setCellValue(nv.getEmail());
         
    }
     
    // Auto resize column width
    private static void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }
     
    // Create output file
    private static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }
    
}