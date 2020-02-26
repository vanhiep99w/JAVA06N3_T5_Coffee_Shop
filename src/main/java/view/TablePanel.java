/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import service.TableService;
import service.TableServiceImpl;
import util.Table;

/**
 *
 * @author PC
 */
public class TablePanel extends JPanel {

    private final GridLayout gridLayout = new GridLayout(5,4);
    //private final Container container = getContentPane();
    public TableService tableService = new TableServiceImpl();
    private List<Table> tables = tableService.getAllTable();
    
    public TablePanel(){
        initComponents();
    }
    
    private void initComponents() {
        //setDefaultCloseOperation(3);
        setSize(500, 500);
        //setLocationRelativeTo(null);

        //container.setLayout(gridLayout);
        setLayout(gridLayout);

        //cols = numberOfComponents/rows
        gridLayout.setHgap(20);
        gridLayout.setVgap(20);

        drawTables();
    }
    
    private void drawTables() {
        for (int i = 0; i < tables.size(); i++) {
            JButton btTable = new JButton();
            btTable.setText("Table " + tables.get(i).getNameTable() );
            //container.add(btTable);
            add(btTable);
        }
    }
}
