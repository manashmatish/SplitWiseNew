package com.example.microservice.crimepatrol.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.microservice.crimepatrol.db.SplitDetails;

public interface SplitDetailsRepository extends CrudRepository<SplitDetails, Object>{
    
    public List<SplitDetails> findByExpenditureNameAndUserName(String expenditureName, String userName);
    
    public List<SplitDetails> findByExpenditureName(String expenditureUuid);
}
