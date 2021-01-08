package edu.rosehulman.covidtracer.covidtracerapplication.service;

import edu.rosehulman.covidtracer.covidtracerapplication.model.Person;
import edu.rosehulman.covidtracer.covidtracerapplication.model.Student;
import edu.rosehulman.covidtracer.covidtracerapplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public List<Student> getAllStudents(){
        Pageable pageProperties = PageRequest.of(0, 10, Sort.by("id"));
        Page<Student> result = repository.findAll(pageProperties);
        if(result.hasContent()){
            return result.getContent();
        }
        return new ArrayList<Student>();
    }

}
