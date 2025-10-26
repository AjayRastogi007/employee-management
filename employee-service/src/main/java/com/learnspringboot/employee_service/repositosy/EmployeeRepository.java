package com.learnspringboot.employee_service.repositosy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspringboot.employee_service.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
