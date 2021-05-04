package edu.rosehulman.covidtracer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Pool;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.rosehulman.covidtracer.model.Person;
import edu.rosehulman.covidtracer.model.PositiveCase;
import edu.rosehulman.covidtracer.model.PositivePool;
import edu.rosehulman.covidtracer.repository.ContactTracerRepository;
import edu.rosehulman.covidtracer.repository.PersonRepository;
import edu.rosehulman.covidtracer.repository.PositiveCaseRepository;
import edu.rosehulman.covidtracer.repository.PositivePoolRepository;
import edu.rosehulman.covidtracer.service.PositiveCaseService;
import edu.rosehulman.covidtracer.service.PositivePoolService;
import javassist.NotFoundException;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class PositivePoolController {

	@Autowired
	private PositivePoolService service;

	@Autowired
	private PositivePoolRepository poolRepo;
	
	@Autowired
	private PersonRepository personRepo;

	@GetMapping("/positive-pool")
	public ResponseEntity<List<PositivePool>> getAllPositivePools() {
		List<PositivePool> resultSet = service.getAllPools();
		return new ResponseEntity<List<PositivePool>>(resultSet, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/positive-pool")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<List<PositivePool>> createPositiveCaseOnPersonProfile(@RequestBody String[] emails) throws NotFoundException {
		Person person1, person2, person3, person4;
		PositivePool newPool = new PositivePool();
		newPool.setDate();
		poolRepo.save(newPool);
		
		if(emails[0] == null && emails[1] == null && emails[2] == null && emails[3] == null) {
			throw new NotFoundException("You must enter at least one person");
		}
		
		if(emails[0] != null) {
			person1 = personRepo.findByEmail(emails[0])
					.orElseThrow(() -> new NotFoundException("Person Email" + emails[0] + " not found"));
			newPool.addPerson(person1);
			person1.addPositivePools(newPool);
			personRepo.save(person1);
		}
		
		if(emails[1] != null) {
			person2 = personRepo.findByEmail(emails[1])
					.orElseThrow(() -> new NotFoundException("Person Email" + emails[0] + " not found"));
			newPool.addPerson(person2);
			person2.addPositivePools(newPool);
			personRepo.save(person2);
		}
		
		if(emails[2] != null) {
			person3 = personRepo.findByEmail(emails[2])
					.orElseThrow(() -> new NotFoundException("Person Email" + emails[0] + " not found"));
			newPool.addPerson(person3);
			person3.addPositivePools(newPool);
			personRepo.save(person3);
		}
		
		if(emails[3] != null) {
			person4 = personRepo.findByEmail(emails[3])
					.orElseThrow(() -> new NotFoundException("Person Email" + emails[0] + " not found"));
			newPool.addPerson(person4);
			person4.addPositivePools(newPool);
			personRepo.save(person4);
		}
		
		poolRepo.save(newPool);
		List<PositivePool> resultSet = new ArrayList<PositivePool>();
		resultSet.add(newPool);
		return new ResponseEntity<List<PositivePool>>(resultSet, new HttpHeaders(), HttpStatus.OK);

	}
	
}
