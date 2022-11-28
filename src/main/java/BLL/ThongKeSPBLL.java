/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.ThongKeSPDAL;
import Entity.thongkeSP;
import java.util.List;

/**
 *
 * @author ACER
 */
public class ThongKeSPBLL {
    
    public List<thongkeSP> getChart (String nameLoai){
        ThongKeSPDAL tkDAO = new ThongKeSPDAL();
        List<thongkeSP> tks = tkDAO.getChart(nameLoai);
        return tks;
    }

}
