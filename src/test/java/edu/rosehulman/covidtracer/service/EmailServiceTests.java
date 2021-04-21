/*package edu.rosehulman.covidtracer.service;

import com.sendgrid.Response;
import edu.rosehulman.covidtracer.model.Person;
import edu.rosehulman.covidtracer.repository.PersonRepository;
import org.easymock.EasyMock;

import java.io.IOException;
import java.util.ArrayList;

import org.easymock.EasyMock.*;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EmailServiceTests {

    @Test
    public void testSendEmailFromPerson(){
        PersonRepository mockPersonRepo;
        Person mockPerson = EasyMock.createMock(Person.class);
        expect(mockPerson.getFullName()).andReturn("Maura Coriale");
        expect(mockPerson.getEmail()).andReturn("maura.coriale@gmail.com");

        EasyMock.replay(mockPerson);
        EmailService emailService = new EmailService();
        try {
            Response r = emailService.sendEmail(mockPerson, "Basic Subject", emailService.getBasicTemplate());
            assertEquals(200, r.getStatusCode());
            EasyMock.verify(mockPerson);
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        assert(true);

    }

    @Test
    public void testSendTestEmail(){
        EmailService emailService = new EmailService();
        try {
            Response r = emailService.sendTestEmail();
            System.out.println(r);
            assertEquals(200, r);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/
