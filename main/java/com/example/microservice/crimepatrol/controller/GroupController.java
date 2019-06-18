package com.example.microservice.crimepatrol.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice.crimepatrol.db.Groups;
import com.example.microservice.crimepatrol.db.Users;
import com.example.microservice.crimepatrol.repository.GroupsRepository;
import com.example.microservice.crimepatrol.repository.UserRepository;
import com.example.microservice.crimepatrol.requestmodel.GroupRequest;

@RestController
@EnableAutoConfiguration

public class GroupController {

    @Autowired
    private GroupsRepository groupsRepository;

    @Autowired
    private UserRepository userRepository;

    public GroupController() {
        super();
    }

    @GetMapping(value = "/groups")
    public ResponseEntity<List<Groups>> getAllUsers() {
        List<Groups> groups = new ArrayList<>();
        groupsRepository.findAll().forEach(groups::add);
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @GetMapping(value = "/groups/{uuid}")
    public ResponseEntity<Object> getUser(@PathVariable("uuid") Long uuid) {
        Optional<Groups> group = groupsRepository.findById(uuid);
        if (group.isPresent()) {
            return new ResponseEntity<>(group.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("uuid not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/groups")
    public ResponseEntity<Object> createGroup(@RequestBody GroupRequest groupRequest) {
        String[] userUuids = groupRequest.getUserName().split(",");        
        for (String uuid : userUuids) {
            List<Users> optional = userRepository.findByname(uuid);
            if(!optional.isEmpty()){
                Groups group = new Groups(groupRequest.getName(), optional.stream().findAny().get().getName());
                group.setCreatedDate(Calendar.getInstance());
                try {
                    groupsRepository.save(group);
                } catch (Exception ex) {
                    ex.getMessage();
                }
            }
            
        }      
        return new ResponseEntity<>("Group is created successfully", HttpStatus.CREATED);
    }
}
