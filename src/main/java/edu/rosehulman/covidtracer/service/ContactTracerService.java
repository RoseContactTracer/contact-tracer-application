package edu.rosehulman.covidtracer.service;

import edu.rosehulman.covidtracer.model.ContactTracer;
import edu.rosehulman.covidtracer.model.PositiveCase;
import edu.rosehulman.covidtracer.repository.ContactTracerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public class ContactTracerService {

    @Autowired
    ContactTracerRepository contactTracers;

    public void assignContactTracer(PositiveCase covidCase){
        ContactTracer chosenTracer = chooseTracer(contactTracers.findAll());
    }

    private ContactTracer chooseTracer(List<ContactTracer> all) {
        double lowestCaseRatio = 1;
        ContactTracer mostLikelyTracer;
        for(ContactTracer tracer : all){
            if(tracer.findCaseRatio() < lowestCaseRatio){
                mostLikelyTracer = tracer;
                lowestCaseRatio = tracer.findCaseRatio();
            }
        }
    }

    public void assignContactTracer(ContactTracer tracer, PositiveCase covidCase){}



}
