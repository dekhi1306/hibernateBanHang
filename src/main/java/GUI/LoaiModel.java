/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.loai;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Asus
 */
public class LoaiModel extends DefaultComboBoxModel<loai>{
    
    public LoaiModel(loai[] items) {
        super(items);
    }
    
}
