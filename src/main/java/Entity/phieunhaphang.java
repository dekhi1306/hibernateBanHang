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
public class phieunhaphang {
    @Id
    private int id_PNH;
    
    @ManyToOne
    @JoinColumn(name="id_NCC")
    private nhacungcap id_NCC;
    
    @ManyToOne
    @JoinColumn(name="id_NV")
    private nhanvien id_NV;
    
    @Column
    private Date date_add;
    
    @Column
    private float total_money;
    
   
}
