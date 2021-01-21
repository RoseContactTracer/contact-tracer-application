package edu.rosehulman.covidtracer.service;

import edu.rosehulman.covidtracer.model.Person;
import edu.rosehulman.covidtracer.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    @PostConstruct
    private void showRepositoryInfo() {
        System.out.println("************PersonRepository autowired************  \n ->" + repository.getClass().getCanonicalName());
    }
    
    public List<Person> getAllPersons(Integer pageNum, Integer entriesPerPage, String sortBy){
        Pageable pageProperties = PageRequest.of(pageNum, entriesPerPage, Sort.by(sortBy));
        Page<Person> result = repository.findAll(pageProperties);
        if(result.hasContent()){
            return result.getContent();
        }
        return new ArrayList<Person>();
    }

}
