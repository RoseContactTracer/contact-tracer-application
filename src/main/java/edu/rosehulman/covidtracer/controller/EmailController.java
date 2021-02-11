package edu.rosehulman.covidtracer.controller;

import edu.rosehulman.covidtracer.model.Person;
import edu.rosehulman.covidtracer.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import java.util.List;

@RestController
public class EmailController {

    @Autowired
    EmailService service;



    @GetMapping("/email/test")
    public ResponseEntity<String> sendEmail() throws IOException {

        service.sendTestEmail();
        return new ResponseEntity("Email has been sent", new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/email/new-case/")
    public ResponseEntity<String> alertNewCase(@RequestParam String caseId) throws IOException {
        //need to send emails to everyone who needs to know there is a new case
        service.alertAllOfNewCase(caseId);
        return new ResponseEntity(new HttpHeaders(), HttpStatus.ACCEPTED);
    }

    @GetMapping("email/new-assignment/")
    public ResponseEntity<String> alertNewAssignment(@RequestParam String tracerId, @RequestParam String caseId) {
        //need to send emails to the Contact Tracer who is assigned to a case
        service.alertTracerOfNewCase(caseId);
        return new ResponseEntity(new HttpHeaders(), HttpStatus.ACCEPTED);
    }

    @GetMapping("email/positive-pool/")
    public ResponseEntity<String> alertPositivePool(@RequestParam String poolId){
        //alerts the students in the positive pool as well as everyone else
        //who needs to know that there is a positive pool
        service.alertPositivePoolMembers(poolId);
        service.alertAllOfNewPositivePool(poolId);
        return new ResponseEntity(new HttpHeaders(), HttpStatus.ACCEPTED);
    }

}
