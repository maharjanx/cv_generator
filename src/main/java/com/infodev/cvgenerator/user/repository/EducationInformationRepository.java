package com.infodev.cvgenerator.user.repository;

import com.infodev.cvgenerator.user.entity.EducationInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationInformationRepository extends JpaRepository<EducationInformation, Short> {
    List<EducationInformation> findEducationInformationsByBasicInformationId(Short basicinfoId);
}
