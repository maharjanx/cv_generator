package com.infodev.cvgenerator.user.repository;

import com.infodev.cvgenerator.user.entity.FileInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileInformationRepository extends JpaRepository<FileInformation, Short> {
    Optional<FileInformation> findByName(String fileName);
}
