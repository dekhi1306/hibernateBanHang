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
public class nguyenlieu {
    @Id
    private int id_NL;
    @Column 
    private String name;
    @Column
    private int amount;
    @Column
    private float price;
    
    public void addAmount(int amount) {
        this.amount += amount;
    }
    
    public void subtractAmount(int amount) {
        this.amount -= amount;
    }
}
