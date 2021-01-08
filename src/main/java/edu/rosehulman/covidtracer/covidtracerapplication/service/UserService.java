package edu.rosehulman.covidtracer.covidtracerapplication.service;

import edu.rosehulman.covidtracer.covidtracerapplication.model.Person;
import edu.rosehulman.covidtracer.covidtracerapplication.model.User;
import edu.rosehulman.covidtracer.covidtracerapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> getAllUsers(){
        Pageable pageProperties = PageRequest.of(0, 10, Sort.by("id"));
        Page<User> result = repository.findAll(pageProperties);
        if(result.hasContent()){
            return result.getContent();
        }
        return new ArrayList<User>();
    }

}
