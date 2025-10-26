package com.learnspringboot.organization_service.service;

import com.learnspringboot.organization_service.dto.OrganizationDto;

public interface OrganizationService {
    OrganizationDto saveOrganization(OrganizationDto organizationDto);
    OrganizationDto getOrganizationByCode(String organizationCode);
}
