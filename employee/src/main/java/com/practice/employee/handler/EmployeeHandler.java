package com.practice.employee.handler;

import com.practice.employee.dao.EmployeeList;
import com.practice.employee.domin.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
@Component
public class EmployeeHandler {
    private EmployeeList employeeList;
    @Autowired
    public EmployeeHandler(EmployeeList employeeList){
        this.employeeList = employeeList;
    }
    public List<Employee> getAllEmployee(){
        return employeeList.getEmployeeList();
    }
    public void addAllEmployee(){
        employeeList.addAllEmployee();
    }
    public String addEmployee(Employee employee){
        return employeeList.addEmployee(employee);
    }
    public List<Employee> findEmployeeById(String id){
        return employeeList.getEmployeeById(id);
    }
    public String deleteEmployee(String id){
        return employeeList.deleteEmployee(id);
    }
    public String updateEmployee(String id,Employee employee){
        return employeeList.updateEmployee(id,employee);
    }
}
