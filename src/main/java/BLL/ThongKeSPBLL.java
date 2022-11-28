/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.ThongKeSPDAL;
import Entity.thongkeSP;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class ThongKeSPBLL {
    
    public ArrayList<thongkeSP> getChart (String nameLoai){
        ThongKeSPDAL tkDAO = new ThongKeSPDAL();
        ArrayList<thongkeSP> tks = tkDAO.getChart(nameLoai);
        return tks;
    }
 
}

