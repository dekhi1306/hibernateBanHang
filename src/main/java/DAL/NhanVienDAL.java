/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Gender;
import Entity.nhanvien;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Asus
 */
public class NhanVienDAL {
    
    private Session session;
    
    public NhanVienDAL()
    {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public nhanvien getOneById(int id) {
        nhanvien nv;
        session.beginTransaction();
        nv = session.createQuery("FROM nhanvien WHERE id_NV ="+id, nhanvien.class).getSingleResult();
        session.getTransaction().commit();
        return nv;
    }

    public nhanvien getOneByPhone(String phone) {
        nhanvien nv;
        session.beginTransaction();
        nv = session.createQuery("FROM nhanvien WHERE phone ="+phone, nhanvien.class).getSingleResult();
        session.getTransaction().commit();
        return nv;
    }
    
    public nhanvien getOneByGender(Gender gender){
        nhanvien nv;
        session.beginTransaction();
        nv = session.createQuery("FROM nhanvien WHERE gemder ="+gender, nhanvien.class).getSingleResult();
        session.getTransaction().commit();
        return nv;
    }

    public void addNhanVien(nhanvien nv) {
        session.save(nv);
    }

    public List<nhanvien> loadNhanVien() {
        List<nhanvien> nv;
        session.beginTransaction();
        nv = session.createQuery("FROM nhanvien", nhanvien.class).list();
        session.getTransaction().commit();
        return nv;
    }

    public void deleteNhanVien(nhanvien nv) {
        session.delete(nv);
    }

    public void updateNhanVien(nhanvien nv) {
        session.update(nv);
    }

}
