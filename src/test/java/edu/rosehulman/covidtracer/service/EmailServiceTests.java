package edu.rosehulman.covidtracer.service;

import static org.easymock.EasyMock.*;

import edu.rosehulman.covidtracer.model.Person;
import edu.rosehulman.covidtracer.repository.PersonRepository;
import org.easymock.EasyMock;
import org.junit.*;

import java.util.ArrayList;

public class EmailServiceTests {

    @Test
    public void testTestEmail(){
        PersonRepository mockPersonRepo = EasyMock.mock(PersonRepository.class);
        Person mockPerson = EasyMock.mock(Person.class);
        ArrayList<Person> peopleList = new ArrayList<>();
        peopleList.add(mockPerson);
        EasyMock.expect(mockPersonRepo.findByEmail("maura.coriale@gmail.com")).andReturn(peopleList);
        EasyMock.expect(mockPerson.getFullName()).andReturn("Maura Coriale");
    }
}
