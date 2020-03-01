/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import entities.Employee;
import java.util.List;

/**
 *
 * @author Admin
 */
public class EmployeeServiceImpl implements EmployeeService{
    
    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl() {
        employeeDao = new EmployeeDaoImpl();
    }
    
    

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }
    
}
