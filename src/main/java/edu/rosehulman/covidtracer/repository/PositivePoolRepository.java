package edu.rosehulman.covidtracer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.rosehulman.covidtracer.model.Person;
import edu.rosehulman.covidtracer.model.PositivePool;

@Repository
public interface PositivePoolRepository extends JpaRepository<PositivePool, Long> {

	@Query(value = "select * from positive_pool where positive_pool.date = CURRENT_DATE",
			nativeQuery = true)
	public List<PositivePool> findNew();
	
	@Query(value = "select * from positive_pool order by positive_pool.date DESC",
			nativeQuery = true)
	public List<PositivePool> findAllOrdered();
	
}
