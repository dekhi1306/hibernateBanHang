/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.LoaiDAL;
import Entity.loai;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class LoaiBLL {

    private List<loai> loaiBLL;

    public LoaiBLL() {
        loaiBLL = null;
    }

    public List<loai> getList() {
        return loaiBLL;
    }

    public void list() {
        LoaiDAL loaiDAO = new LoaiDAL();
        loaiBLL = new ArrayList<>();
        loaiBLL = loaiDAO.loadLoai();
    }
}