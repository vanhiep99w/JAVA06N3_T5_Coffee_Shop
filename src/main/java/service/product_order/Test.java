/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.product_order;

import entities.ProductOrder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class Test {

    public static void main(String[] args) {
        ProductOrderService productOrderService = new ProductOrderServiceImpl();
        List<ProductOrder> productOrders = new ArrayList<>();
        productOrders = productOrderService.getProductOrderDetail("A03");
        if (productOrders == null) {
            System.out.println("null");
        } else {
            for (int i = 0; i < productOrders.size(); i++) {
                System.out.println(productOrders.get(i));
            }
        }
    }
}
