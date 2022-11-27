/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.ct_hoadon;
import java.io.FileNotFoundException;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Asus
 */
public class ct_HDDAL {
    private Session session;
    
    public ct_HDDAL()
    {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    
    public void addCTHD(ct_hoadon cthd) {
        session.save(cthd);
    }

    public List<ct_hoadon> loadCTHD() {
        List<ct_hoadon> ct;
        session.beginTransaction();
        ct = session.createQuery("FROM ct_hoadon", ct_hoadon.class).list();
        session.getTransaction().commit();
        return ct;
    }
    
    public List<ct_hoadon> findById(int id_HD) {
        List<ct_hoadon> ct;
        session.beginTransaction();
        ct = session.createQuery("FROM ct_hoadon WHERE id_HD ="+id_HD, ct_hoadon.class).list();
        session.getTransaction().commit();
        return ct;
    }

    public void deleteCTHD(ct_hoadon ct) {
        session.delete(ct);
    }

    public void updateCTHD(ct_hoadon ct) {
        session.update(ct);
    }
}
