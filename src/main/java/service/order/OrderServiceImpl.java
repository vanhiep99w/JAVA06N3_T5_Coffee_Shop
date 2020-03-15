/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.order;

import dao.order.OrderDao;
import dao.order.OrderDaoImpl;
import entities.Order;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderServiceImpl implements OrderService{
    
    private final OrderDao orderDao;

    public OrderServiceImpl() {
        orderDao = new OrderDaoImpl();
    }

    @Override
    public int add(Order newOrder) {
        return orderDao.add(newOrder);
    }

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public Order getOne(Integer id_Order) {
        return orderDao.getOne(id_Order);
    }

    @Override
    public List<Order> getAll(Integer idTableStatus) {
        return orderDao.getAll(idTableStatus);
    }
    
    
}
