/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author Lộc
 */
@Data
@Entity
@Table
public class ct_phieunhaphang {
    @Id
    @ManyToOne
    @JoinColumn(name="id_PNH")
    private int id_PNH;
    
    @Id
    @ManyToOne
    @JoinColumn(name="id_NL")
    private int id_NL;
    
    @Column
    private int amount;
    
    @Column
    private float price;
    
    @Column
    private float total_money;
   
}
