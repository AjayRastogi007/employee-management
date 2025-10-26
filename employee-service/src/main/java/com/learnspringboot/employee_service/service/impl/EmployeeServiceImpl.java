package com.learnspringboot.employee_service.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.learnspringboot.employee_service.dto.APIResponseDto;
import com.learnspringboot.employee_service.dto.DepartmentDto;
import com.learnspringboot.employee_service.dto.EmployeeDto;
import com.learnspringboot.employee_service.dto.OrganizationDto;
import com.learnspringboot.employee_service.entity.Employee;
import com.learnspringboot.employee_service.mapper.EmployeeMapper;
import com.learnspringboot.employee_service.repositosy.EmployeeRepository;
import com.learnspringboot.employee_service.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    // private final RestTemplate restTemplate;
    private final WebClient webClient;
    // private final APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        // ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
        // "http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
        // DepartmentDto.class);
        // DepartmentDto departmentDto = responseEntity.getBody();

        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8083/api/organizations/" + employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();

        // DepartmentDto departmentDto =
        // apiClient.getDepartmentByCode(employee.getDepartmentCode());

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);

        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Research and Development Department");

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;
    }
}
