package com.infodev.cvgenerator.user.repository;

import com.infodev.cvgenerator.user.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District, Short> {
}
