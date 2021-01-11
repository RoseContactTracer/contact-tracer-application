package edu.rosehulman.covidtracer.service;

import edu.rosehulman.covidtracer.model.SystemUser;
import edu.rosehulman.covidtracer.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SystemUserService {

    @Autowired
    SystemUserRepository repository;

    public List<SystemUser> getAllUsers(){
        Pageable pageProperties = PageRequest.of(0, 10, Sort.by("id"));
        Page<SystemUser> result = repository.findAll(pageProperties);
        if(result.hasContent()){
            return result.getContent();
        }
        return new ArrayList<SystemUser>();
    }

}
