/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.khachhang;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
/**
 *
 * @author Lộc
 */
public class KhachHangDAL {
    Session session;
    
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
    
    public static void main(String args[])
    {
        KhachHangDAL dal = new KhachHangDAL();
        //KhachHang obj = dal.getKhachHang(1);
        //System.out.println(obj.getKhachHangName());
        List list = dal.loadKhachHang();
        
        for (Iterator iterator = list.iterator(); iterator.hasNext();){
             khachhang v = (khachhang) iterator.next(); 
             System.out.print("ID: " + v.getId_KH()); 
             System.out.print("Name: " + v.getLast_name()); 
             
          }
        
    
    }
}
