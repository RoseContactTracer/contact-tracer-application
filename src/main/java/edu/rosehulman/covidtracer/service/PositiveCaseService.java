package edu.rosehulman.covidtracer.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.rosehulman.covidtracer.model.Person;
import edu.rosehulman.covidtracer.model.PositiveCase;
import edu.rosehulman.covidtracer.model.QuarantineLocation;
import edu.rosehulman.covidtracer.repository.PositiveCaseRepository;
import edu.rosehulman.covidtracer.repository.QuarantineLocationRepository;

@Service
public class PositiveCaseService {

	@Autowired
    PositiveCaseRepository repository;

    public List<PositiveCase> getAllPositiveCases(){
        List<PositiveCase> result = repository.findAll();
        if(!result.isEmpty()){
            return result;
        }
        return new ArrayList<PositiveCase>();
    }
    
    public Long createPositiveCase(Person person, Date testDate, Date symptomaticStartDate, Date quarantineEndDate, boolean needsTransportation) {
    	PositiveCase newCase = new PositiveCase(new Random().nextLong(), person, testDate, symptomaticStartDate, quarantineEndDate, needsTransportation);
    	return repository.save(newCase).getID();
    }
	
}
