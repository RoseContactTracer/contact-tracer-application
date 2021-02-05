package edu.rosehulman.covidtracer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.rosehulman.covidtracer.model.QuarantineLocation;

@Repository
public interface QuarantineLocationRepository extends JpaRepository<QuarantineLocation, Long>{

}
