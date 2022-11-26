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
public class nhanvien {
    @Id
    private int id_NV;
    @Column 
    private String name;
    @Column
    private int age;
    @Column
    private String gender;
    @Column
    private String address;
    @Column
    private String phone;
    @Column
    private Date start_day;
    @Column
    private int status;
    @Column
    private String img;  
}
