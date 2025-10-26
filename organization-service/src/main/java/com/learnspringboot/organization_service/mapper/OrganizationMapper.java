package com.learnspringboot.organization_service.mapper;

import com.learnspringboot.organization_service.dto.OrganizationDto;
import com.learnspringboot.organization_service.entity.Organization;

public class OrganizationMapper {

    public static Organization mapToOrganization(OrganizationDto organizationDto) {
        return new Organization(
            organizationDto.getId(),
            organizationDto.getOrganizationName(),
            organizationDto.getOrganizationDescription(),
            organizationDto.getOrganizationCode(),
            organizationDto.getCreatedDate()

        );
    }

    public static OrganizationDto mapToOrganizationDto(Organization organization) {
        return new OrganizationDto(
            organization.getId(),
            organization.getOrganizationName(),
            organization.getOrganizationDescription(),
            organization.getOrganizationCode(),
            organization.getCreatedDate()
        );
    }
}
