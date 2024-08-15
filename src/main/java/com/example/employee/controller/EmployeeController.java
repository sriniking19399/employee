/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 */

// Write your code here

package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.employee.service.EmployeeH2Service;
import com.example.employee.model.Employee;
import java.util.*;

@RestController
public class EmployeeController {

    @Autowired
    public EmployeeH2Service eService;

    @GetMapping("/employees")
    public ArrayList<Employee> getAllEmployees() {
        return eService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") int employeeId) {
        return eService.getEmployeeById(employeeId);
    }

    @PostMapping("/employees")

    public Employee addEmployee(@RequestBody Employee employee) {
        return eService.addEmployee(employee);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updatEmployee(@PathVariable("employeeId") int employeeId, @RequestBody Employee employee) {
        return eService.updatEmployee(employeeId, employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") int employeeId) {
        eService.deleteEmployee(employeeId);
    }

}