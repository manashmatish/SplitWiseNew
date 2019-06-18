package com.example.microservice.crimepatrol.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.microservice.crimepatrol.db.Users;

public interface UserRepository extends CrudRepository<Users, Object>{
    
    public List<Users> findByname(String name); 

}
