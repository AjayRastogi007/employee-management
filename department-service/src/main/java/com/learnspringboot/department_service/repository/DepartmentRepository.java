package com.learnspringboot.department_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspringboot.department_service.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentCode(String departmentCode);
}
