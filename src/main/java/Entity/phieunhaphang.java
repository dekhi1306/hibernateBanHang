/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.time.LocalDate;
import java.time.ZoneId;
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
public class phieunhaphang {
    @Id
    private int id_PNH;
    
    @ManyToOne
    @JoinColumn(name="id_NCC")
    private int id_NCC;
    
    @ManyToOne
    @JoinColumn(name="id_NV")
    private int id_NV;
    
    @Column
    private Date date_add;
    
    @Column
    private float total_money;

    public phieunhaphang(int id_NCC, int id_NV, LocalDate date_add, float total_money) {
        this.id_NCC = id_NCC;
        this.id_NV = id_NV;
        setDate_add(date_add);
        this.total_money = total_money;
    }
    
    public void setDate_add(LocalDate date_add) {
        this.date_add = Date.from(date_add.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }
}
