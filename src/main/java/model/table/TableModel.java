/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class TableModel extends AbstractTableModel{
    
    private Object[][] objectses;

    public TableModel(Object[][] objectses) {
        this.objectses = new Object[objectses.length][objectses[0].length];
        for(int i = 0 ;i < objectses.length; i++){
            for(int j = 0 ;j < objectses[i].length; j++){
                this.objectses[i][j] = objectses[i][j];
            }
        }
    }

    @Override
    public int getRowCount() {
        return objectses.length;
    }

    @Override
    public int getColumnCount() {
        return objectses[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return objectses[rowIndex][columnIndex];
    }
    
}
