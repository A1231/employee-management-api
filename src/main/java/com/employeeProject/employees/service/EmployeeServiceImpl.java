package com.employeeProject.employees.service;

import com.employeeProject.employees.dao.EmployeeDAO;
import com.employeeProject.employees.entity.Employee;
import com.employeeProject.employees.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(long theId) {
        Employee theEmployee = employeeDAO.findById(theId);
        return theEmployee;
    }

    @Transactional
    @Override
    public Employee save(EmployeeRequest theEmployeeRequest) {
        Employee theEmployee = convertToEmployee(0, theEmployeeRequest);
        return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public Employee update(long id, EmployeeRequest employeeRequest) {
        Employee theEmployee = convertToEmployee(id, employeeRequest);
        return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(long theId) {
        employeeDAO.deleteById(theId);
    }

    @Override
    public Employee convertToEmployee(long id, EmployeeRequest employeeRequest) {
        return new Employee(id, employeeRequest.getFirstName(), employeeRequest.getLastName(), employeeRequest.getEmail());
    }
}
