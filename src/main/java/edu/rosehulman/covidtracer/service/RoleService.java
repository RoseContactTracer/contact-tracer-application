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

import edu.rosehulman.covidtracer.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
    RoleRepository roleRepository;

	@Autowired
    PersonRepository personRepository;






	
}
