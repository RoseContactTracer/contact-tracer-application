package edu.rosehulman.covidtracer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.rosehulman.covidtracer.model.PositivePool;

@Repository
public interface PositivePoolRepository extends JpaRepository<PositivePool, Long> {

}
