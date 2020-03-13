/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.product_order;

import dao.product.ProductDao;
import dao.product.ProductDaoImpl;
import dao.product_order.ProductOrderDao;
import dao.product_order.ProductOrderDaoImpl;
import entities.ProductOrder;
import entities.Product_Order;
import java.util.List;

/**
 *
 * @author PC
 */
public class ProductOrderServiceImpl implements ProductOrderService {

    private final ProductOrderDao productOrderDao;

    public ProductOrderServiceImpl() {
        productOrderDao = new ProductOrderDaoImpl();
    }

    @Override
    public List<Product_Order> getAll(Integer id_Order) {
        return productOrderDao.getAll(id_Order);
    }

    @Override
    public boolean delete(Integer id_Order, Integer id_Product) {
        return productOrderDao.delete(id_Order, id_Product);
    }

    @Override
    public boolean add(Product_Order newProduct_Order) {
        return productOrderDao.add(newProduct_Order);
    }

    @Override
    public boolean update(Product_Order product_Order) {
        return productOrderDao.update(product_Order);
    }

}
