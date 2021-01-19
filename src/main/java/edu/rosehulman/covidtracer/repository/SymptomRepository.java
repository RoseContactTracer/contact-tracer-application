package edu.rosehulman.covidtracer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.rosehulman.covidtracer.model.Symptom;

@Repository
public interface SymptomRepository extends JpaRepository<Symptom, Integer>{

}
