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

    private static final Connection connection;
    private Statement statement;
    private PreparedStatement preStatement;
    private ResultSet resultSet;

    static{
        connection = ConnectDB.getInstance().getConnection();
    }

    public OrderDaoImpl() {
        
    }

    public Order setData(ResultSet resultSet) throws SQLException {
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
    public List<Order> getAll() {
        final List<Order> orders = new ArrayList<>();

        return orders;
    }

    @Override
    public int add(Order newOrder) {
        boolean b = false;
        int result = 0;
        String query = "insert into coffee_shop.order(id_employee,id_table,time_order )\n"
                + "value(?,?,?);";
        try {

            preStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            preStatement.setInt(1, 3);
            preStatement.setInt(2, newOrder.getTable().getId());
            preStatement.setTimestamp(3, Timestamp.valueOf(newOrder.getTime()));

            b = (preStatement.executeUpdate() == 0) ? false : true;

            resultSet = preStatement.getGeneratedKeys();
            resultSet.next();
            result = (b == false) ? 0 : resultSet.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                preStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
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
        } finally {
            try {
                resultSet.close();
                preStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return order;
    }

    @Override
    public List<Order> getAll(Integer idTableStatus) {
        final List<Order> orders = new ArrayList<>();
        String query = "select o.*,t.name_table,e.name_employee from coffee_shop.table t \n"
                + "left join coffee_shop.order o\n"
                + "on t.id_table = o.id_table\n"
                + "left join coffee_shop.employee e \n"
                + "on e.id_employee = o.id_employee\n"
                + "where t.id_table_status = ? ;";

        try {
            preStatement = connection.prepareStatement(query);
            preStatement.setInt(1, idTableStatus);
            resultSet = preStatement.executeQuery();
            while(resultSet.next()){
                Order order = setData(resultSet);
                orders.add(order);
            }
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

        return orders;
    }

}
