package edu.rosehulman.covidtracer.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rosehulman.covidtracer.model.Person;
import edu.rosehulman.covidtracer.model.PositivePool;
import edu.rosehulman.covidtracer.repository.PersonRepository;
import edu.rosehulman.covidtracer.repository.PositivePoolRepository;
import javassist.NotFoundException;

@Service
public class PositivePoolService {

    @Autowired
    PositivePoolRepository repository;
	
	@Autowired
	private PersonRepository personRepo;

    @PostConstruct
    private void showRepositoryInfo() {
        System.out.println("************PersonRepository autowired************  \n ->" + repository.getClass().getCanonicalName());
    }
    
    public List<PositivePool> getAllPools(){
        List<PositivePool> result = repository.findAllOrdered();
        if(!result.isEmpty()){
            return result;
        }
        return new ArrayList<PositivePool>();
    }
    
    public List<PositivePool> getNewPools(){
        List<PositivePool> result = repository.findNew();
        if(!result.isEmpty()){
            return result;
        }
        return new ArrayList<PositivePool>();
    }
    
    public List<PositivePool> addPool(String[] emails) throws NotFoundException {
    	Person person1, person2, person3, person4;
		PositivePool newPool = new PositivePool();
		newPool.setDate();
		repository.save(newPool);
		
		if(emails[0] == null && emails[1] == null && emails[2] == null && emails[3] == null) {
			throw new NotFoundException("You must enter at least one person");
		}
		
		if(emails[0] != null) {
			person1 = personRepo.findByEmail(emails[0])
					.orElseThrow(() -> new NotFoundException("Person Email" + emails[0] + " not found"));
			newPool.addPerson(person1);
			person1.addPositivePools(newPool);
			personRepo.save(person1);
		}
		
		if(emails[1] != null) {
			person2 = personRepo.findByEmail(emails[1])
					.orElseThrow(() -> new NotFoundException("Person Email" + emails[0] + " not found"));
			newPool.addPerson(person2);
			person2.addPositivePools(newPool);
			personRepo.save(person2);
		}
		
		if(emails[2] != null) {
			person3 = personRepo.findByEmail(emails[2])
					.orElseThrow(() -> new NotFoundException("Person Email" + emails[0] + " not found"));
			newPool.addPerson(person3);
			person3.addPositivePools(newPool);
			personRepo.save(person3);
		}
		
		if(emails[3] != null) {
			person4 = personRepo.findByEmail(emails[3])
					.orElseThrow(() -> new NotFoundException("Person Email" + emails[0] + " not found"));
			newPool.addPerson(person4);
			person4.addPositivePools(newPool);
			personRepo.save(person4);
		}
		
		repository.save(newPool);
		List<PositivePool> resultSet = new ArrayList<PositivePool>();
		resultSet.add(newPool);
		return resultSet;
    }

}
