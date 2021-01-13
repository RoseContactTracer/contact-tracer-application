package edu.rosehulman.covidtracer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.rosehulman.covidtracer.model.PossibleSymptom;
import edu.rosehulman.covidtracer.model.QuarantineLocation;
import edu.rosehulman.covidtracer.repository.PossibleSymptomRepository;
import edu.rosehulman.covidtracer.repository.QuarantineLocationRepository;

@Service
public class PossibleSymptomService {
	
	@Autowired
    PossibleSymptomRepository repository;

    public List<PossibleSymptom> getAllStudents(){
        Pageable pageProperties = PageRequest.of(0, 10, Sort.by("id"));
        Page<PossibleSymptom> result = repository.findAll(pageProperties);
        if(result.hasContent()){
            return result.getContent();
        }
        return new ArrayList<PossibleSymptom>();
    }
    
}
