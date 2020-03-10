/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import common.ProductOrderTableColumn;
import entities.ProductOrder;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import service.product_order.ProductOrderService;
import service.product_order.ProductOrderServiceImpl;

/**
 *
 * @author PC
 */
public class ProductOrderTableModel extends AbstractTableModel {

    private ProductOrderService productOrderService = new ProductOrderServiceImpl();
    private List<ProductOrder> productOrders ;
    private List<Object> productOrderInformation = new ArrayList<>();
    private ProductOrderTableColumn[] columnNames = ProductOrderTableColumn.values();
    private JTable tbProductOrder;

    public ProductOrderTableModel(JTable tbProductOrder,String nameTable) {
        this.tbProductOrder = tbProductOrder;
        productOrders = productOrderService.getProductOrderDetail(nameTable);
    }

    @Override
    public int getRowCount() {
        if (productOrders != null) {
            return productOrders.size();
        } else {
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        if (columnNames != null) {
            return columnNames.length;
        } else {
            return 0;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column].getText();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        productOrderInformation = Arrays.asList(
                productOrders.get(rowIndex).getNameProduct(),
                productOrders.get(rowIndex).getAmout(),
                productOrders.get(rowIndex).getSum()
        );
        return productOrderInformation.get(columnIndex).toString();
    }
    
       public void loadDataTable() {
        tbProductOrder.setModel(this);
    }
       
    public void cssForTable() {
        tbProductOrder.getTableHeader().setPreferredSize(new Dimension(0, 60));
        tbProductOrder.setRowHeight(26);     
        tbProductOrder.getTableHeader().setReorderingAllowed(false);
        tbProductOrder.setFont(new Font("Tahoma", Font.BOLD, 40));
    }

}
