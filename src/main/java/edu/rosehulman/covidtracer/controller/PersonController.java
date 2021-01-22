package edu.rosehulman.covidtracer.controller;

import edu.rosehulman.covidtracer.model.Person;
import edu.rosehulman.covidtracer.model.PositiveCase;
import edu.rosehulman.covidtracer.repository.PersonRepository;
import edu.rosehulman.covidtracer.service.PersonService;
import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    PersonService service;
    
    @Autowired
    PersonRepository repository;

    @GetMapping("/people")
    public ResponseEntity<List<Person>> getAllPersons(@RequestParam(defaultValue = "0") Integer pageNum,
                                                      @RequestParam(defaultValue = "10") Integer entriesPerPage,
                                                      @RequestParam(defaultValue = "ID") String sortBy){
        List<Person> resultSet = service.getAllPersons(pageNum, entriesPerPage, sortBy);
        return new ResponseEntity<List<Person>>(resultSet, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping("/people/{id}")
	public Person retrievePositiveCase(@PathVariable Long id) throws NotFoundException {
		Optional<Person> person = repository.findById(id);
		
		if(!person.isPresent()) throw new NotFoundException("id-" + id);
		
		return person.get();
	}

}
