/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.product_order;

import connection.ConnectDB;
import entities.Product_Order;
import entities.Order;
import entities.Product;
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
 * @author PC
 */
public class ProductOrderDaoImpl implements ProductOrderDao {

    private static final Connection connection;
    private Statement statement;
    private PreparedStatement preStatement;
    private ResultSet resultSet;
    static{
        connection = ConnectDB.getInstance().getConnection();
    }
    
    public ProductOrderDaoImpl() {
        
    }

    public Product_Order setData(ResultSet resultSet) throws SQLException {

        Integer id_Order = resultSet.getInt("id_order");
        Integer id_Table = resultSet.getInt("id_table");
        String name_Table = resultSet.getString("name_table");
        Table table = new Table();
        table.setId(id_Table);
        table.setName(name_Table);
        Order order = new Order();
        order.setId_Order(id_Order);
        order.setTable(table);

        Integer id_Product = resultSet.getInt("id_product");
        String name_product = resultSet.getString("name_product");
        Float price = resultSet.getFloat("price");
        Product product = new Product();
        product.setId(id_Product);
        product.setName(name_product);
        product.setPrice(price);

        Integer amount = resultSet.getInt("amount");
        LocalDateTime time = resultSet.getTimestamp("time_product_order").toLocalDateTime();

        Product_Order product_Order = new Product_Order(order, amount, time, product);
        return product_Order;
    }

    @Override
    public List<Product_Order> getAll(Integer id_Order) {

        final List<Product_Order> product_Orders = new ArrayList<>();

        String query = "select po.*,p.name_product,p.price,o.id_table,t.name_table from coffee_shop.product_order po \n"
                + "left join coffee_shop.order o on po.id_order = o.id_order\n"
                + "left join coffee_shop.table t on o.id_table = t.id_table\n"
                + "left join coffee_shop.product p on po.id_product = p.id_product \n"
                + "where o.id_order = ?;";

        try {
            preStatement = connection.prepareStatement(query);

            preStatement.setInt(1, id_Order);
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {
                product_Orders.add(setData(resultSet));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductOrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resultSet.close();
                preStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductOrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return product_Orders;
    }

    @Override
    public boolean delete(Integer id_Order, Integer id_Product) {
        boolean result = false;
        String query = "delete from coffee_shop.product_order\n"
                + "where id_order = ? and id_product = ?;";
        try {
            preStatement = connection.prepareStatement(query);
            preStatement.setInt(1, id_Order);
            preStatement.setInt(2, id_Product);
            result = (preStatement.executeUpdate() == 0) ? false : true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductOrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                preStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductOrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

    @Override
    public boolean add(Product_Order newProduct_Order) {
        boolean result = false;
        String query = "insert into coffee_shop.product_order(id_order,amount,time_product_order,id_product)\n"
                + "value(?,?,?,?);";
        try {
            preStatement = connection.prepareStatement(query);
            preStatement.setInt(1, newProduct_Order.getOrder().getId_Order());
            preStatement.setInt(2, newProduct_Order.getAmount());
            preStatement.setTimestamp(3, Timestamp.valueOf(newProduct_Order.getOrder_Time()));
            preStatement.setInt(4, newProduct_Order.getProduct().getId());

            result = (preStatement.executeUpdate() == 0) ? false : true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductOrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                preStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductOrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    @Override
    public boolean update(Product_Order product_Order) {
        boolean result = false;
        String query = "update coffee_shop.product_order po \n"
                + "set po.amount = ?\n"
                + "where po.id_order = ?\n"
                + "and po.id_product = ?;";
        try {
            preStatement = connection.prepareStatement(query);
            preStatement.setInt(1, product_Order.getAmount());
            preStatement.setInt(2, product_Order.getOrder().getId_Order());
            preStatement.setInt(3, product_Order.getProduct().getId());
            result = (preStatement.executeUpdate() == 0) ? false : true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductOrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                preStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductOrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    @Override
    public List<Float> getSum(Integer id_Order) {
        List<Float> list = new ArrayList<>();
        String query = "select coffee_shop.product_order.amount*coffee_shop.product.price as sumpay"
                + " from coffee_shop.product_order join coffee_shop.product\n"
                + "on coffee_shop.product_order.id_product = coffee_shop.product.id_product "
                + "where coffee_shop.product_order.id_order = ?;";
        try {
            preStatement = connection.prepareStatement(query);
            preStatement.setInt(1, id_Order);
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getFloat("sumpay"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductOrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                preStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductOrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public boolean deleteOrder(Integer id_Order) {
        boolean result = false;
        String query = "delete from coffee_shop.product_order\n"
                + "where id_order = ?;";
        try {
            preStatement = connection.prepareStatement(query);
            preStatement.setInt(1, id_Order);
            result = (preStatement.executeUpdate() == 0) ? false : true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductOrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                preStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductOrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

}
