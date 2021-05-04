package edu.rosehulman.covidtracer.controller;

import edu.rosehulman.covidtracer.auth.SecurityConfig;
import edu.rosehulman.covidtracer.auth.SecurityConstants;
import edu.rosehulman.covidtracer.model.Person;
import edu.rosehulman.covidtracer.model.PositiveCase;
import edu.rosehulman.covidtracer.repository.PersonRepository;
import edu.rosehulman.covidtracer.service.PersonService;
import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class PersonController {

    @Autowired
    PersonService service;
    
    @Autowired
    PersonRepository repository;

    @GetMapping(path = "/userlist")
    public ResponseEntity<List<Person>> getAllPersons(){
        List<Person> resultSet = service.getAllPersons();
        return new ResponseEntity<List<Person>>(resultSet, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/userlist/{id}")
	public ResponseEntity<List<Person>> retrievePositiveCase(@PathVariable Long id) throws NotFoundException {
    	List<Person> resultSet = new ArrayList<Person>();
		Optional<Person> person = repository.findById(id);
		
		if(!person.isPresent()) throw new NotFoundException("id-" + id);
		
		resultSet.add(person.get());
		
		return new ResponseEntity<List<Person>>(resultSet, new HttpHeaders(), HttpStatus.OK);
	}
    
    @GetMapping(path = "/userlist/email/{email}")
	public ResponseEntity<List<Person>> retrievePersonByEmail(@PathVariable String email) throws NotFoundException {
    	List<Person> resultSet = new ArrayList<Person>();
    	//get the right person
		Optional<Person> person = repository.findByEmail(email);
		
		if(!person.isPresent()) throw new NotFoundException("email-" + email);
		
		resultSet.add(person.get());

		return new ResponseEntity<List<Person>>(resultSet, new HttpHeaders(), HttpStatus.OK);
	}

}
