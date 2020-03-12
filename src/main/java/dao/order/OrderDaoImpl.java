/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.order;

import connection.ConnectDB;
import entities.Employee;
import entities.Order;
import entities.Table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class OrderDaoImpl implements OrderDao {

    private final Connection connection;
    private Statement statement;
    private PreparedStatement preStatement;
    private ResultSet resultSet;

    public OrderDaoImpl() {
        this.connection = ConnectDB.getInstance().getConnection();
    }
    
    public Order setData(ResultSet resultSet)throws SQLException{
        Integer idOrder = resultSet.getInt("id_order");
        
        Integer idEmployee = resultSet.getInt("id_employee");
        String nameEmployee = resultSet.getString("name_employee");
        Employee employee = new Employee();
        employee.setId(idEmployee);
        employee.setName(nameEmployee);
        
        Integer idTable = resultSet.getInt("id_table");
        String nameTable = resultSet.getString("name_table");
        Table table = new Table();
        table.setId(idTable);
        table.setName(nameTable);
        
        
        LocalDateTime time = resultSet.getTimestamp("time_order").toLocalDateTime();
        
        return new Order(idOrder, employee, table, time);
        
    }

    @Override
    public boolean add(Order newOrder) {
        boolean result = false;

        return result;
    }

    @Override
    public List<Order> getAll() {
        final List<Order> orders = new ArrayList<>();
        
        return orders;
    }

    @Override
    public Order getOne(Integer id_Order) {
        final Order order = new Order();
        String query = "select o.*,t.name_table,t.id_table_status,e.name_employee from coffee_shop.order o\n"
                + "left join coffee_shop.employee e \n"
                + "on o.id_employee = e.id_employee\n"
                + "left join coffee_shop.table t\n"
                + "on o.id_table = t.id_table\n"
                + "where o.id_order = ?;";
        try {
            preStatement = connection.prepareStatement(query);
            preStatement.setInt(1, id_Order);
            resultSet = preStatement.executeQuery();
            resultSet.next();
            order.copy(setData(resultSet));
        } catch (SQLException ex) {
            Logger.getLogger(OrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                resultSet.close();
                preStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return order;
    }

   

}
