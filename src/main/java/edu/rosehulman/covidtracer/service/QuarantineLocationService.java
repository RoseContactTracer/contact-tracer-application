package edu.rosehulman.covidtracer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.rosehulman.covidtracer.model.QuarantineLocation;
import edu.rosehulman.covidtracer.model.Student;
import edu.rosehulman.covidtracer.repository.QuarantineLocationRepository;
import edu.rosehulman.covidtracer.repository.StudentRepository;

@Service
public class QuarantineLocationService {
	
	@Autowired
    QuarantineLocationRepository repository;

    public List<QuarantineLocation> getAllStudents(){
        Pageable pageProperties = PageRequest.of(0, 10, Sort.by("id"));
        Page<QuarantineLocation> result = repository.findAll(pageProperties);
        if(result.hasContent()){
            return result.getContent();
        }
        return new ArrayList<QuarantineLocation>();
    }
	
}
