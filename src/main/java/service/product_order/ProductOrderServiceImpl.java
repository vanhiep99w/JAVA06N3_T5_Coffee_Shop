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
import java.util.List;

/**
 *
 * @author PC
 */
public class ProductOrderServiceImpl implements ProductOrderService {

    private ProductOrderDao productOrderDao;

    public ProductOrderServiceImpl() {
        productOrderDao = new ProductOrderDaoImpl();
    }

    @Override
    public List<ProductOrder> getProductOrderDetail(String nameTable) {
        return productOrderDao.getProductOrderDetail(nameTable);
    }

}
