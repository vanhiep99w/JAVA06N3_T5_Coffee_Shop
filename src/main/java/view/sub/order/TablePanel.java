/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub.order;

import entities.Table;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import service.table.TableService;
import service.table.TableServiceImpl;

/**
 *
 * @author PC
 */
public class TablePanel extends JPanel {

    private final TableService tableService = new TableServiceImpl();
    private final GridLayout gridLayout;
    private List<Table> tables = new ArrayList<>();
    private JButton[] btTables;

    public TablePanel() {
        gridLayout = new GridLayout(5, 4);
        tables = tableService.getAll();
        btTables = new JButton[tables.size()];
        initComponents();
        initEvents();
    }

    public JButton[] getTables() {
        return this.btTables;
    }

    private void initComponents() {
        setSize(500, 500);
        setLayout(gridLayout);
        gridLayout.setHgap(20);
        gridLayout.setVgap(20);

        initTables();
    }

    private void initEvents() {
    }

    private void initTables() {
        Font font = new Font("Tahoma", 1, 30);
        for (int i = 0; i < btTables.length; i++) {
            btTables[i] = new JButton(tables.get(i).getName());
            btTables[i].setFont(font);
            add(btTables[i]);
        }
    }

}
