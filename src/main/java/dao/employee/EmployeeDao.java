/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.employee;

import entities.Employee;
import entities.Shift;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface EmployeeDao {

    public List<Employee> getAll();

    public List<Employee> getAll(Integer workID);

    public boolean update(Employee newEmployee);

    public boolean remove(Integer idEmployee);

    //return newEmployee with newIDd
    public Employee add(Employee newEmployee);
    
    
}
