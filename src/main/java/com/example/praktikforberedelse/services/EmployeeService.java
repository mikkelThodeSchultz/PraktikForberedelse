package com.example.praktikforberedelse.services;

import com.example.praktikforberedelse.models.Employee;
import com.example.praktikforberedelse.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeService implements IEmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Set<Employee> findAll() {
        return new HashSet<>(employeeRepository.findAll());
    }

    @Override
    public Employee save(Employee object) {
        return employeeRepository.save(object);
    }

    @Override
    public void delete(Employee object) {
    }

    @Override
    public void deleteById(Long aLong) {
        employeeRepository.deleteById(aLong);
    }

    @Override
    public Optional<Employee> findById(Long aLong) {
        return employeeRepository.findById(aLong);
    }
}
