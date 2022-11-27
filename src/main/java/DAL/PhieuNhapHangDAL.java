/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.phieunhaphang;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Asus
 */
public class PhieuNhapHangDAL {
    private Session session;
    
    public PhieuNhapHangDAL(){
        session = HibernateUtils.getSessionFactory().openSession();
    }
    
    public void addPNH(phieunhaphang pnh) {
        session.save(pnh);
    }

    public List<phieunhaphang> loadPNH() {
        List<phieunhaphang> pnh;
        session.beginTransaction();
        pnh = session.createQuery("FROM phieunhaphang", phieunhaphang.class).list();
        session.getTransaction().commit();
        return pnh;
    }
    
    public phieunhaphang findByID(int idPNH) {
        phieunhaphang pnh;
        session.beginTransaction();
        pnh = session.createQuery("FROM phieunhaphang WHERE id_PNH ="+idPNH, phieunhaphang.class).getSingleResult();
        session.getTransaction().commit();
        return pnh;     
    }

    public void deletePNH(phieunhaphang pnh)  {
       session.delete(pnh);
    }

    public void updatePNH(phieunhaphang pnh) {
        session.update(pnh);
    }
}
