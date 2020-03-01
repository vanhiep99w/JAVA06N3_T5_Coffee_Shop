/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectDB;
import entities.Employee;
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
public class EmployeeDaoImpl implements EmployeeDao{
    
    private final Connection connection ;
    private Statement statement ;
    private PreparedStatement preStatement;
    private ResultSet resultSet ;

    public EmployeeDaoImpl() {
        this.connection = ConnectDB.getInstance().getConnection();
    }
    
    

    @Override
    public List<Employee> getAll() {
        
        final List<Employee> employees = new ArrayList<>();
        final String query = "select e.*, w.name_work, w.salary_an_hour \n" +
                    "from coffee_shop.employee e\n" +
                    "left join coffee_shop.work w \n" +
                    "on e.id_work = w.id_work;";
            
        try {

            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                Integer id_employee = resultSet.getInt("id_employee");
                String name_employee = resultSet.getString("name_employee");
                String phone = resultSet.getString("phone");
                Integer id_work = resultSet.getInt("id_work");
                String name_work = resultSet.getString("name_work");
                Float salary = resultSet.getFloat("salary_an_hour");
                
                Work work = new Work(id_work, name_work, salary);               
                Employee employee = new Employee(id_work, name_employee, phone, work);
                
                employees.add(employee);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return employees;
    }
    
}
