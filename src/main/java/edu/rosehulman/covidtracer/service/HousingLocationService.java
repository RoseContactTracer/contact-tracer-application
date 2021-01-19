package edu.rosehulman.covidtracer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.rosehulman.covidtracer.model.HousingLocation;
import edu.rosehulman.covidtracer.model.QuarantineLocation;
import edu.rosehulman.covidtracer.repository.HousingLocationRepository;
import edu.rosehulman.covidtracer.repository.QuarantineLocationRepository;

@Service
public class HousingLocationService {
	
	@Autowired
    HousingLocationRepository repository;

    public List<HousingLocation> getAllStudents(){
        Pageable pageProperties = PageRequest.of(0, 10, Sort.by("id"));
        Page<HousingLocation> result = repository.findAll(pageProperties);
        if(result.hasContent()){
            return result.getContent();
        }
        return new ArrayList<HousingLocation>();
    }
	
}
