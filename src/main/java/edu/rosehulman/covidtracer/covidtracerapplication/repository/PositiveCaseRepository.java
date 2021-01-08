package edu.rosehulman.covidtracer.covidtracerapplication.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PositiveCaseRepository<PositiveCase, Integer> extends PagingAndSortingRepository<PositiveCase, Integer> {

    /* Note: Method stubs left in for reference */

    public Iterable<PositiveCase> findAll(Sort sort);

    public Page<PositiveCase> findAll(Pageable pageable);

    public <S extends PositiveCase> S save(S entity);

    public <S extends PositiveCase> Iterable<S> saveAll(Iterable<S> entities);

    public Optional<PositiveCase> findById(Integer id);

    public boolean existsById(Integer id);

    public Iterable<PositiveCase> findAll();

    public Iterable<PositiveCase> findAllById(Iterable<Integer> ids);

    public long count();

    public void deleteById(Integer id);

    public void delete(PositiveCase entity);

    public void deleteAll(Iterable<? extends PositiveCase> entities);

    public void deleteAll();
}
