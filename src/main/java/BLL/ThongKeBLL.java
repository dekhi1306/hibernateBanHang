/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.ThongKeDAL;
import Entity.thongke;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author ACER
 */
public class ThongKeBLL {
    private HoaDonBLL hdBLL = new HoaDonBLL();
    private PhieuNhapHangBLL pnhBLL = new PhieuNhapHangBLL();
    public ThongKeBLL()
    {
        hdBLL.list();
        pnhBLL.list();
    }
    
    public List<thongke> getChartByTime (LocalDate startDate , LocalDate endDate){
        ThongKeDAL tkDAO = new ThongKeDAL();
        List<thongke> tks = tkDAO.getChartByTime(startDate, endDate);
        return tks;
    }

}
