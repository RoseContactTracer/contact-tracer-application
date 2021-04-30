package edu.rosehulman.covidtracer.repository;

import edu.rosehulman.covidtracer.model.PositiveCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PositiveCaseRepository extends JpaRepository<PositiveCase, Long> {

    @Query(value = "select * from positive_case where positive_case.contact_tracer_id IS not NULL", nativeQuery = true)
    public List<PositiveCase> findAllAssignedCases();
}
