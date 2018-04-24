package com.practice.employee.web;

import com.practice.employee.dao.EmployeeList;
import com.practice.employee.domin.Employee;
import com.practice.employee.handler.EmployeeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeHandler employeeHandler;
    @GetMapping()
    public List<Employee> getAllEmployee(){
        employeeHandler.addAllEmployee();
        return employeeHandler.getAllEmployee();
    }
    @GetMapping(value = "/{id}")
    public List<Employee> findEmployeeById(@PathVariable("id") String id){
        return employeeHandler.findEmployeeById(id);
    }
    @PostMapping()
    public String addEmployee(@RequestBody Employee employee){
        return employeeHandler.addEmployee(employee);
    }
    @PutMapping(value = "/{id}")
    public String updateEmployee(@PathVariable("id") String id,@RequestBody Employee employee){
        return employeeHandler.updateEmployee(id,employee);
    }
    @DeleteMapping(value = "/{id}")
    public String deleteEmployee(@PathVariable("id") String id){
        return employeeHandler.deleteEmployee(id);
    }
}
