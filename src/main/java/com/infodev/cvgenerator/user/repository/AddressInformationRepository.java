package com.infodev.cvgenerator.user.repository;

import com.infodev.cvgenerator.user.entity.AddressInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressInformationRepository extends JpaRepository<AddressInformation, Short> {
}
