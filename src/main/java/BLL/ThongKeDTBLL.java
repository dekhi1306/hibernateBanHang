/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.ThongKeDTDAL;
import Entity.thongkeDT;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author ACER
 */
public class ThongKeDTBLL {
    private HoaDonBLL hdBLL = new HoaDonBLL();
    private PhieuNhapHangBLL pnhBLL = new PhieuNhapHangBLL();
    public ThongKeDTBLL()
    {
        hdBLL.list();
        pnhBLL.list();
    }
    
    public List<thongkeDT> getChartByTime (LocalDate startDate , LocalDate endDate){
        ThongKeDTDAL tkDAO = new ThongKeDTDAL();
        List<thongkeDT> tks = tkDAO.getChartByTime(startDate, endDate);
        return tks;
    }

}
