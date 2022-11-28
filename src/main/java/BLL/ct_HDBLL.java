/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.ct_HDDAL;
import Entity.ct_hoadon;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class ct_HDBLL {
    
    private List<ct_hoadon> ct_hdBLL;
    
    public ct_HDBLL() {
        ct_hdBLL = null;
    }
    
    public ct_HDBLL(int i1)
    {
        list();
    }
    
    public List<ct_hoadon> getList() {
        return ct_hdBLL;
    }
    
    public void list() {
        ct_HDDAL cthdDAO = new ct_HDDAL();
        ct_hdBLL = new ArrayList<>();
        ct_hdBLL = cthdDAO.loadCTHD();
    }
    
    public void listIdHD(String id_HD) {
        int idHD = Integer.parseInt(id_HD);
        ct_HDDAL cthdDAO = new ct_HDDAL();
        ct_hdBLL = new ArrayList<>();
        ct_hdBLL = cthdDAO.findById(idHD);
    }
    
    public void add(ct_hoadon cthdDTO) {
        ct_hdBLL.add(cthdDTO);
        ct_HDDAL cthdDAO = new ct_HDDAL();
        cthdDAO.addCTHD(cthdDTO);
    }
    
    public void delete(String id) {
        int idHD = Integer.parseInt(id);
        list();
        for (ct_hoadon ct : ct_hdBLL) {
            if (ct.getHoadon().getId() == idHD) {
                ct_hdBLL.remove(ct);
                ct_HDDAL cthdDAO = new ct_HDDAL();
                cthdDAO.deleteCTHD(ct);
                return;
            }
        }
    }
    
    public void deleteByIdSP(String id) {
        int idSP = Integer.parseInt(id);
        for (ct_hoadon ct : ct_hdBLL) {
            if (ct.getSanpham().getId_SP() == idSP) {
                ct_hdBLL.remove(ct);
                ct_HDDAL cthdDAO = new ct_HDDAL();
                cthdDAO.deleteCTHD(ct);
                return;
            }
        }
    }
    
    public void set(ct_hoadon cthdDTO) {
        for (int i = 0; i < ct_hdBLL.size(); i++) {
            if (ct_hdBLL.get(i).getHoadon().getId() == cthdDTO.getHoadon().getId()) {
                ct_hdBLL.set(i, cthdDTO);
                ct_HDDAL cthdDAO = new ct_HDDAL();
                cthdDAO.updateCTHD(cthdDTO);
                return;
            }
        }
    }
    
}
