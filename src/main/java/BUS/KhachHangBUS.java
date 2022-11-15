/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.KhachHangDAL;
import Entity.khachhang;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class KhachHangBUS {

    private List<khachhang> khBUS;

    public KhachHangBUS() {
        khBUS = null;
    }

    public List<khachhang> getKhBUS() {
        return khBUS;
    }

    public khachhang getCustomerById(String MaKH) {
        for (khachhang kh : khBUS) {
            if (kh.getId_KH() == Integer.parseInt(MaKH)) {
                return kh;
            }
        }
        return null;
    }

    public void list() {
        KhachHangDAL dal = new KhachHangDAL();
        khBUS = new ArrayList<>();
        khBUS = dal.loadKhachHang();
    }

    public void add(khachhang khach) {
        KhachHangDAL dal = new KhachHangDAL();
        dal.addKhachHang(khach);
        khBUS.add(khach);
    }

    public void delete(khachhang khach) {
        for (khachhang khachhang : khBUS) {
            if (khachhang.getId_KH() == khach.getId_KH()) {
                khBUS.remove(khachhang);
                KhachHangDAL dal = new KhachHangDAL();
                dal.deleteKhachHang(khach);
                return;
            }
        }
    }

    public void set(khachhang khach) {
        for (int i = 0; i < khBUS.size(); i++) {
            if (khBUS.get(i).getId_KH() == khach.getId_KH()) {
                khBUS.set(i, khach);
                KhachHangDAL dal = new KhachHangDAL();
                dal.updateKhachHang(khach);
                return;
            }
        }
    }
}
