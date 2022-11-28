/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.thongkeSP;
import java.util.ArrayList;
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
    
    public ArrayList<thongkeSP> getChart (String nameLoai){
        ArrayList<thongkeSP> tk = new ArrayList<>();
        session.beginTransaction();
        String sql = "SELECT sp.name, SUM(sp.amount) AS tong "
                + "FROM sanpham AS sp, loai AS lo "
                + "WHERE sp.id_Loai = lo.id_Loai AND lo.name = '"+nameLoai+"' "
                + "GROUP BY sp.name ORDER BY tong";
        List<Object[]> objList = session.createSQLQuery(sql).list();
        for(Object[] objs : objList){
            thongkeSP sp=new thongkeSP();
            sp.setNameSP(String.valueOf(objs[0]));
            sp.setSoLuong(Integer.parseInt(String.valueOf(objs[1])));
            tk.add(sp);
            System.out.println(sp.getNameSP());
        }
        session.getTransaction().commit();
        return tk;
    }
    
    public static void main(String[] args){
        ThongKeSPDAL tk=new ThongKeSPDAL();
        tk.getChart("Bánh Mặn");
    }
}