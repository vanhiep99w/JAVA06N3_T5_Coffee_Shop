/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.employee;

import entities.Employee;
import entities.Shift;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface EmployeeService {

    public List<Employee> getAll();

    public List<Employee> getALl(Integer workID);

    public boolean update(Employee newEmployee);

    public boolean remove(Integer idEmployee);

    public Employee add(Employee newEmployee);
    
    
}
