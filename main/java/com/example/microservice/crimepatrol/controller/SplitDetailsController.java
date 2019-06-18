package com.example.microservice.crimepatrol.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice.crimepatrol.db.SplitDetails;
import com.example.microservice.crimepatrol.repository.SplitDetailsRepository;
import com.example.microservice.crimepatrol.requestmodel.SplitDetailsRequest;
import com.example.microservice.crimepatrol.requestmodel.SplitDetailsRequest.Split;

@RestController
@EnableAutoConfiguration

public class SplitDetailsController {

    @Autowired
    private SplitDetailsRepository splitDetailsRepository;

    public SplitDetailsController() {
        super();
    }

    @GetMapping(value = "/splitdetails")
    public ResponseEntity<List<SplitDetails>> getAllUsers() {
        List<SplitDetails> expenditures = new ArrayList<>();
        splitDetailsRepository.findAll().forEach(expenditures::add);
        return new ResponseEntity<>(expenditures, HttpStatus.OK);
    }

    @GetMapping(value = "/splitdetails/{uuid}")
    public ResponseEntity<Object> getUser(@PathVariable("uuid") Long uuid) {
        Optional<SplitDetails> expenditures = splitDetailsRepository.findById(uuid);
        if (expenditures.isPresent()) {
            return new ResponseEntity<>(expenditures.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("uuid not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/splitdetails")
    public ResponseEntity<Object> createSplitDetails(@RequestBody SplitDetailsRequest splitDetailsRequest) {
        List<Split> userSplit = splitDetailsRequest.getUserSplit();
        userSplit.stream().forEach(split -> createEntity(splitDetailsRequest.getExpenditureName(), split.getUserName(),split.getAmount()));
        return new ResponseEntity<>("Split Details is created successfully", HttpStatus.CREATED);
    }
    
    public void createEntity(String expUuid, String userUuid, Long amountPending){
        SplitDetails splitDetail = new SplitDetails(expUuid, userUuid,
                0l, amountPending);
        splitDetail.setCreatedDate(Calendar.getInstance());
        splitDetailsRepository.save(splitDetail);
    }
    
}
