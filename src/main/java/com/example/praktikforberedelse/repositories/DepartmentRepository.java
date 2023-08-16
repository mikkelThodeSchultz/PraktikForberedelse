package com.example.praktikforberedelse.repositories;

import com.example.praktikforberedelse.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
