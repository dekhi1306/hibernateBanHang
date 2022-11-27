/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.HoaDonDAL;
import Entity.hoadon;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Asus
 */
public class HoaDonBLL {

    private List<hoadon> hdBLL;

    public HoaDonBLL() {
        hdBLL = null;
    }

    public List<hoadon> getList() {
        return hdBLL;
    }

    public void list() {
        HoaDonDAL hdDAO = new HoaDonDAL();
        hdBLL = new ArrayList<>();
        hdBLL = hdDAO.loadHoaDon();
    }

    public void add(hoadon hd) {
        hdBLL.add(hd);
        HoaDonDAL hdDAO = new HoaDonDAL();
        hdDAO.addHoaDon(hd);
    }

    public void delete(String id) {
        int idHoaDon = Integer.parseInt(id);
        for (hoadon hoadon : hdBLL) {
            if (hoadon.getId() == idHoaDon) {
                hdBLL.remove(hoadon);
                HoaDonDAL hdDAO = new HoaDonDAL();
                hdDAO.deleteHoaDon(hoadon);
                return;
            }
        }
    }

    public void set(hoadon hoadon) {
        for (int i = 0; i < hdBLL.size(); i++) {
            if (hdBLL.get(i).getId() == hoadon.getId()) {
                hdBLL.set(i, hoadon);
                HoaDonDAL hdDAO = new HoaDonDAL();
                hdDAO.updateHoaDon(hoadon);
                return;
            }
        }
    }

    public String remindMaHD() {
        int max = 0;
        String s = "";
        for (hoadon hd : hdBLL) {
            int id = hd.getId();
            if (id > max) {
                max = id;
            }
        }
        for (int i = 0; i < 3 - String.valueOf(max + 1).length(); i++) {
            s += "0";
        }
        return s + (max + 1);
    }

    public boolean check(String maHD) {
        for (hoadon hd : hdBLL) {
            if (String.valueOf(hd.getId()).equals(maHD)) {
                return true;
            }
        }
        return false;
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

    public ArrayList<hoadon> ListTime(Calendar from, Calendar to) {
        ArrayList<hoadon> list = new ArrayList<>();
        for (hoadon hd : hdBLL) {
            Timestamp date = hd.getCreate_day();
            Calendar time = Calendar.getInstance();
            time.setTimeInMillis(date.getTime());
            if (checkTime(from, to, time)) {
                list.add(hd);
            }
        }
        return list;
    }

    public ArrayList<hoadon> search(int mm, int yyyy, double max, double min, int mahd) {
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

        ArrayList<hoadon> search = new ArrayList<>();
        for (hoadon hd : hdBLL) {
            Timestamp time = hd.getCreate_day();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(time.getTime());;

            int month = calendar.get(Calendar.MONTH);
            int year = calendar.get(Calendar.YEAR);

            if (hd.getTotal_money() >= min && hd.getTotal_money() <= max
                    && (month >= mm1 && month <= mm2)
                    && (year >= yyy1 && year <= yyy2)) {
                if (mahd != 0 && hd.getId() == mahd) {
                    search.clear();
                    search.add(hd);
                    break;
                }
                if (mahd != 0 && hd.getId() != mahd) {
                    search.clear();
                }
                search.add(hd);
            }
        }
        return search;
    }

    public ArrayList<hoadon> getListWidthArray(ArrayList<String> s) {
        ArrayList<hoadon> ds = new ArrayList<>();
        if (s == null) {
            return (ArrayList<hoadon>) hdBLL;
        }
        for (hoadon hd : hdBLL) {
            String mahd = String.valueOf(hd.getId());
            for (String a : s) {
                if (mahd.equals(a)) {
                    ds.add(hd);
                }
            }
        }
        return ds;
    }
}
