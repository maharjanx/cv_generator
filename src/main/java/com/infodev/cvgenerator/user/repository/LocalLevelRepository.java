package com.infodev.cvgenerator.user.repository;

import com.infodev.cvgenerator.user.entity.LocalLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalLevelRepository extends JpaRepository<LocalLevel, Short> {
}
