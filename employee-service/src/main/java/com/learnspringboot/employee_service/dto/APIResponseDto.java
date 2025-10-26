package com.learnspringboot.employee_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private EmployeeDto employeeDto;
    private DepartmentDto departmentDto;
    private OrganizationDto organizationDto;
}
