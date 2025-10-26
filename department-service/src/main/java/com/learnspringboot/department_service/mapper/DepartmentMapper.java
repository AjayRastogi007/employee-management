package com.learnspringboot.department_service.mapper;

import com.learnspringboot.department_service.dto.DepartmentDto;
import com.learnspringboot.department_service.entity.Department;

public class DepartmentMapper {

    public static Department mapToDepartment(DepartmentDto departmentDto) {
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode());
    }

    public static DepartmentDto mapToDepartmentDto(Department department) {
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode());
    }
}
