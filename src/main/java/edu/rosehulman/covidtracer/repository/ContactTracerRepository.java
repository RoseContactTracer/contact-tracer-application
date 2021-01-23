package edu.rosehulman.covidtracer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.rosehulman.covidtracer.model.ContactTracer;

@Repository
public interface ContactTracerRepository extends JpaRepository<ContactTracer, Long> {

}
