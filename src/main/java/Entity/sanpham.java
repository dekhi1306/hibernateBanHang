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
public class sanpham {
    @Id
    private int id_SP;
    
    @ManyToOne
    @JoinColumn(name="id_Loai")
    private loai loai;
    
    @Column 
    private String name;
    
    @Column
    private String descrption;
    
    @Column
    private int amount;
    
    @Column
    private float price;
    
    @Column
    private String img;
}
