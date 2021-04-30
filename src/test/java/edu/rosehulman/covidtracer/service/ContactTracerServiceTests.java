package edu.rosehulman.covidtracer.service;

import edu.rosehulman.covidtracer.model.ContactTracer;
import edu.rosehulman.covidtracer.model.PositiveCase;
import edu.rosehulman.covidtracer.repository.ContactTracerRepository;
import org.easymock.EasyMock;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTracerServiceTests {

    @Test
    public void testGetContactTracerRatio(){
        ContactTracer tracer = EasyMock.mock(ContactTracer.class);
        ContactTracerRepository contactTracerRepository = EasyMock.mock(ContactTracerRepository.class);
        PositiveCase positiveCase = EasyMock.mock(PositiveCase.class);
        ArrayList<PositiveCase> casesAssignedAlready = EasyMock.mock(new ArrayList<PositiveCase>().getClass());
        EasyMock.expect(contactTracerRepository.findCasesByTracer(tracer)).andReturn(casesAssignedAlready);
        EasyMock.expect(casesAssignedAlready.size()).andReturn(9);
        EasyMock.expect(tracer.getMaxCases()).andReturn(10);
        ContactTracerService service = new ContactTracerService();
        double ratio = service.findCaseRatio(tracer);
        assertEquals(0.9, ratio);
    }

    @Test
    public void testAssignTracerToCase() {

    }

    @Test
    public void testAssignRandomTracerToCase(){}

    @Test
    public void testAssignNullTracerToCase(){}

}
