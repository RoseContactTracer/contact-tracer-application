package edu.rosehulman.covidtracer.repository;

import edu.rosehulman.covidtracer.model.PositiveCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.rosehulman.covidtracer.model.ContactTracer;

import java.util.List;

@Repository
public interface ContactTracerRepository extends JpaRepository<ContactTracer, Long> {

    @Query(value = "select * from positive_case where postive_case.contact_tracer_id = ?1", nativeQuery = true)
    List<PositiveCase> findCasesByTracer(Long id);
    
}
