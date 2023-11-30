/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.ChiTietLaptop_BUS;
import BUS.HoaDon_BUS;
import BUS.KhachHang_BUS;
import BUS.Laptop_BUS;
import BUS.TaiKhoan_BUS;
import DAO.ChiTietHoaDon_DAO;
import DTO.ChiTietHoaDon;
import DTO.ChiTietLaptop;
import DTO.HoaDon;
import DTO.KhachHang;
import DTO.Laptop;
import DTO.NhanVien;
import DTO.TaiKhoan;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.util.Timer;
import java.util.TimerTask;


/**
 *
 * @author DELL
 */
public class BanHang extends javax.swing.JFrame {
    
    public static NhanVien NV;
    
    public TaiKhoan TK;
    
    DefaultTableModel model, model_gh, model_cthd;

    ArrayList<Laptop> list_mh;
    
    ArrayList<ChiTietLaptop> list_ct;
    
    ArrayList<KhachHang> list_kh;
    
    long TongTien_int;
    int TichDiem;
    
    static final long GiaTriTichDiem = 10000000;
    
    //phuong thuc de in 1 so ra thanh tien te trong java
    Locale localVN = new Locale("vi", "VN");
    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localVN);
    
    // Định dạng ngày giờ theo định dạng mong muốn (ví dụ: yyyy-MM-dd HH:mm:ss)
    DateTimeFormatter NgayGio = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    DateTimeFormatter Ngay = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    

    /**
     * Creates new form Test
     */
    public BanHang(NhanVien NV) {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        
        // cài mã NV
        
        this.NV = NV;
        
        // Khóa ô tích điểm
        txtTichDiem.setEditable(false);
        
        
        ListSelectionModel selectionModel = tblChiTietHoaDon.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Chọn một hàng duy nhất
        
        ListSelectionModel selectionModel1 = tblGioHang.getSelectionModel();
        selectionModel1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Chọn một hàng duy nhất
       
        ListSelectionModel selectionModel2 = tblMatHang.getSelectionModel();
        selectionModel2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Chọn một hàng duy nhất

        
        // Thực hiện lặp lại thời gian liên tục
        
        Timer timer = new Timer();

        // Đặt hàm cần thực hiện lại sau mỗi 1000 milliseconds (1 giây)
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                LocalDateTime ngayGioHienTai = LocalDateTime.now();
                String ngayGioDinhDang = ngayGioHienTai.format(NgayGio);
                txtNgayLap.setText(ngayGioDinhDang);
            }
        }, 0, 1000);
        
        

        Reset(); 
        
        // Tìm thông tin nhân viên vừa đăng nhập
        TimTaiKhoan(NV);
        
        // phân quyên
        PhanQuyen(TK);
    }  
    
    
    public void TimTaiKhoan(NhanVien NV){
        List<TaiKhoan> list_TaiKhoan = new TaiKhoan_BUS().getListTaiKhoan();
        for(TaiKhoan tk : list_TaiKhoan){
            if (tk.getTenDN().equals(NV.getMaNV())){
                TK = tk;
                lblName.setText(NV.getTenNV());
                lblChucVu.setText(TK.getPhanQuyen());
                return;
            }
        }
    }
    
    public void PhanQuyen(TaiKhoan TK){
        if (TK.getPhanQuyen().equals("Nhanvien")){
            lblNCC.setVisible(false);
            lblNhanVien.setVisible(false);
            lblNhapHang.setVisible(false);
            lblTaiKhoan.setVisible(false);
            lblKhoHang.setVisible(false);
        }
    }
    
    
    
    
    
    public void Reset(){
        // Gọi model để thao tác với dữ liệu trên bảng
        model = (DefaultTableModel) tblMatHang.getModel();
        
        model_gh = (DefaultTableModel) tblGioHang.getModel();
        model_gh.setRowCount(0);
        
        model_cthd = (DefaultTableModel)tblChiTietHoaDon.getModel();
        model_cthd.setRowCount(0);
        
        // Gọi danh sách các mặt hàng
        list_mh = new Laptop_BUS().getAllLaptop();
        list_ct = new ChiTietLaptop_BUS().getListChiTietLaptop();
        list_kh = new KhachHang_BUS().getListKhachHang();
        
        //Hiển thị danh sách các mặt hàng
        showTableMatHang();
        
        // Chọn tab đầu tiên
        jtab.setSelectedIndex(0);
        
        // Khóa một số chức năng khi bảng giỏ hàng rỗng
        jtab.setEnabledAt(1, false);
        btnXoa.setEnabled(false);
        
        // Khóa nút thêm khách hàng
        btnAddKH.setEnabled(false);
        btnThanhToan.setEnabled(false);
        
        // Khởi tạo tổng tiền
        TongTien_int = 0;
        
        // Khởi tạo điểm
        TichDiem = 0;
        
        // reset lại vùng nhập thông tin khách hàng
        txtSDT.setText("");
        txtTen.setText("");
        txtDiaChi.setText("");
        txtTichDiem.setText("0");
    }
    
    public void showTableMatHang(){
        model.setRowCount(0);
        for (Laptop laptop : list_mh) {
            if (laptop.getTrangThai().equals("1") && laptop.getSoLuongTonKho() > 0){
                model.addRow(new Object[]{laptop.getID(),laptop.getTen(),laptop.getCPU(),laptop.getRAM(),laptop.getGPU(),currencyVN.format(laptop.getGia()),laptop.getSoLuongTonKho()});
            }
            
        }
        tblMatHang.setModel(model);
        
    }
    
    public long TimGia(String id){
        for (Laptop l : list_mh){
            if (l.getID().equals(id)){
                return l.getGia();
            }     
        }
        return 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jpThanhTieuDe = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jpMenu = new javax.swing.JPanel();
        lblAvatar = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblChucVu = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblKhoHang = new javax.swing.JLabel();
        lblNhapHang = new javax.swing.JLabel();
        lblBanHang = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        lblKhachHang = new javax.swing.JLabel();
        lblNCC = new javax.swing.JLabel();
        lblPhieuNhap = new javax.swing.JLabel();
        lblHoaDon = new javax.swing.JLabel();
        lblThongKe = new javax.swing.JLabel();
        lblTaiKhoan = new javax.swing.JLabel();
        jtab = new javax.swing.JTabbedPane();
        jpKho = new javax.swing.JPanel();
        txtFind = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMatHang = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        cbxTieuChi = new javax.swing.JComboBox<>();
        jpHoaDon = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblChiTietHoaDon = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTichDiem = new javax.swing.JTextField();
        btnAddKH = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JLabel();
        txtNgayLap = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSL = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTongTIen = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtDiemTichThem = new javax.swing.JLabel();

        jLabel13.setText("jLabel13");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setPreferredSize(new java.awt.Dimension(1500, 740));

        jpThanhTieuDe.setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("HỆ THỐNG QUẢN LÝ CỬA HÀNG LAPTOP");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/LOGO.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Profile.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Logout.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpThanhTieuDeLayout = new javax.swing.GroupLayout(jpThanhTieuDe);
        jpThanhTieuDe.setLayout(jpThanhTieuDeLayout);
        jpThanhTieuDeLayout.setHorizontalGroup(
            jpThanhTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpThanhTieuDeLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(12, 12, 12))
        );
        jpThanhTieuDeLayout.setVerticalGroup(
            jpThanhTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpThanhTieuDeLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpThanhTieuDeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpThanhTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jpMenu.setBackground(new java.awt.Color(255, 255, 255));

        lblAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Avatar.png"))); // NOI18N

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblName.setText("Lê Hoài Nam");

        lblChucVu.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblChucVu.setText("Quản lý");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Line.png"))); // NOI18N

        lblKhoHang.setBackground(new java.awt.Color(255, 255, 255));
        lblKhoHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblKhoHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/KhoHang.png"))); // NOI18N
        lblKhoHang.setText("Kho hàng");
        lblKhoHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKhoHangMouseClicked(evt);
            }
        });

        lblNhapHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/NhapHang.png"))); // NOI18N
        lblNhapHang.setText("Nhập hàng");
        lblNhapHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNhapHangMouseClicked(evt);
            }
        });

        lblBanHang.setBackground(new java.awt.Color(102, 204, 255));
        lblBanHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/BanHang.png"))); // NOI18N
        lblBanHang.setText("Bán hàng");
        lblBanHang.setOpaque(true
        );
        lblBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBanHangMouseClicked(evt);
            }
        });

        lblNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/NhanVien.png"))); // NOI18N
        lblNhanVien.setText("Nhân viên");
        lblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseClicked(evt);
            }
        });

        lblKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/KhachHang.png"))); // NOI18N
        lblKhachHang.setText("Khách hàng");
        lblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKhachHangMouseClicked(evt);
            }
        });

        lblNCC.setBackground(new java.awt.Color(102, 204, 255));
        lblNCC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/NhaCungCap.png"))); // NOI18N
        lblNCC.setText("Nhà cung cấp");
        lblNCC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNCCMouseClicked(evt);
            }
        });

        lblPhieuNhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/PhieuNhapHang_1.png"))); // NOI18N
        lblPhieuNhap.setText("Phiếu nhập hàng");
        lblPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPhieuNhapMouseClicked(evt);
            }
        });

        lblHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Bill.png"))); // NOI18N
        lblHoaDon.setText("Hóa đơn bán hàng");
        lblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHoaDonMouseClicked(evt);
            }
        });

        lblThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Thống kê.png"))); // NOI18N
        lblThongKe.setText("Thống kê doanh thu");
        lblThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThongKeMouseClicked(evt);
            }
        });

        lblTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/user.png"))); // NOI18N
        lblTaiKhoan.setText("Tài khoản");
        lblTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTaiKhoanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpMenuLayout = new javax.swing.GroupLayout(jpMenu);
        jpMenu.setLayout(jpMenuLayout);
        jpMenuLayout.setHorizontalGroup(
            jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMenuLayout.createSequentialGroup()
                .addGroup(jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBanHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblKhoHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jpMenuLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAvatar)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblChucVu)
                .addGap(76, 76, 76))
            .addGroup(jpMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpMenuLayout.setVerticalGroup(
            jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMenuLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblAvatar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblChucVu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKhoHang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNhapHang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBanHang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKhachHang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNCC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPhieuNhap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblThongKe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTaiKhoan)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jtab.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jtabStateChanged(evt);
            }
        });
        jtab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtabMouseClicked(evt);
            }
        });

        jpKho.setBackground(new java.awt.Color(255, 255, 255));

        txtFind.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtFind.setText("Nhập thông tin tìm kiếm");
        txtFind.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFind.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFindFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFindFocusLost(evt);
            }
        });
        txtFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindActionPerformed(evt);
            }
        });
        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFindKeyReleased(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Xoa.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Them.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách mặt hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        tblMatHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã laptop", "Tên", "CPU", "RAM", "GPU", "Giá bán", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMatHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMatHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMatHang);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách giỏ hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã riêng laptop", "Mã laptop", "Giá bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGioHang);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );

        cbxTieuChi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiêu chí tìm kiếm", "Mã laptop", "Tên", "CPU", "RAM", "GPU", "Giá bán" }));
        cbxTieuChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTieuChiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpKhoLayout = new javax.swing.GroupLayout(jpKho);
        jpKho.setLayout(jpKhoLayout);
        jpKhoLayout.setHorizontalGroup(
            jpKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpKhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpKhoLayout.createSequentialGroup()
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(371, 371, 371)
                        .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpKhoLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpKhoLayout.setVerticalGroup(
            jpKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpKhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cbxTieuChi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFind, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jtab.addTab("Chi tiết hóa đơn", jpKho);

        jpHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setText("Hủy bỏ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThanhToan.setText("Xác nhận thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        tblChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Riêng", "Giá bán", "Mã laptop", "Tên laptop"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblChiTietHoaDon);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Số điền thoại: ");

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });
        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSDTKeyReleased(evt);
            }
        });

        txtTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Tên khách hàng: ");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Địa chỉ: ");

        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Số điểm đã tích: ");

        txtTichDiem.setText("0");
        txtTichDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTichDiemActionPerformed(evt);
            }
        });
        txtTichDiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTichDiemKeyReleased(evt);
            }
        });

        btnAddKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAddKH.setText("Thêm khách hàng");
        btnAddKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTen)
                            .addComponent(txtSDT)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDiaChi))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTichDiem)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnAddKH, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 137, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTichDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddKH, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin của hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Mã hóa đơn: ");

        txtMaHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaHD.setText("123456");

        txtNgayLap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgayLap.setText("31/10/2023");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Ngày lập: ");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Số lượng : ");

        txtSL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSL.setText("12");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Tổng tiền:");

        txtTongTIen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTongTIen.setText("21021031203021");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Số điểm được tích thêm : ");

        txtDiemTichThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDiemTichThem.setText("12");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiemTichThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(txtTongTIen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHD)
                    .addComponent(txtNgayLap)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtSL))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtDiemTichThem))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTongTIen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpHoaDonLayout = new javax.swing.GroupLayout(jpHoaDon);
        jpHoaDon.setLayout(jpHoaDonLayout);
        jpHoaDonLayout.setHorizontalGroup(
            jpHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHoaDonLayout.createSequentialGroup()
                .addGroup(jpHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                    .addGroup(jpHoaDonLayout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThanhToan)))
                .addContainerGap())
        );
        jpHoaDonLayout.setVerticalGroup(
            jpHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jpHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addGroup(jpHoaDonLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtab.addTab("Hóa đơn", jpHoaDon);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jpMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtab))
            .addComponent(jpThanhTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jpThanhTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtab)
                    .addComponent(jpMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1399, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindActionPerformed

    public void ChuyenTrangThai(String idRieng, String trangThai){
        for (ChiTietLaptop l : list_ct){
            if (l.getIDRieng().equals(idRieng)){
                l.setTrangThai(trangThai);
            }
        }
    }
    
    public String TimIDRieng(String ID){
        for (ChiTietLaptop ct : list_ct){
            if (ct.getTrangThai().equals("1") && ct.getMauLapTop().equals(ID)){
                return ct.getIDRieng();
            }
        }
        return "";
    }
    
    public void TruSoLuong(String ID){
        for (Laptop l : list_mh){
            if (l.getID().equals(ID)){
                l.setSoLuongTonKho(l.getSoLuongTonKho()-1);
            }
        }
    }
    
    public int SoLuong(String ID){
        for (Laptop l : list_mh){
            if (l.getID().equals(ID)){
                return l.getSoLuongTonKho();
            }
        }
        return 0;
    }
   
    
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        int SelectedRow = tblMatHang.getSelectedRow();
        if (SelectedRow != -1){
            
            String MaLaptop = model.getValueAt(SelectedRow, 0).toString();
            
            // Nhập số lượng muốn mua
            int SoLuong = 0;
            try{
                SoLuong  = Integer.parseInt(JOptionPane.showInputDialog("Nhập số lượng hàng muốn mua"));
            }
            catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Bạn chỉ nên nhập số và nhập đủ số lượng tồn kho");
                return;
            }

            if (SoLuong <= SoLuong(MaLaptop)){
                for (int i=1;i<=SoLuong;i++){
                    String idRieng = TimIDRieng(model.getValueAt(SelectedRow, 0).toString());
            

                    // Thêm vào giỏ hàng
                    model_gh.addRow(new Object[]{idRieng,MaLaptop,model.getValueAt(SelectedRow, 5)}); 

                    // Thêm vào bảng chi tiết đơn hàng bên phần chi tiết hóa đơn
                    model_cthd.addRow(new Object[]{idRieng,model.getValueAt(SelectedRow, 5),MaLaptop,model.getValueAt(SelectedRow, 1)});


                    // Chuyển trạng thái
                    ChuyenTrangThai(idRieng, "0");

                    // Trừ số lượng
                    TruSoLuong(MaLaptop);

                    // Cập nhật lại bảng mặt hàng
                    showTableMatHang();


                    // Tính tổng tiền
                    long TienBan = TimGia(MaLaptop);
                    TongTien_int += TienBan;
                    
                    // Tích điểm nếu được
                    if (TimGia(MaLaptop) > GiaTriTichDiem){
                        TichDiem +=2;
                                
                    }
                    

                }

                // Hiện thị thông báo 
               JOptionPane.showMessageDialog(rootPane, "Tổng tiền hiện tại là: "+currencyVN.format(TongTien_int)+"\nSố lượng sản phẩm là: "+model_gh.getRowCount());


                jtab.setEnabledAt(1, true);
                btnXoa.setEnabled(true);
                
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Số lượng không đủ");
            }
   
        }
    }//GEN-LAST:event_btnThemActionPerformed
    
    public String TimMaKH(String SDT){
        for (KhachHang kh : list_kh){
            if (kh.getSDT().equals(SDT)){
                return kh.getMaKH();
            }
        }    
        return "";
    }
    
    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        
        
        
        //Thực hiện thêm thông tin hóa đơn mới
        HoaDon hd = new HoaDon();
        hd.setMaHD(Integer.parseInt(txtMaHD.getText()));
        hd.setSoLuong(Integer.parseInt(txtSL.getText()));
        
        // Lấy ngày giờ hiện tại
        LocalDateTime ngayGioHienTai = LocalDateTime.now();
        hd.setNgayLap(ngayGioHienTai);
        hd.setKhachHang(TimMaKH(txtSDT.getText()));
        hd.setNhanVien(NV.getMaNV());
        hd.setTongTien((int) TongTien_int);
        if (new HoaDon_BUS().ThemHoaDon(hd)){
            // Thêm các chi tiết hóa đơn
            for (int i=0;i<tblChiTietHoaDon.getRowCount();i++){
                
                // Gọi các đối tượng thuộc chi tiết hóa đơn
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                String idRieng = model_cthd.getValueAt(i, 0).toString();
                cthd.setIDRieng(idRieng);
                cthd.setGia((int) TimGia(model_cthd.getValueAt(i, 2).toString()));
                cthd.setMaHD(Integer.parseInt(txtMaHD.getText()));
                
                // Thực hiện thêm chi tiết hóa đơn vào database
                if (!new ChiTietHoaDon_DAO().ThemChiTietHoaDon(cthd)){
                    JOptionPane.showMessageDialog(rootPane, "Chi tiết có mã :" + idRieng+" bị lỗi");
                    return;
                }
                
                // Cập nhật trạng thái cho sản phẩm tương ứng với idRieng vừa thêm
                if (!new ChiTietLaptop_BUS().CapNhatTrangThai("0", idRieng)){
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật trạng thái mã :" + idRieng+" bị lỗi");
                    return;
                }
                    
            }
            
            // Cập nhật só lượng tồn kho
            for (Laptop l : list_mh){
                if (!new Laptop_BUS().TruSoLuongTonKho(l.getSoLuongTonKho(), l.getID())){
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật số lượng tồn kho mã :" + l.getID()+" bị lỗi");
                    return;
                }
            }
            
            // Cập nhật tích điểm cho khách
            if (!new KhachHang_BUS().TichDiem(Integer.parseInt(txtTichDiem.getText()), Integer.parseInt(txtDiemTichThem.getText()), TimMaKH(txtSDT.getText()))){
                JOptionPane.showMessageDialog(rootPane, "Cập nhật tích điểm bị lỗi");
                return;
            }
            
            // Thông báo 
            JOptionPane.showMessageDialog(rootPane, "Thanh toán hóa đơn thành công");
            Reset();
            
                
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Thêm hóa đơn thất bại");
        }
          
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtFindFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFindFocusGained
        // TODO add your handling code here:
        if (txtFind.getText().equals("Nhập thông tin tìm kiếm")){
            txtFind.setText("");
        }
    }//GEN-LAST:event_txtFindFocusGained

    private void txtFindFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFindFocusLost
        // TODO add your handling code here:
        if (txtFind.getText().isEmpty()){
            txtFind.setText("Nhập thông tin tìm kiếm");
        }
    }//GEN-LAST:event_txtFindFocusLost

    private void tblMatHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMatHangMouseClicked

    }//GEN-LAST:event_tblMatHangMouseClicked

    private void txtFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyReleased
        // TODO add your handling code here:
        model.setRowCount(0);
        String text = txtFind.getText();
        int Selectedcb = cbxTieuChi.getSelectedIndex();
        switch(Selectedcb){
            case 1:
                for(Laptop s : list_mh){
                    if (s.getID().contains(text)){
                        if (s.getTrangThai().equals("1") && s.getSoLuongTonKho() > 0){
                            model.addRow(new Object[]{s.getID(),s.getTen(),s.getCPU(),s.getRAM(),s.getGPU(),currencyVN.format(s.getGia()),s.getSoLuongTonKho()});
                        }
                    }
                }
                tblMatHang.setModel(model);
                break;
            case 2:
                for(Laptop s : list_mh){
                    if (s.getTen().contains(text)){
                        if (s.getTrangThai().equals("1")&& s.getSoLuongTonKho() > 0){
                            model.addRow(new Object[]{s.getID(),s.getTen(),s.getCPU(),s.getRAM(),s.getGPU(),currencyVN.format(s.getGia()),s.getSoLuongTonKho()});
                        }
                    }
                }
                tblMatHang.setModel(model);
                break;
            case 3:
                for(Laptop s : list_mh){
                    if (s.getCPU().contains(text)){
                        if (s.getTrangThai().equals("1")&& s.getSoLuongTonKho() > 0){
                            model.addRow(new Object[]{s.getID(),s.getTen(),s.getCPU(),s.getRAM(),s.getGPU(),currencyVN.format(s.getGia()),s.getSoLuongTonKho()});
                        }
                    }
                }
                tblMatHang.setModel(model);
                break;
            case 4:
                for(Laptop s : list_mh){
                    if (Integer.toString(s.getRAM()).contains(text)){
                        if (s.getTrangThai().equals("1")&& s.getSoLuongTonKho() > 0){
                            model.addRow(new Object[]{s.getID(),s.getTen(),s.getCPU(),s.getRAM(),s.getGPU(),currencyVN.format(s.getGia()),s.getSoLuongTonKho()});
                        }
                    }
                }
                tblMatHang.setModel(model);
                break;
            case 5:
                for(Laptop s : list_mh){
                    if (s.getGPU().contains(text)){
                        if (s.getTrangThai().equals("1")&& s.getSoLuongTonKho() > 0){
                            model.addRow(new Object[]{s.getID(),s.getTen(),s.getCPU(),s.getRAM(),s.getGPU(),currencyVN.format(s.getGia()),s.getSoLuongTonKho()});
                        }
                    }
                }
                tblMatHang.setModel(model);
                break;
            case 6:
                for(Laptop s : list_mh){
                    if (Integer.toString(s.getGia()).contains(text)){
                        if (s.getTrangThai().equals("1")&& s.getSoLuongTonKho() > 0){
                            model.addRow(new Object[]{s.getID(),s.getTen(),s.getCPU(),s.getRAM(),s.getGPU(),currencyVN.format(s.getGia()),s.getSoLuongTonKho()});
                        }
                    }
                }
                tblMatHang.setModel(model);
                break;
            default:
                JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn tiêu chí tìm kiếm");
                break;

        }
    }//GEN-LAST:event_txtFindKeyReleased
    
    public String MaLaptop(String idRieng){
        for (ChiTietLaptop laptop : list_ct){
            if (idRieng.equals(laptop.getIDRieng())){
                return laptop.getMauLapTop();
            }
        }
        return "";
    }
    
    public int TimHangChuaMauLaptop(String MaLaptop){
        for (int i=0;i<model.getRowCount();i++){
            if (model.getValueAt(i, 0).toString().equals(MaLaptop)){
                return i;
            }
        }
        return 0;
    }
    public void CongSoLuong(String ID){
        for (Laptop l : list_mh){
            if (l.getID().equals(ID)){
                l.setSoLuongTonKho(l.getSoLuongTonKho()+1);
            }
        }
    }
    
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int SelectedRow = tblGioHang.getSelectedRow();
        if (SelectedRow != -1){
            
            String idRieng = model_gh.getValueAt(SelectedRow, 0).toString();
            String MaLaptop = model_gh.getValueAt(SelectedRow, 1).toString();
            
            // Chuyển trạng thái
            ChuyenTrangThai(idRieng, "1");
            
            // Cập nhật lại số lượng
            CongSoLuong(MaLaptop);
            
            // Cập nhật bảng mặt hàng
            showTableMatHang();
            
            // Tính lại tổng tiền
            long TienBan = TimGia(MaLaptop);
            TongTien_int -= TienBan;
            
            // Trừ tích điểm 
            if (TimGia(MaLaptop) > GiaTriTichDiem){
                TichDiem -= 2;
            }
            
            // Hiện thị thông báo 
            JOptionPane.showMessageDialog(rootPane, "Tổng tiền hiện tại là: "+currencyVN.format(TongTien_int)+"\nSố lượng sản phẩm là: "+(model_gh.getRowCount()-1));
            
            // Xóa khỏi bảng giỏ hàng
            model_cthd.removeRow(SelectedRow);
            model_gh.removeRow(SelectedRow);      
        }
        
        if (model_gh.getRowCount() == 0){
            jtab.setEnabledAt(1, false);
            btnXoa.setEnabled(false);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        // TODO add your handling code here:
        int SelectedRow = tblGioHang.getSelectedRow();
        if (SelectedRow != -1){
            
            String MaLaptop = model_gh.getValueAt(SelectedRow, 1).toString();
            
            // Tìm mã laptop để seleted
            for (int i=0;i<model.getRowCount();i++){
                if (model.getValueAt(i, 0).toString().equals(MaLaptop)){
                    // Thực hiện trỏ vào hàng có mẫu laptop
                    tblMatHang.setRowSelectionInterval(i, i);
                }
                
            }
  
        }
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void txtTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenActionPerformed

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void txtTichDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTichDiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTichDiemActionPerformed

    private void btnAddKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddKHActionPerformed
        // TODO add your handling code here:
        String SDT = txtSDT.getText();
        String Ten = txtTen.getText();
        String DiaChi = txtDiaChi.getText();
        
        KhachHang kh = new KhachHang();
        kh.setSDT(SDT);
        kh.setTen(Ten);
        kh.setDiaChi(DiaChi);
        
        String kq = new KhachHang_BUS().addKH_BanHang(kh);
        
        if (kq.equals("Thêm khách hàng thành công")){
            JOptionPane.showMessageDialog(rootPane, kq);
            btnAddKH.setEnabled(false);
            btnThanhToan.setEnabled(true);
            list_kh = new KhachHang_BUS().getListKhachHang();
        }
        
    }//GEN-LAST:event_btnAddKHActionPerformed

    private void txtSDTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() != KeyEvent.VK_ENTER){
            String text = txtSDT.getText();
            for(KhachHang s : list_kh){
                if (s.getSDT().equals(text)){
                    txtTen.setText(s.getTen());
                    txtDiaChi.setText(s.getDiaChi());
                    
                    
                    txtTichDiem.setText(Integer.toString(s.getTichDiem()));
                    btnThanhToan.setEnabled(true);
                    return;
                }
            }
            txtTen.setText("");
            txtDiaChi.setText("");
            txtTichDiem.setText("0");
            
            // kiểm tra xem nếu đủ 10 hoặc 11 số thì cho tạo khách hàng mới
            if (text.length() == 10 && txtTen.getText().isEmpty() && txtDiaChi.getText().isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Không tìm thấy thông tin khách hàng này \nHãy thêm thông tin khách hàng mới");
                // Bật nút thêm khách hàng
                btnAddKH.setEnabled(true);
            }
            else {
                btnAddKH.setEnabled(false);
            }
            
            // Nếu dư số thì phải nhập lại và không cho thêm
            if (text.length() > 10){
                JOptionPane.showMessageDialog(rootPane, "Số điện thoại chỉ gồm 10");
                txtSDT.setText("");
            }
            
            
            // Chỉ có 2 trường hợp là tìm ra khách và mới thêm khách thì nút thanh toán được mở
            btnThanhToan.setEnabled(false);
            
        }
        
    }//GEN-LAST:event_txtSDTKeyReleased

    private void txtTichDiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTichDiemKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTichDiemKeyReleased

    private void jtabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jtabMouseClicked

    private void jtabStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jtabStateChanged
        // TODO add your handling code here:
        int Selected = jtab.getSelectedIndex();
        if (Selected == 1){
            txtSDT.requestFocus();
 
            
            // Tạo 1 số thông tin cần thiết cho hóa đơn
            txtMaHD.setText(Integer.toString(new HoaDon_BUS().LayMaHoaDon()));
            txtSL.setText(Integer.toString(tblGioHang.getRowCount()));
            txtTongTIen.setText(currencyVN.format(TongTien_int));
            txtDiemTichThem.setText(Integer.toString(TichDiem));
            
        }
    }//GEN-LAST:event_jtabStateChanged

   
    private void cbxTieuChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTieuChiActionPerformed
        // TODO add your handling code here:
        txtFind.setText("");
        showTableMatHang();
        txtFind.requestFocus();
    }//GEN-LAST:event_cbxTieuChiActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Reset();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        DangNhap dn = new DangNhap();
        dn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void lblKhoHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhoHangMouseClicked
        new KhoHang(NV).setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_lblKhoHangMouseClicked

    private void lblNhapHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhapHangMouseClicked
        new NhapHang(NV).setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_lblNhapHangMouseClicked

    private void lblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseClicked
        new QuanLyNhanVien(NV).setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_lblNhanVienMouseClicked

    private void lblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhachHangMouseClicked
        new QuanLyKhachHang(NV).setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_lblKhachHangMouseClicked

    private void lblNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNCCMouseClicked
        new QuanLyNhaCungCap(NV).setVisible(true);
        this.dispose();
       
    }//GEN-LAST:event_lblNCCMouseClicked

    private void lblPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPhieuNhapMouseClicked
        new PhieuNhapHang(NV).setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_lblPhieuNhapMouseClicked

    private void lblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonMouseClicked
        new HoaDonBanHang(NV).setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_lblHoaDonMouseClicked

    private void lblThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongKeMouseClicked
        new ThongKe(NV).setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_lblThongKeMouseClicked

    private void lblBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanHangMouseClicked
        // TODO add your handling code here:
        new BanHang(NV).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBanHangMouseClicked

    private void lblTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTaiKhoanMouseClicked
        // TODO add your handling code here:
        new QuanLyTaiKhoan(NV).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblTaiKhoanMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHang(NV).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddKH;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbxTieuChi;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jpHoaDon;
    private javax.swing.JPanel jpKho;
    private javax.swing.JPanel jpMenu;
    private javax.swing.JPanel jpThanhTieuDe;
    private javax.swing.JTabbedPane jtab;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblBanHang;
    private javax.swing.JLabel lblChucVu;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblKhoHang;
    private javax.swing.JLabel lblNCC;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblNhapHang;
    private javax.swing.JLabel lblPhieuNhap;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JLabel lblThongKe;
    private javax.swing.JTable tblChiTietHoaDon;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblMatHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JLabel txtDiemTichThem;
    private javax.swing.JTextField txtFind;
    private javax.swing.JLabel txtMaHD;
    private javax.swing.JLabel txtNgayLap;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JLabel txtSL;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTichDiem;
    private javax.swing.JLabel txtTongTIen;
    // End of variables declaration//GEN-END:variables
}
