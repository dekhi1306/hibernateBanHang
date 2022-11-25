/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.KhachHangDAL;
import Entity.khachhang;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class KhachHangBLL {

    private List<khachhang> khBLL;

    public KhachHangBLL() {
        khBLL = null;
    }

    public List<khachhang> getKhBUS() {
        return khBLL;
    }

    public khachhang getCustomerById(String MaKH) {
        for (khachhang kh : khBLL) {
            if (kh.getId_KH() == Integer.parseInt(MaKH)) {
                return kh;
            }
        }
        return null;
    }

    public void list() {
        KhachHangDAL dal = new KhachHangDAL();
        khBLL = new ArrayList<>();
        khBLL = dal.loadKhachHang();
    }

    public void add(khachhang khach) {
        KhachHangDAL dal = new KhachHangDAL();
        dal.addKhachHang(khach);
        khBLL.add(khach);
    }

    public void delete(khachhang khach) {
        for (khachhang khachhang : khBLL) {
            if (khachhang.getId_KH() == khach.getId_KH()) {
                khBLL.remove(khachhang);
                KhachHangDAL dal = new KhachHangDAL();
                dal.deleteKhachHang(khach);
                return;
            }
        }
    }

    public void set(khachhang khach) {
        for (int i = 0; i < khBLL.size(); i++) {
            if (khBLL.get(i).getId_KH() == khach.getId_KH()) {
                khBLL.set(i, khach);
                KhachHangDAL dal = new KhachHangDAL();
                dal.updateKhachHang(khach);
                return;
            }
        }
    }
}
