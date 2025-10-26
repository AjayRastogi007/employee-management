package com.learnspringboot.employee_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnspringboot.employee_service.dto.APIResponseDto;
import com.learnspringboot.employee_service.dto.EmployeeDto;
import com.learnspringboot.employee_service.service.EmployeeService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
    
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployeeDto = employeeService.saveEmployee(employeeDto);

        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}") 
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);

        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
    
}
