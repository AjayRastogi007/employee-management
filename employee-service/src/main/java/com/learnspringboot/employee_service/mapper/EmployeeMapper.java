package com.learnspringboot.employee_service.mapper;

import com.learnspringboot.employee_service.dto.EmployeeDto;
import com.learnspringboot.employee_service.entity.Employee;

public class EmployeeMapper {
    
    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
            employeeDto.getId(),
            employeeDto.getFirstName(),
            employeeDto.getLastName(),
            employeeDto.getEmail(),
            employeeDto.getDepartmentCode(),
            employeeDto.getOrganizationCode()
        );
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail(),
            employee.getDepartmentCode(),
            employee.getDepartmentCode()
        );
    }
}
