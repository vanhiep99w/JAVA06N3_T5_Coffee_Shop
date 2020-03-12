/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.product_order;

import entities.ProductOrder;
import entities.Product_Order;
import java.util.List;

/**
 *
 * @author PC
 */
public interface ProductOrderDao {
    public List<ProductOrder> getProductOrderDetail(String nameTable);
    
    public List<Product_Order> getAll(Integer id_Table);
    
    public boolean delete(Integer id_Order);
}
