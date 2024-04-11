package com.infodev.cvgenerator.user.repository;

import com.infodev.cvgenerator.user.entity.EducationInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationInformationRepository extends JpaRepository<EducationInformation, Short> {
}
