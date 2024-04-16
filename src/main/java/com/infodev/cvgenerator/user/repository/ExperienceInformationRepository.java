package com.infodev.cvgenerator.user.repository;

import com.infodev.cvgenerator.user.entity.ExperienceInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceInformationRepository extends JpaRepository<ExperienceInformation, Short> {
    List<ExperienceInformation> findExperienceInformationsByBasicInformationId(Short basicinfoId);
}
