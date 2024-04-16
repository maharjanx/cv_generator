package com.infodev.cvgenerator.user.repository;

import com.infodev.cvgenerator.user.entity.ProjectInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectInformationRepository extends JpaRepository<ProjectInformation, Short> {
    List<ProjectInformation> findByExperienceInformation_BasicInformation_Id(Short basicInfoId);
    List<ProjectInformation> findProjectInformationsByExperienceInformationId(Short expInfoId);
}
