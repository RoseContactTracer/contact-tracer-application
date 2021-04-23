package edu.rosehulman.covidtracer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.rosehulman.covidtracer.model.PositiveCase;
import edu.rosehulman.covidtracer.model.PositivePool;
import edu.rosehulman.covidtracer.repository.ContactTracerRepository;
import edu.rosehulman.covidtracer.repository.PersonRepository;
import edu.rosehulman.covidtracer.repository.PositiveCaseRepository;
import edu.rosehulman.covidtracer.repository.PositivePoolRepository;
import edu.rosehulman.covidtracer.service.PositiveCaseService;
import edu.rosehulman.covidtracer.service.PositivePoolService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class PositivePoolController {

	@Autowired
	private PositivePoolService service;

	@Autowired
	private PositivePoolRepository poolRepo;

	@GetMapping("/positive-pool")
	public ResponseEntity<List<PositivePool>> getAllPositivePools() {
		List<PositivePool> resultSet = service.getAllPools();
		return new ResponseEntity<List<PositivePool>>(resultSet, new HttpHeaders(), HttpStatus.OK);
	}
	
}
