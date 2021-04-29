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

    public List<Person> getAllPersons(){
        return repository.findAll();
    }

    public String getNameFromEmail(String email){
        List<Person> people = repository.findByEmail(email);
        System.out.println("We're doing this");
        if(people.size() > 1 || people.size() == 0){
            System.out.println("Couldnt find name in database");
            return "Undefined";
        }
        System.out.println(people.toString());
        return people.get(0).getFullName();
    }

}
