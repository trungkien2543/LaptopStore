/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.PhieuNhap_BUS;
import DTO.PhieuNhap;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class PhieuNhapHang extends javax.swing.JFrame {
    DefaultTableModel model;
    ArrayList<PhieuNhap> list = new PhieuNhap_BUS().getAllPhieuNhap();
    Locale localeVN = new Locale("vi", "VN");
    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
    /**
     * Creates new form PhieuNhap
     */
    //Doi tuong thuoc hien chuyen kiem ngay
    DateFormat ChuyenNgaySQL = new SimpleDateFormat("MM/dd/yyyy");
    DateFormat ChuyenNgayShow = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * Creates new form NhaCungCap
     */
    public PhieuNhapHang() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        model = (DefaultTableModel) tblPhieuNhap.getModel();
        tblPhieuNhap.setModel(model);
        txtFind.requestFocus();
        ShowTable();
        
        jpNgayLap.setVisible(false);
        jpTongTien.setVisible(false);
    }
    
    private void ShowTable(){
        model.setRowCount(0);
        for (PhieuNhap s : list){
            model.addRow(new Object[]{
                        s.getMaPhieu(),ChuyenNgayShow.format(s.getNgayNhap()),currencyVN.format(s.getTongTien()),s.getNhaCungCap(),s.getNhanVien()
                    });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        lblBanHang1 = new javax.swing.JLabel();
        lblBanHang2 = new javax.swing.JLabel();
        lblBanHang3 = new javax.swing.JLabel();
        lblBanHang4 = new javax.swing.JLabel();
        lblBanHang5 = new javax.swing.JLabel();
        lblBanHang6 = new javax.swing.JLabel();
        jpKho = new javax.swing.JPanel();
        txtFind = new javax.swing.JTextField();
        btnExcel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuNhap = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cbxDieuKienLoc = new javax.swing.JComboBox<>();
        btnExcel1 = new javax.swing.JButton();
        jpNgayLap = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateFrom = new com.toedter.calendar.JDateChooser();
        jDateTo = new com.toedter.calendar.JDateChooser();
        btnNgayLap = new javax.swing.JButton();
        jpTongTien = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtFrom = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTo = new javax.swing.JTextField();
        btnTongTien = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1551, 674));

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

        javax.swing.GroupLayout jpThanhTieuDeLayout = new javax.swing.GroupLayout(jpThanhTieuDe);
        jpThanhTieuDe.setLayout(jpThanhTieuDeLayout);
        jpThanhTieuDeLayout.setHorizontalGroup(
            jpThanhTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpThanhTieuDeLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1050, Short.MAX_VALUE)
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
                .addGap(16, 16, 16))
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

        lblNhapHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/NhapHang.png"))); // NOI18N
        lblNhapHang.setText("Nhập hàng");

        lblBanHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/BanHang.png"))); // NOI18N
        lblBanHang.setText("Bán hàng");

        lblBanHang1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBanHang1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/NhanVien.png"))); // NOI18N
        lblBanHang1.setText("Nhân viên");

        lblBanHang2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBanHang2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/KhachHang.png"))); // NOI18N
        lblBanHang2.setText("Khách hàng");

        lblBanHang3.setBackground(new java.awt.Color(102, 204, 255));
        lblBanHang3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBanHang3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/NhaCungCap.png"))); // NOI18N
        lblBanHang3.setText("Nhà cung cấp");
        lblBanHang3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBanHang3.setOpaque(true);

        lblBanHang4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBanHang4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/PhieuNhapHang_1.png"))); // NOI18N
        lblBanHang4.setText("Phiếu nhập hàng");

        lblBanHang5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBanHang5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Bill.png"))); // NOI18N
        lblBanHang5.setText("Hóa đơn bán hàng");

        lblBanHang6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBanHang6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Thống kê.png"))); // NOI18N
        lblBanHang6.setText("Thống kê doanh thu");

        javax.swing.GroupLayout jpMenuLayout = new javax.swing.GroupLayout(jpMenu);
        jpMenu.setLayout(jpMenuLayout);
        jpMenuLayout.setHorizontalGroup(
            jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMenuLayout.createSequentialGroup()
                .addGroup(jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBanHang2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBanHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblKhoHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBanHang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBanHang3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBanHang4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBanHang5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBanHang6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addComponent(lblBanHang1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBanHang2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBanHang3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBanHang4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBanHang5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBanHang6)
                .addGap(0, 158, Short.MAX_VALUE))
        );

        jpKho.setBackground(new java.awt.Color(255, 255, 255));

        txtFind.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtFind.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Excel.png"))); // NOI18N
        btnExcel.setText("Xuất file excel");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu", "Ngày Nhập", "Tổng tiền", "Nhà cung cấp", "Nhân viên"
            }
        ));
        tblPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuNhap);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Điều kiện lọc:");

        cbxDieuKienLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mặc định", "Mã phiếu", "Ngày nhập", "Tổng tiền", "Nhà cung cấp", "Nhân viên", " " }));
        cbxDieuKienLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDieuKienLocActionPerformed(evt);
            }
        });

        btnExcel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Excel.png"))); // NOI18N
        btnExcel1.setText("Xem chi tiết");
        btnExcel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcel1ActionPerformed(evt);
            }
        });

        jpNgayLap.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("Từ :");

        jLabel8.setText("Đến : ");

        btnNgayLap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNgayLap.setText("Lọc");

        javax.swing.GroupLayout jpNgayLapLayout = new javax.swing.GroupLayout(jpNgayLap);
        jpNgayLap.setLayout(jpNgayLapLayout);
        jpNgayLapLayout.setHorizontalGroup(
            jpNgayLapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNgayLapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpNgayLapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpNgayLapLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateFrom, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                    .addGroup(jpNgayLapLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNgayLap)
                .addGap(12, 12, 12))
        );
        jpNgayLapLayout.setVerticalGroup(
            jpNgayLapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNgayLapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpNgayLapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpNgayLapLayout.createSequentialGroup()
                        .addGroup(jpNgayLapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jpNgayLapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpTongTien.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Từ :");

        jLabel10.setText("Đến : ");

        btnTongTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTongTien.setText("Lọc");

        javax.swing.GroupLayout jpTongTienLayout = new javax.swing.GroupLayout(jpTongTien);
        jpTongTien.setLayout(jpTongTienLayout);
        jpTongTienLayout.setHorizontalGroup(
            jpTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTongTienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpTongTienLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpTongTienLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTongTien)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpTongTienLayout.setVerticalGroup(
            jpTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTongTienLayout.createSequentialGroup()
                .addGroup(jpTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpTongTienLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jpTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpTongTienLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpKhoLayout = new javax.swing.GroupLayout(jpKho);
        jpKho.setLayout(jpKhoLayout);
        jpKhoLayout.setHorizontalGroup(
            jpKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpKhoLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jpKhoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jpKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxDieuKienLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jpNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExcel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jpKhoLayout.setVerticalGroup(
            jpKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpKhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpKhoLayout.createSequentialGroup()
                        .addComponent(btnExcel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcel1))
                    .addGroup(jpKhoLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpKhoLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jpKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpKhoLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxDieuKienLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jpTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jpMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpKho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jpThanhTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jpThanhTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpKho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcelActionPerformed

    private void txtFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyReleased
        // TODO add your handling code here:
        String cbx_DK = (String) cbxDieuKienLoc.getSelectedItem();
        String find = txtFind.getText();
        model.setRowCount(0);
        switch(cbx_DK){
            case "Mã phiếu":{
                for (PhieuNhap s : list){
                    if(Integer.toString(s.getMaPhieu()).contains(find)){
                        model.addRow(new Object[]{
                            s.getMaPhieu(),ChuyenNgayShow.format(s.getNgayNhap()),currencyVN.format(s.getTongTien()),s.getNhaCungCap(),s.getNhanVien()
                        });
                    }
                }
                break;
            }

            case "Nhà cung cấp":{
                for (PhieuNhap s : list){
                    if(s.getNhaCungCap().contains(find)){
                        model.addRow(new Object[]{
                            s.getMaPhieu(),ChuyenNgayShow.format(s.getNgayNhap()),currencyVN.format(s.getTongTien()),s.getNhaCungCap(),s.getNhanVien()
                        });
                    }
                }
                break;
            }
            case "Nhân viên":{
                for (PhieuNhap s : list){
                    if(s.getNhanVien().contains(find)){
                        model.addRow(new Object[]{
                            s.getMaPhieu(),ChuyenNgayShow.format(s.getNgayNhap()),currencyVN.format(s.getTongTien()),s.getNhaCungCap(),s.getNhanVien()
                        });
                    }
                }
                break;
            }
  
            default :{
                for (PhieuNhap s : list){
                    if(Integer.toString(s.getMaPhieu()).contains(find)  || ChuyenNgayShow.format(s.getNgayNhap()).contains(find) || Integer.toString(s.getTongTien()).contains(find) || s.getNhaCungCap().contains(find) || s.getNhanVien().contains(find)){
                        model.addRow(new Object[]{
                                s.getMaPhieu(),ChuyenNgayShow.format(s.getNgayNhap()),currencyVN.format(s.getTongTien()),s.getNhaCungCap(),s.getNhanVien()
                        });
                    }
                }
                break;
            }
        }

    }//GEN-LAST:event_txtFindKeyReleased

    private void cbxDieuKienLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDieuKienLocActionPerformed

        if(cbxDieuKienLoc.getSelectedItem() == "Ngày nhập"){
            txtFind.setEnabled(false);
            jpNgayLap.setVisible(true);
            jpTongTien.setVisible(false);
            txtFrom.setText("");
            txtTo.setText("");

        }
        else if(cbxDieuKienLoc.getSelectedItem() == "Tổng tiền"){
            txtFind.setEnabled(false);
            jpNgayLap.setVisible(false);
            jpTongTien.setVisible(true);
            jDateFrom.setDate(null);
            jDateTo.setDate(null);

        }
        else{
            txtFind.setEnabled(true);
            jpNgayLap.setVisible(false);
            jpTongTien.setVisible(false);
            jDateFrom.setDate(null);
            jDateTo.setDate(null);
            txtFrom.setText("");
            txtTo.setText("");

        }
        txtFind.setText("");
        txtFind.requestFocus();
        ShowTable();
    }//GEN-LAST:event_cbxDieuKienLocActionPerformed

    private void btnExcel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcel1ActionPerformed

    private void tblPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuNhapMouseClicked
        // TODO add your handling code here:
        int Selected_Row = tblPhieuNhap.getSelectedRow();
        txtFind.setText(Integer.toString((int) tblPhieuNhap.getValueAt(Selected_Row, 0)));
    }//GEN-LAST:event_tblPhieuNhapMouseClicked

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
            java.util.logging.Logger.getLogger(PhieuNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhieuNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhieuNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhieuNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhieuNhapHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnExcel1;
    private javax.swing.JButton btnNgayLap;
    private javax.swing.JButton btnTongTien;
    private javax.swing.JComboBox<String> cbxDieuKienLoc;
    private com.toedter.calendar.JDateChooser jDateFrom;
    private com.toedter.calendar.JDateChooser jDateTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpKho;
    private javax.swing.JPanel jpMenu;
    private javax.swing.JPanel jpNgayLap;
    private javax.swing.JPanel jpThanhTieuDe;
    private javax.swing.JPanel jpTongTien;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblBanHang;
    private javax.swing.JLabel lblBanHang1;
    private javax.swing.JLabel lblBanHang2;
    private javax.swing.JLabel lblBanHang3;
    private javax.swing.JLabel lblBanHang4;
    private javax.swing.JLabel lblBanHang5;
    private javax.swing.JLabel lblBanHang6;
    private javax.swing.JLabel lblChucVu;
    private javax.swing.JLabel lblKhoHang;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNhapHang;
    private javax.swing.JTable tblPhieuNhap;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtFrom;
    private javax.swing.JTextField txtTo;
    // End of variables declaration//GEN-END:variables
}
