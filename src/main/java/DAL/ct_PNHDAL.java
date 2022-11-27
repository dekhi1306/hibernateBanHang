/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.ct_phieunhaphang;
import java.io.FileNotFoundException;
import java.util.List;
import org.hibernate.Session;


/**
 *
 * @author Asus
 */
public class ct_PNHDAL {
    private Session session;
    
    public ct_PNHDAL()
    {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    
    public void addCTPNH(ct_phieunhaphang ctpnh){
        session.save(ctpnh);
    }

    public List<ct_phieunhaphang> loadCTPNH() {
        List<ct_phieunhaphang> ct;
        session.beginTransaction();
        ct = session.createQuery("FROM ct_phieunhaphang", ct_phieunhaphang.class).list();
        session.getTransaction().commit();
        return ct;
    }
    
    public List<ct_phieunhaphang> findByIdPNH(int id_PNH) {
        List<ct_phieunhaphang> ct;
        session.beginTransaction();
        ct = session.createQuery("FROM ct_phieunhaphang WHERE id_PNH ="+id_PNH, ct_phieunhaphang.class).list();
        session.getTransaction().commit();
        return ct;
    }

    public void deleteCTPNH(ct_phieunhaphang ctpnh) {
        session.delete(ctpnh);
    }
    
//    public void deleteByIdBillAndProduct(int id_PNH,int id_NL) throws FileNotFoundException {
//        String sql = "DELETE FROM ct_phieunhaphang WHERE id_PNH = "+id_PNH+" AND id_NL = "+id_NL;
//        session.delete(sql);
//    }

    public void updateCTPNH(ct_phieunhaphang ctpnh) throws FileNotFoundException {
        session.update(ctpnh);
    }
}
