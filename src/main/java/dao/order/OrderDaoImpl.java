/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.order;

import connection.ConnectDB;
import entities.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class OrderDaoImpl implements OrderDao{
    private final Connection connection ;
    private Statement statement ;
    private PreparedStatement preStatement;
    private ResultSet resultSet ;

    public OrderDaoImpl() {
        this.connection = ConnectDB.getInstance().getConnection();
    }

    @Override
    public boolean add(Order newOrder) {
        boolean result = false;
        
        
        return result;
    }
    
    
}
