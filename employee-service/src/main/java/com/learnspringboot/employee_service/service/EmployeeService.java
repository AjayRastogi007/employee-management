package com.learnspringboot.employee_service.service;

import com.learnspringboot.employee_service.dto.APIResponseDto;
import com.learnspringboot.employee_service.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
}
