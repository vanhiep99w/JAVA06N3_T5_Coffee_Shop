/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.work;

import connection.ConnectDB;
import entities.Work;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class WorkDaoImpl implements WorkDao{
    
    private final Connection connection ;
    private Statement statement ;
    private PreparedStatement preStatement;
    private ResultSet resultSet ;

    public WorkDaoImpl() {
        connection = ConnectDB.getInstance().getConnection();
    }

    @Override
    public List<Work> getAll() {
        final List<Work> works = new ArrayList<>();
        String query = "SELECT * FROM coffee_shop.work;";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                Integer id = resultSet.getInt("id_work");
                String name = resultSet.getString("name_work");
                Float salary = resultSet.getFloat("salary_an_hour");
                
                Work work = new Work(id, name, salary);
                works.add(work);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WorkDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(WorkDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }          
        } 
        return works;
    }

    
    
    
}
