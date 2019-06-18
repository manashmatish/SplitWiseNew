package com.example.microservice.crimepatrol.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.microservice.crimepatrol.db.Expenditures;
import com.example.microservice.crimepatrol.db.SplitDetails;

public interface ExpendituresRepository extends CrudRepository<Expenditures, Object>{
    
    public List<Expenditures> findByName(String name);

}
