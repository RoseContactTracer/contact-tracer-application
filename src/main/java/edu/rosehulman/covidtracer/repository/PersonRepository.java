package edu.rosehulman.covidtracer.repository;

import edu.rosehulman.covidtracer.model.Person;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	@Query("select * from person where person.email = ?1")
	public Optional<Person> findByEmail(String email);
	
}
