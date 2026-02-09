package com.employeeProject.employees.service;

import com.employeeProject.employees.entity.Employee;
import com.employeeProject.employees.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(long theId);
    Employee save(EmployeeRequest theEmployeeRequest);
    Employee update(long id, EmployeeRequest employeeRequest);
    void deleteById(long theId);
    Employee convertToEmployee(long id, EmployeeRequest employeeRequest);
}
