package edu.rosehulman.covidtracer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.rosehulman.covidtracer.model.PossibleSymptom;

@Repository
public interface PossibleSymptomRepository extends JpaRepository<PossibleSymptom, Long>{

}
