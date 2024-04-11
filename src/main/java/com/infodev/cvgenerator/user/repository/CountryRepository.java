package com.infodev.cvgenerator.user.repository;

import com.infodev.cvgenerator.user.dto.CountryDto;
import com.infodev.cvgenerator.user.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository
      extends JpaRepository<Country, Short>
{

}
