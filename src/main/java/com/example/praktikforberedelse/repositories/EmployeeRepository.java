package com.example.praktikforberedelse.repositories;

import com.example.praktikforberedelse.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
