/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.hoadon;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Asus
 */
public class HoaDonDAL {
    private Session session;
    
    public HoaDonDAL()
    {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public void addHoaDon(hoadon hd) {
        session.save(hd);
    }

    public List<hoadon> loadHoaDon() {
        List<hoadon> hd;
        session.beginTransaction();
        hd = session.createQuery("FROM hoadon", hoadon.class).list();
        session.getTransaction().commit();
        return hd;
    }

    public void deleteHoaDon(hoadon hd) {
        session.delete(hd);
    }

    public void updateHoaDon(hoadon hd) {
        session.update(hd);
    }

}
