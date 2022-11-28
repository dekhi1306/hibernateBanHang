/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.thongkeDT;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;




/**
 *
 * @author ACER
 */
public class ThongKeDTDAL { 
    private Session session;
    
    public ThongKeDTDAL()
    {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    
    public List<thongkeDT> getChartByTime (LocalDate startDate , LocalDate endDate){
        List<thongkeDT> tk;
        session.beginTransaction();
        String sql = "SELECT cthd.name,SUM(cthd.price*cthd.amount) AS tong FROM ct_hoadon AS cthd "
                + "INNER JOIN hoadon AS hd ON cthd.id_HD = hd.id "
                + "WHERE '"+startDate.toString()+"' <= hd.create_day && hd.create_day <= '"+endDate.toString()
                + "' GROUP BY cthd.name ORDER BY tong DESC LIMIT 6";
        tk = session.createQuery(sql).list();
        session.getTransaction().commit();
        return tk;
    }
}