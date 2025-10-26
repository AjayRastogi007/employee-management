package com.learnspringboot.organization_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspringboot.organization_service.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization findByOrganizationCode(String organizationCode);
}
