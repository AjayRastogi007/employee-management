package com.learnspringboot.organization_service.service.impl;

import org.springframework.stereotype.Service;

import com.learnspringboot.organization_service.dto.OrganizationDto;
import com.learnspringboot.organization_service.entity.Organization;
import com.learnspringboot.organization_service.mapper.OrganizationMapper;
import com.learnspringboot.organization_service.repository.OrganizationRepository;
import com.learnspringboot.organization_service.service.OrganizationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    
    private final OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
