package com.example.praktikforberedelse.services;

import com.example.praktikforberedelse.models.Department;
import com.example.praktikforberedelse.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class DepartmentService implements IDepartmentService{

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Set<Department> findAll() {
        return new HashSet<>(departmentRepository.findAll());
    }

    @Override
    public Department save(Department object) {
        return departmentRepository.save(object);
    }

    @Override
    public void delete(Department object) {
    }

    @Override
    public void deleteById(Long aLong) {
      departmentRepository.deleteById(aLong);
    }

    @Override
    public Optional<Department> findById(Long aLong) {
        return departmentRepository.findById(aLong);
    }
}
