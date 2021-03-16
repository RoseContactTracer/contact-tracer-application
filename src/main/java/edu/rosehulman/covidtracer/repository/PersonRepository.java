package edu.rosehulman.covidtracer.repository;

import edu.rosehulman.covidtracer.model.Person;

import edu.rosehulman.covidtracer.model.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByEmail(String email);

}
