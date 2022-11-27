/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.nguyenlieu;
import java.io.FileNotFoundException;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Asus
 */
public class NguyenLieuDAL {
    private Session session;
    
    public NguyenLieuDAL()
    {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    
    public void addNguyenLieu(nguyenlieu nl) {
        session.save(nl);
    }

    public List<nguyenlieu> loadNguyenLieu() {
        List<nguyenlieu> nl;
        session.beginTransaction();
        nl = session.createQuery("FROM nguyenlieu", nguyenlieu.class).list();
        session.getTransaction().commit();
        return nl;
    }

    public void deleteNguyenLieu(nguyenlieu nl) throws FileNotFoundException {
        session.delete(nl);
    }

    public void updateNguyenLieu(nguyenlieu nl) {
        session.update(nl);
    }
}
