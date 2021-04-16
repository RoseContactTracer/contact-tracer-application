package edu.rosehulman.covidtracer.repository;

import edu.rosehulman.covidtracer.model.PositiveCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.rosehulman.covidtracer.model.ContactTracer;

import java.util.List;

@Repository
public interface ContactTracerRepository extends JpaRepository<ContactTracer, Long> {

    List<PositiveCase> findCasesByTracer(ContactTracer tracer);
}
