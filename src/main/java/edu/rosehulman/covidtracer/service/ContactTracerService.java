package edu.rosehulman.covidtracer.service;

import edu.rosehulman.covidtracer.model.ContactTracer;
import edu.rosehulman.covidtracer.model.PositiveCase;
import edu.rosehulman.covidtracer.repository.ContactTracerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactTracerService {

    @Autowired
    ContactTracerRepository contactTracers;

    public void assignContactTracer(PositiveCase covidCase){
        ContactTracer chosenTracer = chooseTracer(contactTracers.findAll());
        assignContactTracer(chosenTracer, covidCase);
    }

    private ContactTracer chooseTracer(List<ContactTracer> all) {
        double lowestCaseRatio = 1;
        ContactTracer mostLikelyTracer = all.get(0);
        for(ContactTracer tracer : all){
            if(findCaseRatio(tracer) < lowestCaseRatio){
                mostLikelyTracer = tracer;
                lowestCaseRatio = findCaseRatio(tracer);
            }
        }
        return mostLikelyTracer;
    }

    public void assignContactTracer(ContactTracer tracer, PositiveCase covidCase){
        tracer.assignCase(covidCase);
        covidCase.setContactTracer(tracer);
        contactTracers.save(tracer);
    }

    public double findCaseRatio(ContactTracer tracer){
        List<PositiveCase> cases = contactTracers.findCasesByTracer(tracer.getID());
        int currentCases = cases.size();
        return currentCases/tracer.getMaxCases();
    }

}
