
package DAL;

import Entity.Vegetable;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class VegetableDAL {
    
    Session session;
    
    public VegetableDAL()
    {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    public Vegetable getVegetable(int vegetableID)
    {
        Vegetable obj;
        session.beginTransaction();
        obj = session.get(Vegetable.class, vegetableID);
        session.getTransaction().commit();
        return obj;
        
    }
    public List getVegetableInCategory(int categoryID)
    {
        List list;
        session.beginTransaction();
        Query q = session.createQuery("FROM Vegetable WHERE CatagoryID = :categoryID");
        q.setParameter("categoryID", categoryID);
        list = q.list();
        session.getTransaction().commit();
        return list;
    }
    public void addVegetable(Vegetable obj)
    {
        session.save(obj);
    }
    public void updateVegetable(Vegetable obj)
    {
        session.update(obj);
    }
    public void deleteVegetable(Vegetable obj)
    {
        session.delete(obj);
    }
    
    public static void main(String args[])
    {
        VegetableDAL dal = new VegetableDAL();
        //Vegetable obj = dal.getVegetable(1);
        //System.out.println(obj.getVegetableName());
        List list = dal.getVegetableInCategory(1);
        
        for (Iterator iterator = list.iterator(); iterator.hasNext();){
             Vegetable v = (Vegetable) iterator.next(); 
             System.out.print("ID: " + v.getVegetableID()); 
             System.out.print("Name: " + v.getVegetableName()); 
             
          }
        
    
    }
}
