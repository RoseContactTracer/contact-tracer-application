package edu.rosehulman.covidtracer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.rosehulman.covidtracer.model.CloseContact;

@Repository
public interface CloseContactRepository extends JpaRepository<CloseContact, Integer>{

}
