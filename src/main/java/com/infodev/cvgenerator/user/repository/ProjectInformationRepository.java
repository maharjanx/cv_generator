package com.infodev.cvgenerator.user.repository;

import com.infodev.cvgenerator.user.entity.ProjectInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectInformationRepository extends JpaRepository<ProjectInformation, Short> {
}
