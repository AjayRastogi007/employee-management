package com.learnspringboot.department_service.service.impl;

import org.springframework.stereotype.Service;

import com.learnspringboot.department_service.dto.DepartmentDto;
import com.learnspringboot.department_service.entity.Department;
import com.learnspringboot.department_service.mapper.DepartmentMapper;
import com.learnspringboot.department_service.repository.DepartmentRepository;
import com.learnspringboot.department_service.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        if (department == null) {
            throw new RuntimeException("Department not found with code: " + departmentCode);
        }
        return DepartmentMapper.mapToDepartmentDto(department);
    }   
}
