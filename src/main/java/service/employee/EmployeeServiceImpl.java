/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.employee;

import dao.employee.EmployeeDao;
import dao.employee.EmployeeDaoImpl;
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

    @Override
    public List<Employee> getALl(Integer workID) {
        return employeeDao.getAll(workID);
    }

    @Override
    public boolean update(Employee newEmployee) {
        return employeeDao.update(newEmployee);
    }

    @Override
    public boolean remove(Integer idEmployee) {
        return employeeDao.remove(idEmployee);
    }

    @Override
    public boolean add(Employee newEmployee) {
        return employeeDao.add(newEmployee);
    }
    
}
