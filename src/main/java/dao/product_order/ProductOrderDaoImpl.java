/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.product_order;

import connection.ConnectDB;
import entities.ProductOrder;
import entities.Product_Order;
import entities.Order;
import entities.Product;
import entities.Table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    private final Connection connection;
    private Statement statement;
    private PreparedStatement preStatement;
    private ResultSet resultSet;

    public ProductOrderDaoImpl() {
        connection = ConnectDB.getInstance().getConnection();
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
    public List<ProductOrder> getProductOrderDetail(String nameTable) {
        List<ProductOrder> productOrders = new ArrayList<>();
        ProductOrder productOrder = null;
        String query = "select coffee_shop.table.name_table, product.name_product, product_order.amount,\n"
                + "coffee_shop.product.price * product_order.amount as sum, coffee_shop.order.id_order\n"
                + "from coffee_shop.table join coffee_shop.order on coffee_shop.table.id_table = coffee_shop.order.id_table\n"
                + "join coffee_shop.product_order on coffee_shop.product_order.id_order = coffee_shop.order.id_order\n"
                + "join coffee_shop.product on coffee_shop.product_order.id_product = coffee_shop.product.id_product \n"
                + "where coffee_shop.table.name_table = ?";
        try {
            preStatement = connection.prepareStatement(query);
            preStatement.setString(1, nameTable);
            
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {
                productOrder = new ProductOrder(resultSet.getString("name_table"),
                        resultSet.getString("name_product"),
                        resultSet.getInt("amount"),
                        resultSet.getFloat("sum"),
                        resultSet.getInt("id_order"));
                productOrders.add(productOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                preStatement.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (productOrders != null) {
            return productOrders;
        } else {
            return null;
        }
    }

    @Override
    public List<Product_Order> getAll(Integer id_Table) {
        
        final List<Product_Order> product_Orders = new ArrayList<>();
        String query = "select po.*,p.name_product,p.price,o.id_table,t.name_table from coffee_shop.product_order po \n"
                + "left join coffee_shop.order o on po.id_order = o.id_order\n"
                + "left join coffee_shop.table t on o.id_table = t.id_table\n"
                + "left join coffee_shop.product p on po.id_product = p.id_product \n"
                + "where t.id_table = ?;";

        try {
            preStatement = connection.prepareStatement(query);
            
            preStatement.setInt(1, id_Table);
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {
                product_Orders.add(setData(resultSet));  
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductOrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
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
    public boolean delete(Integer id_Order) {
        return false;
    }
    
    
}
