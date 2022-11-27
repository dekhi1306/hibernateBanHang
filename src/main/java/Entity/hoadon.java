/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Timestamp;
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
public class hoadon {
    @Id
    private int id;
    
    @ManyToOne
    @JoinColumn(name="id_KH")
    private int id_KH;
    
    @ManyToOne
    @JoinColumn(name="id_NV")
    private int id_NV;
    
    @Column
    private float total_money;
    
    @Column
    private Timestamp create_day;

}
