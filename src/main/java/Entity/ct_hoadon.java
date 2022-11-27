/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author Lộc
 */
@Data
@Entity
@Table
public class ct_hoadon {
    @Id
    @ManyToOne
    @JoinColumn(name="id_HD")
    private int id_HD;
    
    @Id
    @ManyToOne
    @JoinColumn(name="id_SP")
    private int id_SP;
    
    @Column
    private String name;
    
    @Column
    private int amount;
    
    @Column
    private float price;
  
}
