package edu.rosehulman.covidtracer.controller;

import edu.rosehulman.covidtracer.model.Person;
import edu.rosehulman.covidtracer.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import java.io.IOException;
=======
>>>>>>> 8ae756727254fb26a97e07c44b9d0d09da4da11c
import java.util.List;

@RestController
public class EmailController {

    @Autowired
    EmailService service;

    @GetMapping("/email")
    public ResponseEntity sendEmail() throws IOException {

        service.sendTestEmail();
        return new ResponseEntity(new HttpHeaders(), HttpStatus.OK);
    }

}
