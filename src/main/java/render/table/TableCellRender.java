/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package render.table;

import entities.Employee;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import render.combobox.Positon;
import util.ImageUtils;

/**
 *
 * @author Admin
 */
public class TableCellRender extends JButton implements TableCellRenderer{

    public TableCellRender() {
        
    }
    
    

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        
        Employee employee = (Employee)value;
        
        Positon p = Positon.values()[employee.getWork().getId()];
        
        this.setText(employee.getName());
        this.setIcon(p.getIcon());
        
        
        
        if(isSelected){
            setBackground(new Color(39, 130, 192));
        }else{
            setBackground(new Color(240,240,240));
        }
        return this;
    }
    
}
