/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.NguyenLieuDAL;
import Entity.nguyenlieu;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class NguyenLieuBLL {

    private List<nguyenlieu> nlBLL;

    public NguyenLieuBLL() {
        nlBLL = null;
    }

    public List<nguyenlieu> getList() {
        return nlBLL;
    }

    public void list() {
        NguyenLieuDAL nlDAO = new NguyenLieuDAL();
        nlBLL = new ArrayList<>();
        nlBLL = nlDAO.loadNguyenLieu();
    }

    public void add(nguyenlieu nlDTO) {
        nlBLL.add(nlDTO);
        NguyenLieuDAL nlDAO = new NguyenLieuDAL();
        nlDAO.addNguyenLieu(nlDTO);
    }

    public void delete(String id) throws FileNotFoundException {
        int idNL = Integer.parseInt(id);
        for (nguyenlieu nlDTO : nlBLL) {
            if (nlDTO.getId_NL() == idNL) {
                nlBLL.remove(nlDTO);
                NguyenLieuDAL nlDAO = new NguyenLieuDAL();
                nlDAO.deleteNguyenLieu(nlDTO);
                return;
            }
        }
    }

    public void addAmount(nguyenlieu nlDTO, int soLuong) {
        for (int i = 0; i < nlBLL.size(); i++) {
            if (nlBLL.get(i).getId_NL() == nlDTO.getId_NL()) {
                nlDTO.addAmount(soLuong);
                nlBLL.set(i, nlDTO);
                NguyenLieuDAL nlDAO = new NguyenLieuDAL();
                nlDAO.updateNguyenLieu(nlDTO);
                return;
            }
        }
    }
    
    public void subtractAmount(nguyenlieu nlDTO, int soLuong) {
        for (int i = 0; i < nlBLL.size(); i++) {
            if (nlBLL.get(i).getId_NL() == nlDTO.getId_NL()) {
                nlDTO.subtractAmount(soLuong);
                nlBLL.set(i, nlDTO);
                NguyenLieuDAL nlDAO = new NguyenLieuDAL();
                nlDAO.updateNguyenLieu(nlDTO);
                return;
            }
        }
    }

}
