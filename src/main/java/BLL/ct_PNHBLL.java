/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.ct_PNHDAL;
import Entity.ct_phieunhaphang;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class ct_PNHBLL {

    private List<ct_phieunhaphang> ct_pnhBLL = new ArrayList<>();;

    public ct_PNHBLL() {
        ct_pnhBLL = null;
    }

    public List<ct_phieunhaphang> getList() {
        return ct_pnhBLL;
    }

    public void list() {
        ct_PNHDAL dal = new ct_PNHDAL();
        ct_pnhBLL = new ArrayList<>();
        ct_pnhBLL = dal.loadCTPNH();
    }

    public void listByidPNH(int id_PNH) {
        ct_PNHDAL dal = new ct_PNHDAL();
        ct_pnhBLL = new ArrayList<>();
        ct_pnhBLL = dal.findByIdPNH(id_PNH);
    }

    public void add(ct_phieunhaphang ctpnh) {
        ct_PNHDAL dal = new ct_PNHDAL();
        dal.addCTPNH(ctpnh);
        ct_pnhBLL.add(ctpnh);
    }

    public void delete(int id_PNH) {
        for (ct_phieunhaphang ctpnh : ct_pnhBLL) {
            if (ctpnh.getId_PNH() == id_PNH) {
                ct_pnhBLL.remove(ctpnh);
                ct_PNHDAL dal = new ct_PNHDAL();
                dal.deleteCTPNH(ctpnh);
                return;
            }
        }
    }
    
    public void deleteByCode(int idPNH, int idNL) {
        for (ct_phieunhaphang ctpnh : ct_pnhBLL) {
            if (ctpnh.getId_PNH() == idPNH && ctpnh.getId_NL() == idNL) {
                ct_pnhBLL.remove(ctpnh);
                ct_PNHDAL dal = new ct_PNHDAL();
                dal.deleteCTPNH(ctpnh);
                return;
            }
        }
    }

    public void set(ct_phieunhaphang ctpnh) throws FileNotFoundException {
        ct_PNHDAL dal = new ct_PNHDAL();
        dal.updateCTPNH(ctpnh);
    }

}
