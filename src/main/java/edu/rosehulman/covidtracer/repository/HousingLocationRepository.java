package edu.rosehulman.covidtracer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.rosehulman.covidtracer.model.HousingLocation;

@Repository
public interface HousingLocationRepository extends JpaRepository<HousingLocation, Integer>{

}
