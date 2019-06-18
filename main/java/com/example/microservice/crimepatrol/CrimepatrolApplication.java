package com.example.microservice.crimepatrol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.microservice.crimepatrol.repository.ExpendituresRepository;
import com.example.microservice.crimepatrol.repository.SplitDetailsRepository;
import com.example.microservice.crimepatrol.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses= {UserRepository.class,SplitDetailsRepository.class, ExpendituresRepository.class})
public class CrimepatrolApplication {
	
	private static final Logger log = LoggerFactory.getLogger(CrimepatrolApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CrimepatrolApplication.class, args);
	}

}