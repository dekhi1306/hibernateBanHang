package Entity;

import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author caothanh
 */
@Data
@Entity
@Table
public class Vegetable {
    
    @Id
    private int VegetableID;
    @Column 
    private String VegetableName;
    @Column
    private String Unit;
    @Column
    private int Amount;
    @Column 
    private String Image;
    @Column
    private Double Price;
    
    @ManyToOne
    @JoinColumn(name="CatagoryID")
    private Category catagory;
}
