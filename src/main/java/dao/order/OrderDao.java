/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.order;

import entities.Order;

/**
 *
 * @author Admin
 */
public interface OrderDao {
    
    public boolean add(Order newOrder);
    
}
