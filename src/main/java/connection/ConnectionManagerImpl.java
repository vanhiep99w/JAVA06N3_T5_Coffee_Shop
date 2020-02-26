/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class ConnectionManagerImpl implements ConnectionManager{

    @Override
    public Connection getConnection() {
        Connection cnn = null;

		try {
			// mysql driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffee_shop", "root", "ythiendolongky");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnn;
    }
    
}
