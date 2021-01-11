package edu.rosehulman.covidtracer.controller;

import edu.rosehulman.covidtracer.model.Person;
import edu.rosehulman.covidtracer.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService service;

    @GetMapping("/people")
    public ResponseEntity<List<Person>> getAllPersons(@RequestParam(defaultValue = "0") Integer pageNum,
                                                      @RequestParam(defaultValue = "10") Integer entriesPerPage,
                                                      @RequestParam(defaultValue = "id") String sortBy){
        List<Person> resultSet = service.getAllPersons(pageNum, entriesPerPage, sortBy);
        return new ResponseEntity<List<Person>>(resultSet, new HttpHeaders(), HttpStatus.OK);
    }

}
