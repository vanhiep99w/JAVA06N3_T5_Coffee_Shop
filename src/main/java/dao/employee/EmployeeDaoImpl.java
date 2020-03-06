/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.employee;

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
    
    private Employee setInfor(ResultSet resultSet){
        Employee employee = new Employee();
        try {
            Integer id_employee = resultSet.getInt("id_employee");
            String name_employee = resultSet.getString("name_employee");
            String phone = resultSet.getString("phone");
            Integer id_work = resultSet.getInt("id_work");
            String name_work = resultSet.getString("name_work");
            Float salary = resultSet.getFloat("salary_an_hour");
            
            Work work = new Work(id_work, name_work, salary);               
            employee = new Employee(id_employee, name_employee, phone, work);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
        
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
                Employee employee = setInfor(resultSet);
                
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

    @Override
    public List<Employee> getAll(Integer workID) {

        final List<Employee> employees = new ArrayList<>();
        final String query = "select e.*, w.name_work, w.salary_an_hour \n" +
                    "from coffee_shop.employee e\n" +
                    "left join coffee_shop.work w \n" +
                    "on e.id_work = w.id_work where e.id_work = ?;";
            
        try {
           
            preStatement = connection.prepareCall(query);
            preStatement.setInt(1, workID);
            resultSet = preStatement.executeQuery();
            
            while(resultSet.next()){
                Employee employee = setInfor(resultSet);
                
                employees.add(employee);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                resultSet.close();
                preStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return employees;
    }

    @Override
    public boolean update(Employee newEmployee) {
        boolean result = false;
        
        String query = "update coffee_shop.employee e \n" +
                        "set e.name_employee = ?,\n" +
                        "e.id_work = ?,\n" +
                        "e.phone = ?\n" +
                        "where e.id_employee = ?;";
        
        if(newEmployee != null){
            try {
                preStatement = connection.prepareCall(query);
                preStatement.setString(1, newEmployee.getName());
                preStatement.setInt(2, newEmployee.getWork().getId());
                preStatement.setString(3, newEmployee.getPhone());
                preStatement.setInt(4, newEmployee.getId());
                
                result = (preStatement.executeUpdate() == 0) ? false : true;
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    preStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return result;
    }

    @Override
    public boolean remove(Integer idEmployee) {
        boolean result = false;
        
        String query = "delete from coffee_shop.employee e \n" +
                        "where e.id_employee = ?;";
        try {
            preStatement = connection.prepareCall(query);
            preStatement.setInt(1, idEmployee);
            
            result = (preStatement.executeUpdate() == 0) ? false : true;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                preStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return result;
    }

    @Override
    public boolean add(Employee newEmployee) {
        boolean result = false;
        
        String query = "insert into coffee_shop.employee "
                        + "(employee.name_employee, employee.phone, employee.id_work)\n" 
                        + "value(?,?,?) ;";
        try {
            preStatement = connection.prepareCall(query);
            preStatement.setString(1, newEmployee.getName());
            preStatement.setString(2, newEmployee.getPhone());
            preStatement.setInt(3, newEmployee.getWork().getId());
            
            result = (preStatement.executeUpdate() == 0) ? false : true;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                preStatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
}
