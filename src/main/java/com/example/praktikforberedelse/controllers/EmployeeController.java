package com.example.praktikforberedelse.controllers;

import com.example.praktikforberedelse.models.Employee;
import com.example.praktikforberedelse.services.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@CrossOrigin
@RestController
public class EmployeeController {
    private IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService){
        this.employeeService = employeeService;
    }
   @GetMapping("/get/employees")
    public ResponseEntity<Set<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
   }

   @GetMapping("/get/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
       Optional<Employee> optionalEmployee = employeeService.findById(id);
       if (optionalEmployee.isEmpty()){
           return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(optionalEmployee.get(), HttpStatus.OK);
   }
   @PostMapping("/post/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
       return new ResponseEntity<>(employeeService.save(employee), HttpStatus.OK);
   }
    @PutMapping("/put/employees")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Optional<Employee> optionalEmployee = employeeService.findById(employee.getId());
        if (optionalEmployee.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Employee employeeToUpdate = optionalEmployee.get();
        employeeToUpdate.setName(employee.getName());
        employeeToUpdate.setHiredDate(employee.getHiredDate());
        employeeToUpdate.setSalary(employee.getSalary());
        employeeToUpdate.setDepartment(employee.getDepartment());
        return new ResponseEntity<>(employeeToUpdate, HttpStatus.OK);
    }
    @DeleteMapping("/delete/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        Optional<Employee> optionalEmployee = employeeService.findById(id);
        if (optionalEmployee.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}