/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package render.table;

import entities.Employee;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import render.comboboxbutton.work.Positon;


/**
 *
 * @author Admin
 */
public class TableCellRender extends DefaultTableCellRenderer{

    public TableCellRender() {
     
    }

    @Override
    protected void setValue(Object value) {
        Employee employee = (Employee)value;
        setText(" "+employee.getName());
        
    }
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
       
        
        Employee employee = (Employee)value;
        
        Positon p = Positon.values()[employee.getWork().getId()];
        
        this.setIcon(p.getIcon());
        
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }
    
}
