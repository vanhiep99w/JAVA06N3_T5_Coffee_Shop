/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.category;

import connection.ConnectDB;
import entities.Category;
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
public class CategoryDaoImpl implements CategoryDao{
    
    private static final Connection connection ;
    private Statement statement ;
    private PreparedStatement preStatement;
    private ResultSet resultSet ;
    
    static{
        connection = ConnectDB.getInstance().getConnection();
    }

    public CategoryDaoImpl() {
        
    }
    

    @Override
    public List<Category> getAll() {
        List<Category> categorys = new ArrayList<>();
        String query = "SELECT * FROM coffee_shop.category;";
        
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                Integer id_Category = resultSet.getInt("id_category");
                String name = resultSet.getString("name_category");
                Category category = new Category(id_Category, name);
                categorys.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return categorys;
    }
    
}
