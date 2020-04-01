/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub.order;

import entities.Order;
import entities.Table;
import entities.TableStatus;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import service.order.OrderService;
import service.order.OrderServiceImpl;
import service.table.TableService;
import service.table.TableServiceImpl;

/**
 *
 * @author PC
 */
public class TablePanel extends JPanel {

    private final TableService tableService = new TableServiceImpl();
    private final GridLayout gridLayout;
    private final OrderService orderService;
    private List<Table> tables = new ArrayList<>();
    private TableButton[] btTables;
    private final List<Order> orderings;

    public TablePanel() {
        gridLayout = new GridLayout(0, 4);
        tables = tableService.getAll();
        btTables = new TableButton[tables.size()];
        orderService = new OrderServiceImpl();
        orderings = orderService.getAll(TableStatus.FULL);
        initComponents();
        initEvents();
        
    }
    
    public TablePanel(String nameTable) {
        gridLayout = new GridLayout(0, 4);
        tables = tableService.getSearch(nameTable);
        btTables = new TableButton[tables.size()];
        orderService = new OrderServiceImpl();
        orderings = orderService.getAll(TableStatus.FULL);
        initComponents();
        initEvents();
        
    }

    public TableButton[] getTables() {
        return this.btTables;
    }

    private void initComponents() {
        //setSize(500, 500);
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
            Table table = tables.get(i);
            btTables[i] = new TableButton(table);
            TableButton tableButton = btTables[i];
            orderings.forEach(t -> {
                if(t.getTable().equals(table)){
                    tableButton.setActionCommand(t.getId_Order()+"");
                }  
            });
            btTables[i].setColor();
            add(btTables[i]);
        }
    }

}
