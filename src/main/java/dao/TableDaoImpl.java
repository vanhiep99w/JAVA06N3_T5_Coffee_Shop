/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Table;

/**
 *
 * @author PC
 */
public class TableDaoImpl implements TableDao {

    private ConnectionManager connectionManager;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public TableDaoImpl() {
        connectionManager = new ConnectionManagerImpl();
        connection = connectionManager.getConnection();
    }

    @Override
    public List<Table> getAllTable() {
        connection = connectionManager.getConnection();
        List<Table> list = new ArrayList<Table>();
        String query = "select id_table,name,status from coffee_shop.table join "
                + "coffee_shop.table_status on coffee_shop.table.id_table_status "
                + "= coffee_shop.table_status.id_table_status";
        
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Table table = new Table(resultSet.getInt("id_table"), resultSet.getString("name"),
                resultSet.getString("status"));

                list.add(table);
            }
        } catch (SQLException e) {
            return null;
            // e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;

    }

}
