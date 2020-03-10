/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package render.comboboxbutton.category;

import entities.Category;
import entities.Work;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import util.URL_Factory;

/**
 *
 * @author Admin
 */
public class ButtonRender extends DefaultListCellRenderer{
    private final String sourcePath = URL_Factory.IMAGE_FOLDER_URL;
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Category category = (Category) value;
        KindOfProduct p = KindOfProduct.values()[category.getId()];
        this.setIcon(p.getIcon());
        this.setText(p.getText());
        this.setHorizontalAlignment(JLabel.CENTER);
      
        if(isSelected){
            setBackground(new Color(39,174,244));
        }else{
            setBackground(new Color(255,255,255));
        } 
        return this;
    } 
}
