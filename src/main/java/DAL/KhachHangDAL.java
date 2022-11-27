/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.khachhang;
import java.util.List;
import org.hibernate.Session;
/**
 *
 * @author Lộc
 */
public class KhachHangDAL {
    private Session session;
    
    public KhachHangDAL()
    {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    
    public List loadKhachHang() {
        List<khachhang> khachhang;
        session.beginTransaction();
        khachhang = session.createQuery("FROM khachhang", khachhang.class).list();
        session.getTransaction().commit();
        return khachhang;
    }
    
    public void addKhachHang(khachhang c)
    {
        session.save(c);  
    }
    
    public void updateKhachHang(khachhang c)
    {
        session.update(c);
    }
    
    public void deleteKhachHang(khachhang c)
    {
        session.delete(c);
    }
}
