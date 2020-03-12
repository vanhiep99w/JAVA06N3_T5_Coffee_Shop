/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Admin
 */
public class Order {
    private Integer id_Order;
    private Employee employee;
    private Table table;
    private LocalDateTime time;

    public Order() {}

    public Order(Integer id_Order, Employee employee, Table table, LocalDateTime time) {
        this.id_Order = id_Order;
        this.employee = employee;
        this.table = table;
        this.time = time;
    }
    
    public void copy(Order order){
        this.id_Order = order.id_Order;
        this.employee = order.employee;
        this.table = order.table;
        this.time = order.time;
    }

    public Integer getId_Order() {
        return id_Order;
    }

    public void setId_Order(Integer id_Order) {
        this.id_Order = id_Order;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id_Order);
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
        final Order other = (Order) obj;
        if (!Objects.equals(this.id_Order, other.id_Order)) {
            return false;
        }
        return true;
    }
    
    
}
