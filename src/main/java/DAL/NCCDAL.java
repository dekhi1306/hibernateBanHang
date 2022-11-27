/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.nhacungcap;
import java.io.FileNotFoundException;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Asus
 */
public class NCCDAL {
    private Session session;
    
    public NCCDAL()
    {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    
    public void addNCC(nhacungcap ncc) {
        session.save(ncc);
    }

    public List<nhacungcap> loadNCC() {
        List<nhacungcap> ncc;
        session.beginTransaction();
        ncc = session.createQuery("FROM nhacungcap", nhacungcap.class).list();
        session.getTransaction().commit();
        return ncc;
    }
    
    public void updateNCC(nhacungcap ncc) {
        session.update(ncc);
    }
 
}
