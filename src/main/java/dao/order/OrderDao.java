/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.order;

import entities.Order;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface OrderDao {
    
    public int add(Order newOrder);
    
    public List<Order> getAll();
    
    public Order getOne (Integer id_Order);
     
}
