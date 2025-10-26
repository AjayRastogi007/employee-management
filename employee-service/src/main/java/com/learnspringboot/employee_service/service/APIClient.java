package com.learnspringboot.employee_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learnspringboot.employee_service.dto.DepartmentDto;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/departments/{department-code}")
    public DepartmentDto getDepartmentByCode(@PathVariable("department-code") String departmentCode);
}
