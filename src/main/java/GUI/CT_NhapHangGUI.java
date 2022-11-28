/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.NguyenLieuBLL;
import BLL.PhieuNhapHangBLL;
import BLL.ct_PNHBLL;
import Entity.nguyenlieu;
import Entity.ct_phieunhaphang;
import Entity.phieunhaphang;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
class CT_NhapHangGUI extends JFrame implements ActionListener {

    private ct_PNHBLL ctBLL = new ct_PNHBLL();
    private PhieuNhapHangBLL pnhBLL = new PhieuNhapHangBLL();
    private NguyenLieuBLL nlBLL = new NguyenLieuBLL();
    private int maPhieuPhapHang;
    private int maNV, maNCC;
    private JTextField txtMaNL, txtSL, txtGiaBan, txtThanhTien;
    private DefaultTableModel model;
    private JTable tbl;
    private int DWIDTH = 840;
    private JTextField txtTenNL;
    private JButton btnCancel;
    private boolean flag = true;

    public CT_NhapHangGUI(String maPhieuPhapHang) {
        this.maPhieuPhapHang = Integer.parseInt(maPhieuPhapHang.trim());
        flag = false;
        ctBLL.listByidPNH(Integer.parseInt(maPhieuPhapHang.trim()));
        init();
    }

    CT_NhapHangGUI(int maNV, int maNCC) {
        this.maNV = maNV;
        this.maNCC = maNCC;
        phieunhaphang pnh = new phieunhaphang(maNCC, maNV, LocalDate.now(), 0.0f);
        pnhBLL.add(pnh);
        maPhieuPhapHang = pnhBLL.getList().get(0).getId_PNH();
        init();
    }

    public void init() {
        nlBLL.list();
        setTitle("Chi tiết phiếu nhập");
        setSize(DWIDTH, 450);
        getContentPane().setBackground(new Color(25, 25, 34));
        setLayout(null);
        setLocationRelativeTo(null);

        Font ftitle = new Font("Segoe UI", Font.BOLD, 25);
        Font font0 = new Font("Segoe UI", Font.PLAIN, 13);
        Font font1 = new Font("Segoe UI", Font.BOLD, 13);

        //HEADER
        JLabel title = new JLabel("CHI TIẾT PHIẾU NHẬP HÀNG " + maPhieuPhapHang, JLabel.CENTER);
        title.setFont(ftitle);
        title.setForeground(Color.WHITE);
        title.setBounds(0, 0, DWIDTH, 60);
        add(title);
        /**
         * *************** PHẦN HIỂN THỊ THÔNG TIN **************************
         */
        JPanel itemView = new JPanel(null);
        itemView.setBounds(new Rectangle(0, 60, this.getSize().width, this.getSize().height - 150));
        itemView.setBackground(new Color(223, 230, 233));

        JLabel lbMaNL = new JLabel("Mã nguyên liệu ");
        lbMaNL.setFont(font0);
        lbMaNL.setBounds(20, 20, 100, 30);
        txtMaNL = new JTextField();
        txtMaNL.setBounds(new Rectangle(120, 20, 210, 30));
        txtMaNL.setEditable(flag);
        txtMaNL.setInputVerifier(new MyInputVerifier());
        itemView.add(lbMaNL);
        itemView.add(txtMaNL);

        JLabel lbSL = new JLabel("Số lượng ");
        lbSL.setFont(font0);
        lbSL.setBounds(20, 60, 100, 30);
        txtSL = new JTextField();
        txtSL.setEditable(flag);
        txtSL.setBounds(new Rectangle(120, 60, 210, 30));
        txtSL.setInputVerifier(new MyInputVerifier());
        itemView.add(lbSL);
        itemView.add(txtSL);

        JLabel lbTenNL = new JLabel("Tên guyên liệu ");
        lbTenNL.setFont(font0);
        lbTenNL.setBounds(20, 100, 100, 30);
        txtTenNL = new JTextField();
        txtTenNL.setBounds(new Rectangle(120, 100, 210, 30));
        txtTenNL.setEditable(false);
        itemView.add(lbTenNL);
        itemView.add(txtTenNL);

        JLabel lbGiaBan = new JLabel("Giá bán ");
        lbGiaBan.setFont(font0);
        lbGiaBan.setBounds(20, 140, 100, 30);
        txtGiaBan = new JTextField();
        txtGiaBan.setBounds(new Rectangle(120, 140, 210, 30));
        txtGiaBan.setEditable(false);
        itemView.add(lbGiaBan);
        itemView.add(txtGiaBan);

        /**
         * ************** TẠO CÁC BTN XÓA, SỬA, VIEW, IN BILL
         * *******************
         */
        JLabel btnAdd = new JLabel(new ImageIcon("./src/image/btnAdd_150px.png"));
        btnAdd.setBounds(new Rectangle(20, 180, 150, 50));
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAdd.setVisible(flag);

        JLabel btnDelete = new JLabel(new ImageIcon("./src/image/btnDelete_150px.png"));
        btnDelete.setBounds(new Rectangle(180, 180, 150, 50));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnDelete.setVisible(flag);

        JLabel btnConfirm = new JLabel(new ImageIcon("./src/image/btnConfirm.png"));
        btnConfirm.setBounds(new Rectangle(10, 240, 185, 40));
        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnConfirm.setVisible(flag);

        btnCancel = new JButton("Hủy nhập hàng");
        btnCancel.setBackground(new Color(255, 102, 102));
        btnCancel.setBounds(new Rectangle(210, 240, 130, 40));
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancel.addActionListener(this);
        btnCancel.setVisible(flag);

        itemView.add(btnAdd);
        itemView.add(btnConfirm);
        itemView.add(btnDelete);
        itemView.add(btnCancel);

        btnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtMaNL.getText().equals("")) {
                    JOptionPane.showMessageDialog(null ,"Vui lòng chọn mã nguyên liệu !!!", "Warning", 
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                txtTenNL.requestFocus();
                int maNL = 0;
                int sl = 0;
                try {
                    maNL = Integer.parseInt(txtMaNL.getText());
                    sl = Integer.parseInt(txtSL.getText());
                } catch (NumberFormatException exc) {
                    return;
                }

                int mess = JOptionPane.showConfirmDialog(null, "Xác nhận xóa", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (mess == 0) { //yes
                    boolean flag = false;
                    int soLuong = Math.abs(sl);
                    boolean flag2 = false;

                    if (ctBLL.getList() != null) {
                        for (int i = 0; i < ctBLL.getList().size(); i++) {
                            if (ctBLL.getList().get(i).getNguyenlieu().getId_NL() == maNL) {
                                flag = true;
                                if (ctBLL.getList().get(i).getAmount() >= soLuong) {
                                    flag2 = true;
                                    break;
                                }
                                break;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null ,"Chưa có nguyên liệu nào được nhập !!!, xóa thất bại", "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (!flag) {
                        JOptionPane.showMessageDialog(null ,"Không tìm thấy mã nguyên liệu trong bảng nguyên liệu đã thêm, vui lòng nhập lại !!!", "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (!flag2) {
                        JOptionPane.showMessageDialog(null ,"Số lượng nguyên liệu cần xóa vượt quá số lượng nguyên liệu mà bạn đã nhập , vui lòng nhập lại !!!", "Error", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    nguyenlieu nl = null;
                    for (nguyenlieu nguyenlieu : nlBLL.getList()) {
                        if (nguyenlieu.getId_NL() == maNL) {
                            nl = nguyenlieu;
                        }
                    }
                    for (int i = 0; i < ctBLL.getList().size(); i++) {
                        if (ctBLL.getList().get(i).getNguyenlieu().getId_NL() == maNL) {
                            if (ctBLL.getList().get(i).getAmount() == soLuong) {
                                ctBLL.deleteByID(maPhieuPhapHang, maNL);
                                break;
                            }
                            ctBLL.getList().get(i).setAmount(ctBLL.getList().get(i).getAmount() - soLuong);
                            float tongGia = (float) (soLuong * 1.0 * nl.getPrice());
                            ctBLL.getList().get(i).setTotal_money(ctBLL.getList().get(i).getTotal_money() - tongGia);
                            try {
                                ctBLL.set(ctBLL.getList().get(i));
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(CT_NhapHangGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    nlBLL.subtractAmount(nl, soLuong);
                    cleanView();
                    tbl.clearSelection();
                    outModel(model, (ArrayList<ct_phieunhaphang>) ctBLL.getList());

                }
            }
        });

        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtMaNL.getText().equals("") || txtSL.getText().equals("")) {
                    JOptionPane.showMessageDialog(null ,"Vui lòng nhập đầy đủ thông tin !!!", "Warning", 
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                txtTenNL.requestFocus();
                int maNL = 0;
                try {
                    maNL = Integer.parseInt(txtMaNL.getText());
                } catch (NumberFormatException exc) {
                    return;
                }
                boolean flag = false;
                nguyenlieu nl = null;
                for (nguyenlieu nguyenlieu : nlBLL.getList()) {
                    if (maNL == nguyenlieu.getId_NL()) {
                        flag = true;
                        nl = nguyenlieu;
                        break;
                    }
                }
                if (!flag) {
                    JOptionPane.showMessageDialog(null ,"Không tìm thấy mã nguyên liệu, vui lòng nhập lại !!!", "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int sl = 0;
                try {
                    sl = Integer.parseInt(txtSL.getText());
                } catch (NumberFormatException exc) {
                    return;
                }

                int soLuong = Math.abs(sl);
                float tongGia = (float) (soLuong * 1.0 * nl.getPrice());
                boolean updateOrAdd = false;

                if (ctBLL.getList() != null) {
                    for (int i = 0; i < ctBLL.getList().size(); i++) {
                        if (ctBLL.getList().get(i).getNguyenlieu().getId_NL() == maNL) {
                            ctBLL.getList().get(i).setAmount(ctBLL.getList().get(i).getAmount() + soLuong);
                            ctBLL.getList().get(i).setTotal_money(ctBLL.getList().get(i).getTotal_money() + tongGia);
                            try {
                                ctBLL.set(ctBLL.getList().get(i));
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(CT_NhapHangGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            updateOrAdd = true;
                            break;
                        }
                    }
                }

                if (!updateOrAdd) {
                    ct_phieunhaphang ctNhapHangDTO = new ct_phieunhaphang(maPhieuPhapHang, maNL, soLuong, tongGia, nl.getPrice());
                    ctBLL.add(ctNhapHangDTO);
                }

                nlBLL.addAmount(nl, soLuong);
                cleanView();
                tbl.clearSelection();
                outModel(model, (ArrayList<ct_phieunhaphang>) ctBLL.getList());
            }
        });

        btnConfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                phieunhaphang pnhdto = pnhBLL.getList().get(0);
                float thanhTien = 0.f;
                for (ct_phieunhaphang phieuNhapHangDTO : ctBLL.getList()) {
                    thanhTien += phieuNhapHangDTO.getTotal_money();
                }
                pnhdto.setTotal_money(thanhTien);
                pnhBLL.set(pnhdto);
                JOptionPane.showMessageDialog(null ,"Nhập hàng thành công !!!", "Success", 
                            JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });

        /**
         * ************** TẠO TABLE
         * ***********************************************************
         */
        /**
         * ************ TẠO MODEL VÀ HEADER ********************************
         */
        Vector header = new Vector();
        header.add("Mă NL");
        header.add("Số lượng");
        header.add("Giá");
        header.add("Thành tiền");
        model = new MyTable(header, 5);
        tbl = new JTable(model);
        /**
         * ****** CUSTOM TABLE ***************
         */
        // Chỉnh width các cột 
        tbl.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(50);

        // Custom table
        tbl.setFocusable(false);
        tbl.setIntercellSpacing(new Dimension(0, 0));
        tbl.getTableHeader().setFont(font1);
        tbl.setRowHeight(30);
        tbl.setShowVerticalLines(false);
        tbl.getTableHeader().setOpaque(false);
        tbl.setFillsViewportHeight(true);
        tbl.getTableHeader().setBackground(new Color(134, 64, 0));
        tbl.getTableHeader().setForeground(Color.WHITE);
        tbl.setSelectionBackground(new Color(52, 152, 219));

        // Add table vào ScrollPane
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(new Rectangle(350, 20, this.getSize().width - 400, this.getSize().height - 180));
        scroll.setBackground(null);

        itemView.add(scroll);
        if (ctBLL.getList() != null && !ctBLL.getList().isEmpty()) {
            outModel(model, (ArrayList<ct_phieunhaphang>) ctBLL.getList());
        }
        add(itemView);
        /**
         * ***********************************
         */
        tbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    int i = tbl.getSelectedRow();
                    String maNL = tbl.getModel().getValueAt(i, 0).toString();
                    txtMaNL.setText(maNL);
                    String nameString = "";
                    for (nguyenlieu nguyenlieu : nlBLL.getList()) {
                        if (nguyenlieu.getId_NL() == Integer.parseInt(maNL)) {
                            nameString = nguyenlieu.getName();
                            break;
                        }
                    }
                    txtTenNL.setText(nameString);
                    txtSL.setText(tbl.getModel().getValueAt(i, 1).toString());
                    txtGiaBan.setText(tbl.getModel().getValueAt(i, 2).toString());
                } catch (Exception exc) {
                    return;
                }
            }
        });
        setVisible(true);
    }

    public void cleanView() {
        txtMaNL.setText("");
        txtTenNL.setText("");
        txtSL.setText("");
        txtGiaBan.setText("");
    }

    public void outModel(DefaultTableModel model, ArrayList<ct_phieunhaphang> ctpnh) {     //xuat tu arraylist len table
        Vector data;
        model.setRowCount(0);
        for (ct_phieunhaphang h : ctpnh) {
            data = new Vector();
            data.add(h.getNguyenlieu().getId_NL());
            data.add(h.getAmount());
            data.add(h.getPrice());
            data.add(h.getTotal_money());
            model.addRow(data);
        }
        tbl.setModel(model);
    }

    public phieunhaphang getDTOContent() {
        return pnhBLL.getList().get(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancel) {
            int mess = JOptionPane.showConfirmDialog(null, "Xác nhận hủy nhập hàng", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (mess == 0) { //yes

                for (int i = 0; i < ctBLL.getList().size(); i++) {
                    for (nguyenlieu nguyenlieu : nlBLL.getList()) {
                        if (nguyenlieu.getId_NL() == ctBLL.getList().get(i).getNguyenlieu().getId_NL()) {
                            nlBLL.subtractAmount(nguyenlieu, ctBLL.getList().get(i).getAmount());
                            break;
                        }
                    }
                }

                ctBLL.delete(maPhieuPhapHang);
                pnhBLL.delete(maPhieuPhapHang);
                JOptionPane.showMessageDialog(null ,"Hủy phiếu nhập hàng thành công !!!", "Success", 
                            JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }
    }
}
