/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.NCCDAL;
import Entity.nhacungcap;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class NCCBLL {

    private List<nhacungcap> nccBLL;

    public NCCBLL() {
        nccBLL = null;
    }

    public List<nhacungcap> getList() {
        return nccBLL;
    }

    public void list() {
        NCCDAL nccDAO = new NCCDAL();
        nccBLL = new ArrayList<>();
        nccBLL = nccDAO.loadNCC();
    }

    public void add(nhacungcap ncc) {
        NCCDAL nccDAO = new NCCDAL();
        nccDAO.addNCC(ncc);
        nccBLL.add(ncc);
    }

    public void set(nhacungcap ncc) {
        for (int i = 0; i < nccBLL.size(); i++) {
            if (nccBLL.get(i).getId_NCC() == ncc.getId_NCC()) {
                nccBLL.set(i, ncc);
                NCCDAL nccDAO = new NCCDAL();
                nccDAO.updateNCC(ncc);
                return;
            }
        }
    }

    public boolean checkIdNCC(int idNCC) {
        for (nhacungcap ncc : nccBLL) {
            if (ncc.getId_NCC() == idNCC) {
                return true;
            }
        }
        return false;
    }

}
