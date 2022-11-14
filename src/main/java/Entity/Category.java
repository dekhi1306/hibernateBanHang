package Entity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.*;
/**
 *
 * @author caothanh
 */
@Data
@Entity
@Table
public class Category {
    
    @Id
    private int CatagoryID;
    @Column
    private String Name;
    @Column
    private String Description;
    
    @OneToMany (mappedBy = "catagory")  
    private List<Vegetable> listVegetable;
    
    @Override
    public String toString()
    {
        return this.Name;
    }
}

