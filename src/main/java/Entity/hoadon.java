/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Timestamp;
import java.util.List;
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
    private khachhang id_KH;
    
    @ManyToOne
    @JoinColumn(name="id_NV")
    private nhanvien id_NV;
    
    @Column
    private float total_money;
    
    @Column
    private Timestamp create_day;
    
    @OneToMany (mappedBy = "hoadon")
    private List<ct_hoadon> listCT_HoaDon;

}
