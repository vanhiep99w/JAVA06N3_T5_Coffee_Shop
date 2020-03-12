/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.Order;
/**
 *
 * @author Admin
 */
import java.time.LocalDateTime;
import java.util.Objects;

public class Product_Order {

    private Order order;
    private Integer amount;
    private LocalDateTime order_Time;
    private Product product;

    public Product_Order() {
    }

    public Product_Order(Order order, Integer amount, LocalDateTime order_Time, Product product) {
        this.order = order;
        this.amount = amount;
        this.order_Time = order_Time;
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public LocalDateTime getOrder_Time() {
        return order_Time;
    }

    public void setOrder_Time(LocalDateTime order_Time) {
        this.order_Time = order_Time;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.order);
        hash = 89 * hash + Objects.hashCode(this.product);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product_Order other = (Product_Order) obj;
        if (!Objects.equals(this.order, other.order)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }

}
