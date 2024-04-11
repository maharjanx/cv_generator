package com.infodev.cvgenerator.user.repository;

import com.infodev.cvgenerator.user.entity.BasicInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface BasicInformationRepository extends JpaRepository<BasicInformation, Short>{


//    @Query(value = "select  * from basic_information WHERE ID=?1",nativeQuery = true)
//    public Map<String,Object>  getAllBasicInfo(int val, int val2);

}
