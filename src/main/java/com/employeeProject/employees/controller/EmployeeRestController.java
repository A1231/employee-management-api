package com.employeeProject.employees.controller;

import com.employeeProject.employees.entity.Employee;
import com.employeeProject.employees.request.EmployeeRequest;
import com.employeeProject.employees.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name="Employee Rest API Endpoints", description="Operations related to employees")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary="Get all employees", description="Retrieve a list of all employees")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Employee> findAll(){
        return  employeeService.findAll();
    }

    @Operation(summary="Fetch single employee", description="Retrieve details of one employees")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}" )
    public Employee getEMployee(@PathVariable @Min(value=1) long id){
        Employee theEmployee = employeeService.findById(id);
        return theEmployee;
    }

    @Operation(summary="Create a new employee", description="Save a new employee")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping( )
    public Employee addEmployee(@Valid @RequestBody EmployeeRequest employeeRequest){
        Employee employee = employeeService.save(employeeRequest);
        return employee;
    }

    @Operation(summary="Update an employee", description="Update details of the employee")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{employeeId}" )
    public Employee updateEmployee(@PathVariable @Min(value=1) long employeeId, @Valid @RequestBody EmployeeRequest employeeRequest){
        Employee employee = employeeService.update(employeeId, employeeRequest);
        return employee;
    }

    @Operation(summary="Delete an employee", description="Delete an employee")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{employeeId}" )
    public void deleteEmployee(@PathVariable @Min(value=1) long employeeId){
        employeeService.deleteById(employeeId);
    }
}
