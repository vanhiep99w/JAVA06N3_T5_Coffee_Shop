/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.product_order;

import entities.ProductOrder;
import java.util.List;

/**
 *
 * @author PC
 */
public interface ProductOrderDao {
    public List<ProductOrder> getProductOrderDetail(String nameTable);
}
