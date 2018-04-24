package com.practice.employee.dao;

import com.practice.employee.domin.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeList {
    public List<Employee> employeeList = new ArrayList<>();
    public void addAllEmployee(){
        Employee employee1 = new Employee("1","小刚",12,Employee.Gender.MALE);
        Employee employee2 = new Employee("2","小明",11,Employee.Gender.MALE);
        Employee employee3 = new Employee("3","小红",14,Employee.Gender.FAMALE);
        Employee employee4 = new Employee("4","李雷",15,Employee.Gender.MALE);
        Employee employee5 = new Employee("5","韩梅梅",16,Employee.Gender.FAMALE);
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);
    }
    public List<Employee> getEmployeeList(){
        return employeeList.stream().collect(Collectors.toList());
    }

    public List<Employee> getEmployeeById(String id){
        return employeeList.stream()
                .filter(e->e.getId().equals(id))
                .collect(Collectors.toList());
    }

    public String addEmployee(Employee employee){
        employeeList.add(employee);
        return "成功增加职员"+employee.getName()+"，它的ID是："+employee.getId();
    }

    public String deleteEmployee(String id){
        Employee employee = getEmployee(id);
        employeeList.remove(employee);
        return "成功删除职员"+employee.getName()+"，它的ID是："+employee.getId();
    }

    private Employee getEmployee(String id) {
        return employeeList.stream().filter(e->e.getId().equals(id)).findFirst().get();
    }

    public String updateEmployee(String id,Employee employee){
        Employee oldEmployee = getEmployee(id);
        employeeList.set(employeeList.indexOf(oldEmployee),employee);
        return "成功修改职员"+employee.getName()+"，它的ID是："+employee.getId();
    }
}
