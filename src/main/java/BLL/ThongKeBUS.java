/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.ThongKeDAO;
import Entity.thongke;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author ACER
 */
public class ThongKeBUS {
    private HoaDonBLL hdBLL = new HoaDonBLL();
    private PhieuNhapHangBLL pnhBLL = new PhieuNhapHangBLL();
    public ThongKeBUS()
    {
        hdBLL.list();
        pnhBLL.list();
    }
    
    public List<thongke> getChartByTime (LocalDate startDate , LocalDate endDate){
        ThongKeDAO tkDAO = new ThongKeDAO();
        List<thongke> tks = tkDAO.getChartByTime(startDate, endDate);
        return tks;
    }

}
