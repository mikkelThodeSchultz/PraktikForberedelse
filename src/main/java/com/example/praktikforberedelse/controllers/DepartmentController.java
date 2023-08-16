package com.example.praktikforberedelse.controllers;

import com.example.praktikforberedelse.models.Department;
import com.example.praktikforberedelse.services.IDepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@CrossOrigin
@RestController
public class DepartmentController {
    private IDepartmentService departmentService;

    public DepartmentController(IDepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping("/get/departments")
    public ResponseEntity<Set<Department>> getDepartments(){
        return new ResponseEntity<>(departmentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
        Optional<Department> department = departmentService.findById(id);
        if (department.isPresent()){
            return new ResponseEntity<>(department.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/post/departments")
    public ResponseEntity<Department> create (@RequestBody Department department){
        return new ResponseEntity<>(departmentService.save(department), HttpStatus.CREATED);
    }

    @PutMapping("/put/departments")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department){
        Optional<Department> optionalDepartment = departmentService.findById(department.getId());
        if (optionalDepartment.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Department departmentToUpdate = optionalDepartment.get();
        departmentToUpdate.setName(department.getName());
        departmentToUpdate.setClearance(department.getClearance());
        departmentToUpdate.setBuilding(department.getBuilding());
        // departmentToUpdate.setEmployeeList(department.getEmployeeList());
        return new ResponseEntity<>(departmentService.save(departmentToUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/delete/departments/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id){
        Optional<Department> optionalDepartment = departmentService.findById(id);
        if(optionalDepartment.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        departmentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
