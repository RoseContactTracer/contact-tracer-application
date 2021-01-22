package edu.rosehulman.covidtracer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.rosehulman.covidtracer.model.Person;
import edu.rosehulman.covidtracer.model.PositiveCase;
import edu.rosehulman.covidtracer.repository.PersonRepository;
import edu.rosehulman.covidtracer.repository.PositiveCaseRepository;
import edu.rosehulman.covidtracer.service.PositiveCaseService;
import javassist.NotFoundException;

@RestController
public class PositiveCaseController {
	
	@Autowired
	private PositiveCaseService service;
	
	@Autowired
	private PositiveCaseRepository repository;
	
	@GetMapping("/positive-case")
    public ResponseEntity<List<PositiveCase>> getAllPositiveCases(@RequestParam(defaultValue = "0") Integer pageNum,
                                                      @RequestParam(defaultValue = "10") Integer entriesPerPage,
                                                      @RequestParam(defaultValue = "ID") String sortBy){
        List<PositiveCase> resultSet = service.getAllPositiveCases(pageNum, entriesPerPage, sortBy);
        return new ResponseEntity<List<PositiveCase>>(resultSet, new HttpHeaders(), HttpStatus.OK);
    }
	
	@GetMapping("/positive-case/{id}")
	public PositiveCase retrievePositiveCase(@PathVariable Long id) throws NotFoundException {
		Optional<PositiveCase> positiveCase = repository.findById(id);
		
		if(!positiveCase.isPresent()) throw new NotFoundException("id-" + id);
		
		return positiveCase.get();
	}
	
	@PostMapping("/positive-case")
	@ResponseStatus(HttpStatus.CREATED)
	public PositiveCase createPositiveCase(@RequestBody PositiveCase positiveCase) {
		return repository.save(positiveCase);
	}
	
}
