package com.example.microservice.crimepatrol.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice.crimepatrol.db.Expenditures;
import com.example.microservice.crimepatrol.db.SplitDetails;
import com.example.microservice.crimepatrol.db.Users;
import com.example.microservice.crimepatrol.repository.ExpendituresRepository;
import com.example.microservice.crimepatrol.repository.SplitDetailsRepository;
import com.example.microservice.crimepatrol.repository.UserRepository;
import com.example.microservice.crimepatrol.requestmodel.ExpenditureRequest;
import com.example.microservice.crimepatrol.requestmodel.UserPayRequest;
import com.example.microservice.crimepatrol.responsemodel.ExpenditureAggregatedResponse;
import com.example.microservice.crimepatrol.responsemodel.ExpenditureAggregatedResponse.Split;

@RestController
@EnableAutoConfiguration

public class ExpenditureController {

    @Autowired
    private ExpendituresRepository expendituresRepository;

    @Autowired
    private SplitDetailsRepository splitDetailsRepository;
    
    @Autowired
    private UserRepository userRepository;

    Long owedAmount = 0l;

    public ExpenditureController() {
        super();
    }

    @GetMapping(value = "/expenditures")
    public ResponseEntity<List<Expenditures>> getAllExpenditures() {
        List<Expenditures> expenditures = new ArrayList<>();
        expendituresRepository.findAll().forEach(expenditures::add);
        return new ResponseEntity<>(expenditures, HttpStatus.OK);
    }

    @GetMapping(value = "/expenditures/{uuid}")
    public ResponseEntity<Object> getExpenditure(@PathVariable("uuid") Long uuid) {
        Optional<Expenditures> expenditures = expendituresRepository.findById(uuid);
        if (expenditures.isPresent()) {
            return new ResponseEntity<>(expenditures.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("uuid not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/expenditures")
    public ResponseEntity<Object> createExpenditures(@RequestBody ExpenditureRequest expenditureRequest) {
        Expenditures expenditures = new Expenditures(expenditureRequest.getGroupName(), expenditureRequest.getAmount(),
                expenditureRequest.getUserUid(), expenditureRequest.getName());
        expenditures.setCreatedDate(Calendar.getInstance());
        expendituresRepository.save(expenditures);
        return new ResponseEntity<>("Expenditure is created successfully", HttpStatus.CREATED);
    }

    @PutMapping(value = "/expenditures/{uuid}/pay/{userName}")
    public ResponseEntity<Object> updateExpenditures(@PathVariable("uuid") String name, @PathVariable("userName") String userName,
            @RequestBody UserPayRequest userPayRequest) {

        List<SplitDetails> result = splitDetailsRepository.findByExpenditureNameAndUserName(name, userName);

        if (!result.isEmpty() && (result.stream().findFirst().isPresent())) {
                SplitDetails splitDetails = result.stream().findFirst().get();
                splitDetails.setAmountReceived(userPayRequest.getAmount());
                splitDetailsRepository.save(splitDetails);
        }
        
        return new ResponseEntity<>("Expenditure is updated successfully", HttpStatus.CREATED);
    }

    @GetMapping(value = "/expenditures/{uuid}/pay/{userName}")
    public ResponseEntity<Object> getOwedAmount(@PathVariable("uuid") String name, @PathVariable("userName") String userName,
            @QueryParam("payee") String payee) {

        owedAmount = 0l;
        List<SplitDetails> result = splitDetailsRepository.findByExpenditureNameAndUserName(name, payee);
        if (!result.isEmpty()) {
            result.stream().forEach(l -> calculateOwedAmount(l.getAmountReceived(), l.getAmountRemaining()));

        }
        return new ResponseEntity<>("Owed amount " + owedAmount, HttpStatus.CREATED);
    }

    @GetMapping(value = "/expenditures/{uuid}/aggregatedinfo")
    public ResponseEntity<Object> getaggregated(@PathVariable("uuid") String name) {

        List<SplitDetails> splitDetails = splitDetailsRepository.findByExpenditureName(name);
        List<Expenditures> expenditures = expendituresRepository.findByName(name);
        Iterable<Users> usersIt = userRepository.findAll();
        
        Spliterator<Users> 
            splUserIterator = Spliterators.spliteratorUnknownSize(usersIt.iterator(), 0); 
        Stream<Users> stream = StreamSupport.stream(splUserIterator, false); 
        List<Users> users = stream.collect(Collectors.toList());

        ExpenditureAggregatedResponse aggregatedResponse = new ExpenditureAggregatedResponse();
        if (!expenditures.isEmpty()) {
            aggregatedResponse.setName(expenditures.stream().findAny().get().getName());
            aggregatedResponse.setTotalAmount(expenditures.stream().findAny().get().getAmount());
            aggregatedResponse.setCreatedDate(expenditures.stream().findAny().get().getCreatedDate());
            aggregatedResponse.setOwner(users.stream().filter(usr -> usr.getName().equals(expenditures.stream().findAny().get().getUserName())).findAny().get().getName());
        }    
        splitDetails.stream().forEach(sd -> splitmapper(sd, aggregatedResponse, users));
        return new ResponseEntity<>(aggregatedResponse, HttpStatus.CREATED);
    }

    public ExpenditureAggregatedResponse splitmapper(SplitDetails splitDetails, ExpenditureAggregatedResponse aggregatedResponse, List<Users> users){
        Optional<Users> username = users.stream().filter(u -> u.getName().equals(splitDetails.getUserName())).findAny();
        ExpenditureAggregatedResponse.Split split = new Split();
        split.setUserName(username.get().getName());
        split.setAmountPaid(splitDetails.getAmountReceived());
        split.setAmountRemaining(calculateOwedAmount(splitDetails.getAmountReceived(),splitDetails.getAmountRemaining()));
        List<Split> splitList = new ArrayList<>();
        splitList.add(split);
        aggregatedResponse.setSplit(splitList);
        return aggregatedResponse;
    }
    
    public Long calculateOwedAmount(Long amountReceived, Long amountRemaining) {
        owedAmount = amountRemaining - amountReceived;
        return owedAmount;
    }

}
