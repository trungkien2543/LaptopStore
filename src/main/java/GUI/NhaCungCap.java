/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DTO.NhanVien;

/**
 *
 * @author ASUS
 */
public class NhaCungCap extends javax.swing.JFrame {
    
    public static NhanVien NV;

    /**
     * Creates new form NhaCungCap
     */
    public NhaCungCap(NhanVien NV) {
        
        this.NV = NV;
        
        initComponents();
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
        jpKho = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        lbTimKiem = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jpMenu2 = new javax.swing.JPanel();
        lblAvatar2 = new javax.swing.JLabel();
        lblName2 = new javax.swing.JLabel();
        lblChucVu2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblKhoHang2 = new javax.swing.JLabel();
        lblNhapHang1 = new javax.swing.JLabel();
        lblBanHang7 = new javax.swing.JLabel();
        lblBanHang8 = new javax.swing.JLabel();
        lblBanHang9 = new javax.swing.JLabel();
        lblBanHang10 = new javax.swing.JLabel();
        lblBanHang11 = new javax.swing.JLabel();
        lblBanHang12 = new javax.swing.JLabel();
        lblBanHang13 = new javax.swing.JLabel();
        lblBanHang16 = new javax.swing.JLabel();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1016, Short.MAX_VALUE)
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

        jpKho.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jTextField1.setText("Nhập thông tin tìm kiếm");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        lbTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/TimKiem.png"))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Xoa.png"))); // NOI18N
        jButton1.setText("Xóa");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Them.png"))); // NOI18N
        jButton2.setText("Thêm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Sửa.png"))); // NOI18N
        jButton3.setText("Sửa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Excel.png"))); // NOI18N
        jButton4.setText("Xuất file excel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jpKhoLayout = new javax.swing.GroupLayout(jpKho);
        jpKho.setLayout(jpKhoLayout);
        jpKhoLayout.setHorizontalGroup(
            jpKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpKhoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTimKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpKhoLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jpKhoLayout.setVerticalGroup(
            jpKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpKhoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jpKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addGroup(jpKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpMenu2.setBackground(new java.awt.Color(255, 255, 255));

        lblAvatar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Avatar.png"))); // NOI18N

        lblName2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblName2.setText("Lê Hoài Nam");

        lblChucVu2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblChucVu2.setText("Quản lý");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Line.png"))); // NOI18N

        lblKhoHang2.setBackground(new java.awt.Color(255, 255, 255));
        lblKhoHang2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblKhoHang2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/KhoHang.png"))); // NOI18N
        lblKhoHang2.setText("Kho hàng");
        lblKhoHang2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKhoHang2MouseClicked(evt);
            }
        });

        lblNhapHang1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNhapHang1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/NhapHang.png"))); // NOI18N
        lblNhapHang1.setText("Nhập hàng");
        lblNhapHang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNhapHang1MouseClicked(evt);
            }
        });

        lblBanHang7.setBackground(new java.awt.Color(102, 204, 255));
        lblBanHang7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBanHang7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/BanHang.png"))); // NOI18N
        lblBanHang7.setText("Bán hàng");
        lblBanHang7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBanHang7MouseClicked(evt);
            }
        });

        lblBanHang8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBanHang8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/NhanVien.png"))); // NOI18N
        lblBanHang8.setText("Nhân viên");
        lblBanHang8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBanHang8MouseClicked(evt);
            }
        });

        lblBanHang9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBanHang9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/KhachHang.png"))); // NOI18N
        lblBanHang9.setText("Khách hàng");
        lblBanHang9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBanHang9MouseClicked(evt);
            }
        });

        lblBanHang10.setBackground(new java.awt.Color(102, 204, 255));
        lblBanHang10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBanHang10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/NhaCungCap.png"))); // NOI18N
        lblBanHang10.setText("Nhà cung cấp");
        lblBanHang10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBanHang10.setOpaque(true
        );
        lblBanHang10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBanHang10MouseClicked(evt);
            }
        });

        lblBanHang11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBanHang11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/PhieuNhapHang_1.png"))); // NOI18N
        lblBanHang11.setText("Phiếu nhập hàng");
        lblBanHang11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBanHang11MouseClicked(evt);
            }
        });

        lblBanHang12.setBackground(new java.awt.Color(102, 204, 255));
        lblBanHang12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBanHang12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Bill.png"))); // NOI18N
        lblBanHang12.setText("Hóa đơn bán hàng");
        lblBanHang12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBanHang12MouseClicked(evt);
            }
        });

        lblBanHang13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBanHang13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Thống kê.png"))); // NOI18N
        lblBanHang13.setText("Thống kê doanh thu");
        lblBanHang13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBanHang13MouseClicked(evt);
            }
        });

        lblBanHang16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBanHang16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/user.png"))); // NOI18N
        lblBanHang16.setText("Tài khoản");
        lblBanHang16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBanHang16MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpMenu2Layout = new javax.swing.GroupLayout(jpMenu2);
        jpMenu2.setLayout(jpMenu2Layout);
        jpMenu2Layout.setHorizontalGroup(
            jpMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMenu2Layout.createSequentialGroup()
                .addGroup(jpMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpMenu2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBanHang9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBanHang7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNhapHang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblKhoHang2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBanHang8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBanHang10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBanHang11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBanHang12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBanHang13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jpMenu2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jpMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAvatar2)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMenu2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblChucVu2)
                .addGap(76, 76, 76))
            .addGroup(jpMenu2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBanHang16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpMenu2Layout.setVerticalGroup(
            jpMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMenu2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblAvatar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblName2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblChucVu2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKhoHang2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNhapHang1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBanHang7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBanHang8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBanHang9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBanHang10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBanHang11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBanHang12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBanHang13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBanHang16)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpThanhTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpKho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jpThanhTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpKho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpMenu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        this.dispose();
        DangNhap dn = new DangNhap();
        dn.setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void lblKhoHang2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhoHang2MouseClicked
        new KhoHang(NV).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblKhoHang2MouseClicked

    private void lblNhapHang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhapHang1MouseClicked
        new NhapHang(NV).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblNhapHang1MouseClicked

    private void lblBanHang7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanHang7MouseClicked
        // TODO add your handling code here:
        new BanHang(NV).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBanHang7MouseClicked

    private void lblBanHang8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanHang8MouseClicked
        new QuanLyNhanVien(NV).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBanHang8MouseClicked

    private void lblBanHang9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanHang9MouseClicked
        new QuanLyKhachHang(NV).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBanHang9MouseClicked

    private void lblBanHang10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanHang10MouseClicked
        new NhaCungCap(NV).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBanHang10MouseClicked

    private void lblBanHang11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanHang11MouseClicked
        new PhieuNhapHang(NV).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBanHang11MouseClicked

    private void lblBanHang12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanHang12MouseClicked
        new HoaDonBanHang(NV).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBanHang12MouseClicked

    private void lblBanHang13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanHang13MouseClicked
        new ThongKe(NV).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBanHang13MouseClicked

    private void lblBanHang16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanHang16MouseClicked
        // TODO add your handling code here:
        new QuanLyTaiKhoan(NV).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBanHang16MouseClicked

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
            java.util.logging.Logger.getLogger(NhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new NhaCungCap(NV).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel jpKho;
    private javax.swing.JPanel jpMenu2;
    private javax.swing.JPanel jpThanhTieuDe;
    private javax.swing.JLabel lbTimKiem;
    private javax.swing.JLabel lblAvatar2;
    private javax.swing.JLabel lblBanHang10;
    private javax.swing.JLabel lblBanHang11;
    private javax.swing.JLabel lblBanHang12;
    private javax.swing.JLabel lblBanHang13;
    private javax.swing.JLabel lblBanHang16;
    private javax.swing.JLabel lblBanHang7;
    private javax.swing.JLabel lblBanHang8;
    private javax.swing.JLabel lblBanHang9;
    private javax.swing.JLabel lblChucVu2;
    private javax.swing.JLabel lblKhoHang2;
    private javax.swing.JLabel lblName2;
    private javax.swing.JLabel lblNhapHang1;
    // End of variables declaration//GEN-END:variables
}
