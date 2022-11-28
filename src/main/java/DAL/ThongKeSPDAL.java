/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.thongkeSP;
import java.util.List;
import org.hibernate.Session;




/**
 *
 * @author ACER
 */
public class ThongKeSPDAL { 
    private Session session;
    
    public ThongKeSPDAL()
    {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    
    public List<thongkeSP> getChart (String nameLoai){
        List<thongkeSP> tk;
        session.beginTransaction();
        String sql = "SELECT sp.name, SUM(sp.amount) AS tong "
                + "FROM sanpham AS sp, loai AS lo "
                + "WHERE sp.id_Loai = lo.id_Loai AND lo.name = '"+nameLoai+"' "
                + "GROUP BY sp.name ORDER BY tong DESC LIMIT 6";
        tk = session.createQuery(sql).list();
        session.getTransaction().commit();
        return tk;
    }
}