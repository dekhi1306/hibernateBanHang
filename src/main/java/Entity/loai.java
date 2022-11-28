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
public class loai {
    @Id
    private int id_Loai;
    @Column 
    private String name; 
}
