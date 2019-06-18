package com.example.microservice.crimepatrol.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.microservice.crimepatrol.db.Groups;

public interface GroupsRepository extends CrudRepository<Groups, Object>{

}
