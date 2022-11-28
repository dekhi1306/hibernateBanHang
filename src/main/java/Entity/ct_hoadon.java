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
    private String id;
    
    @ManyToOne
    @JoinColumn(name="id_HD")
    private hoadon hoadon;
    
    @ManyToOne
    @JoinColumn(name="id_SP")
    private sanpham sanpham;
    
    @Column
    private String name;
    
    @Column
    private int amount;
    
    @Column
    private int price;
  
}
