package com.shawn.employeeservice.controller;


import com.shawn.employeeservice.model.Employee;
import com.shawn.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER= LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping
    public Employee add(@RequestBody Employee employee){
        LOGGER.info("Employee add: {}" , employee);
        return employeeRepository.addEmployee(employee);
    }


    @GetMapping
    public List<Employee> findAll(){
        LOGGER.info("Employees find");

        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
        LOGGER.info("Employee find: id={}" , id);

        return employeeRepository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable Long departmentId){
        LOGGER.info("Employee find: DepartmentId={}" , departmentId);

        return employeeRepository.findByDepartmentId(departmentId);
    }



}
