/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.PhieuNhapHangDAL;
import Entity.phieunhaphang;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Asus
 */
public class PhieuNhapHangBLL {
    
    private List<phieunhaphang> pnhBLL = new ArrayList<>();
    
    public PhieuNhapHangBLL() {
        pnhBLL = null;
    }
    
    public List<phieunhaphang> getList() {
        return pnhBLL;
    }
    
    public void list() {
        PhieuNhapHangDAL dal = new PhieuNhapHangDAL();
        pnhBLL = new ArrayList<>();
        pnhBLL = dal.loadPNH();
    }
    
    public void add(phieunhaphang pnh) {
        PhieuNhapHangDAL dal = new PhieuNhapHangDAL();
        dal.addPNH(pnh);
        pnhBLL.add(pnh);
    }
    
    public void addDTO(phieunhaphang pnh) {
        PhieuNhapHangDAL dal = new PhieuNhapHangDAL();
        pnhBLL.add(dal.findByID(pnh.getId_PNH()));
    }
    
    public void delete(int id_PNH) {
        for (phieunhaphang p: pnhBLL) {
            if (p.getId_PNH() == id_PNH) {
                pnhBLL.remove(p);
                PhieuNhapHangDAL dal = new PhieuNhapHangDAL();
                dal.deletePNH(p);
                return;
            }
        }
    }
    
    public void set(phieunhaphang pnh) {
        for (int i = 0; i < pnhBLL.size(); i++) {
            if (pnhBLL.get(i).getId_PNH() == pnh.getId_PNH()) {
                pnhBLL.set(i, pnh);
                PhieuNhapHangDAL pnhDAO = new PhieuNhapHangDAL();
                pnhDAO.updatePNH(pnh);
                return;
            }
        }
    }

    //phần thống kê
    public boolean checkTime(Calendar from, Calendar to, Calendar time) {
//        System.err.print(from.getTime()+" ");
//        System.err.print(to.getTime()+" ");
//        System.err.println(time.getTime());
        if (time.after(from) && time.before(to)) {
            return true;
        }
        return false;
    }
    
    public ArrayList<phieunhaphang> ListTime(Calendar from, Calendar to) {
        ArrayList<phieunhaphang> list = new ArrayList<>();
        for (phieunhaphang nh : pnhBLL) {
            Timestamp date = (Timestamp) nh.getDate_add();
            Calendar time = Calendar.getInstance();
            time.setTimeInMillis(date.getTime());
            if (checkTime(from, to, time)) {
                list.add(nh);
            }
        }
        return list;
    }
    
    public ArrayList<phieunhaphang> search(int mm, int yyyy, double max, double min, int maPNH) {
        int mm1 = 0, mm2 = 12;
        int yyy1 = 0, yyy2 = Calendar.getInstance().get(Calendar.YEAR);
        
        if (mm != -1) {
            mm1 = mm;
            mm2 = mm;
        }
        if (yyyy != 0) {
            yyy1 = yyyy;
            yyy2 = yyyy;
        }
        
        ArrayList<phieunhaphang> search = new ArrayList<>();
        LocalDate localDate = null;
        for (phieunhaphang pnh : pnhBLL) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(pnh.getDate_add());
            int month = calendar.get(Calendar.MONTH);
            int year = calendar.get(Calendar.YEAR);
            if (pnh.getTotal_money() >= min && pnh.getTotal_money() <= max
                    && (month >= mm1 && month <= mm2)
                    && (year >= yyy1 && year <= yyy2)) {
                if (maPNH != 0 && pnh.getId_PNH() == maPNH) {
                    search.clear();
                    search.add(pnh);
                    break;
                }
                if (maPNH != 0 && pnh.getId_PNH() != maPNH) {
                    search.clear();
                }
                search.add(pnh);
            }
        }
        return search;
    }
}
