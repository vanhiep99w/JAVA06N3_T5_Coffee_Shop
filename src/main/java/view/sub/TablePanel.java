/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import entities.Table;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import service.TableService;
import service.TableServiceImpl;


/**
 *
 * @author PC
 */
public class TablePanel extends JPanel {

    private final TableService tableService;
    private final GridLayout gridLayout ;
    //private final Container container = getContentPane();
    
    private final List<Table> tables;
    public int n;
    
    public TablePanel(){
        gridLayout = new GridLayout(5,4);
        tableService = new TableServiceImpl();
        tables = tableService.getAll();
        n = tables.size();
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
            btTable.setText("Table " + tables.get(i).getName() );
            //container.add(btTable);
            add(btTable);
        }
    }
    
}
