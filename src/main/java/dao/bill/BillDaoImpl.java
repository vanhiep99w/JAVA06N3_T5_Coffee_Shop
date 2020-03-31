/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.bill;

import connection.ConnectDB;
import dao.product_order.ProductOrderDaoImpl;
import entities.Bill;
import entities.BillToPrint;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class BillDaoImpl implements BillDao {

    private final Connection connection;
    private Statement statement;
    private PreparedStatement preStatement;
    private ResultSet resultSet;

    public BillDaoImpl() {
        connection = ConnectDB.getInstance().getConnection();
    }

    @Override
    public boolean add(Bill bill) {
        boolean result = false;
        String query = "insert into coffee_shop.bill(time_bill,vat,sum,id_order)\n"
                + "value(?,?,?,?);";
        try {
            preStatement = connection.prepareStatement(query);
            preStatement.setTimestamp(1, Timestamp.valueOf(bill.getBillTime()));
            preStatement.setFloat(2, bill.getVat());
            preStatement.setFloat(3, bill.getSum());
            preStatement.setInt(4, bill.getIdOrder());

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
    public List<BillToPrint> getBillToPrint(int id_Order) {
        List<BillToPrint> listBill = new ArrayList<>();
        String query = "select coffee_shop.product.name_product,coffee_shop.product_order.amount,coffee_shop.product_order.amount*coffee_shop.product.price as sum  \n"
                + "from \n"
                + "coffee_shop.product join coffee_shop.product_order \n"
                + "on\n"
                + "coffee_shop.product.id_product = coffee_shop.product_order.id_product\n"
                + "where coffee_shop.product_order.id_order = ?;";
        try {
            preStatement = connection.prepareStatement(query);

            preStatement.setInt(1, id_Order);
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {
                String nameProduct = resultSet.getString("name_product");
                Integer amountProduct = resultSet.getInt("amount");
                Float sum = resultSet.getFloat("sum");
                listBill.add(new BillToPrint(nameProduct, amountProduct, sum));
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

        return listBill;
    }

    @Override
    public Float getSumOfDay(String day) {
        Float sum = 0f;
        String query = "select sum(coffee_shop.bill.sum) as sumofday from "
                + "coffee_shop.bill where coffee_shop.bill.time_bill like ?;";
        try {
            preStatement = connection.prepareStatement(query);
            preStatement.setString(1, day+"%");
            resultSet = preStatement.executeQuery();
            while (resultSet.next()) {
                sum = resultSet.getFloat("sumofday");
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
        return sum;
    }

}
