package com.learnspringboot.organization_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnspringboot.organization_service.dto.OrganizationDto;
import com.learnspringboot.organization_service.service.OrganizationService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto savedOrganizationDto = organizationService.saveOrganization(organizationDto);

        return new ResponseEntity<>(savedOrganizationDto, HttpStatus.CREATED);
    }

    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("code") String organizationCode) {
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);

        return new ResponseEntity<>(organizationDto, HttpStatus.OK);
    }
}
