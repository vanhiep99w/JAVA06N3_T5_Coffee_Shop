/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.product_order;

import connection.ConnectDB;
import entities.ProductOrder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
                connection.close();
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

}
