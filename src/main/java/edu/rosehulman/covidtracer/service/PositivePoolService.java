package edu.rosehulman.covidtracer.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rosehulman.covidtracer.model.Person;
import edu.rosehulman.covidtracer.model.PositivePool;
import edu.rosehulman.covidtracer.repository.PositivePoolRepository;

@Service
public class PositivePoolService {

    @Autowired
    PositivePoolRepository repository;

    @PostConstruct
    private void showRepositoryInfo() {
        System.out.println("************PersonRepository autowired************  \n ->" + repository.getClass().getCanonicalName());
    }
    
    public List<PositivePool> getAllPools(){
        List<PositivePool> result = repository.findAll();
        if(!result.isEmpty()){
            return result;
        }
        return new ArrayList<PositivePool>();
    }

}
