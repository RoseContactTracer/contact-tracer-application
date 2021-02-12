package edu.rosehulman.covidtracer.service;

import java.util.ArrayList;
import java.util.List;

import edu.rosehulman.covidtracer.model.Person;
import edu.rosehulman.covidtracer.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.rosehulman.covidtracer.model.Role;
import edu.rosehulman.covidtracer.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
    RoleRepository roleRepository;

	@Autowired
    PersonRepository personRepository;

    public List<Role> getAllRoles(){
        Pageable pageProperties = PageRequest.of(0, 10, Sort.by("id"));
        Page<Role> result = roleRepository.findAll(pageProperties);
        if(result.hasContent()){
            return result.getContent();
        }
        return new ArrayList<Role>();
    }

    public List<Person> getAllPeopleOfRole(Role role){
        Pageable pageProperties = PageRequest.of(0, 10, Sort.by("id"));
        Page<Person> result = personRepository.findByRole(role);
        if(result.hasContent()){
            return result.getContent();
        }
        return new ArrayList<Person>();
    }




	
}
