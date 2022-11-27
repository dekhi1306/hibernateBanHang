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
public class ct_PhieuNhapHangBUS {

    private List<ct_phieunhaphang> ct_pnhBUS = new ArrayList<>();;

    public ct_PhieuNhapHangBUS() {
        ct_pnhBUS = null;
    }

    public List<ct_phieunhaphang> getCt_pnhBUS() {
        return ct_pnhBUS;
    }

    public void list() {
        ct_PNHDAL dal = new ct_PNHDAL();
        ct_pnhBUS = new ArrayList<>();
        ct_pnhBUS = dal.loadCTPNH();
    }

    public void listByidPNH(int id_PNH) {
        ct_PNHDAL dal = new ct_PNHDAL();
        ct_pnhBUS = new ArrayList<>();
        ct_pnhBUS = dal.findByIdPNH(id_PNH);
    }

    public void add(ct_phieunhaphang ctpnh) {
        ct_PNHDAL dal = new ct_PNHDAL();
        dal.addCTPNH(ctpnh);
        ct_pnhBUS.add(ctpnh);
    }

    public void delete(ct_phieunhaphang ct) {
        for (ct_phieunhaphang ctpnh : ct_pnhBUS) {
            if (ctpnh.getId_PNH() == ct.getId_PNH()) {
                ct_pnhBUS.remove(ctpnh);
                ct_PNHDAL dal = new ct_PNHDAL();
                dal.deleteCTPNH(ct);
                return;
            }
        }
    }
    
//    public void deleteByCode(int idPNH, int idNL) {
//        for (ct_phieunhaphang ctpnh : ct_pnhBUS) {
//            if (ctpnh.getId_PNH() == idPNH && ctpnh.getId_NL() == idNL) {
//                ct_pnhBUS.remove(ctpnh);
//                ct_PNHDAL dal = new ct_PNHDAL();
//                try {
//                    dal.deleteByCodeBillAndProduct(idPNH, idNL);
//                } catch (FileNotFoundException e) {
//                    System.out.println(e.getMessage());
//                }
//                return;
//            }
//        }
//    }

    public void set(ct_phieunhaphang ctpnh) throws FileNotFoundException {
        ct_PNHDAL dal = new ct_PNHDAL();
        dal.updateCTPNH(ctpnh);
    }

}
