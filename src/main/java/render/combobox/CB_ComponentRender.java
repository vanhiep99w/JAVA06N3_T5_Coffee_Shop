/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package render.combobox;

import entities.Work;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;


/**
 *
 * @author Admin
 */
public class CB_ComponentRender extends DefaultListCellRenderer{
    
    private final Map<String,ImageIcon> icons ;
    private final String sourcePath = new File("").getAbsolutePath()+"\\images";
    
    

    public CB_ComponentRender() {
        icons = new HashMap<>();
       
    }
    
    

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Work work = (Work) value;
        Positon p = Positon.values()[work.getId()];
        this.setIcon(p.getIcon());
        this.setText("  "+p.getText());
        
        
        
        if(isSelected){
            setBackground(new Color(39,174,244));
        }else{
            setBackground(new Color(255,255,255));
        }
         
        return this;
    } 
    
   
    
}
