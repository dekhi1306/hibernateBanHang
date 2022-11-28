/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.loai;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Asus
 */
public class LoaiDAL {
    private Session session;
    
    public LoaiDAL()
    {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    
    public List<loai> loadLoai() {
        List<loai> loai;
        session.beginTransaction();
        loai = session.createQuery("FROM loai", loai.class).list();
        session.getTransaction().commit();
        return loai;
    }
}
