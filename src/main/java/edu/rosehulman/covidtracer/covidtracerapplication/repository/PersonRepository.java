package edu.rosehulman.covidtracer.covidtracerapplication.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository<Person, Integer> extends PagingAndSortingRepository<Person, Integer> {

    /*Note: Method stubs left in for reference */

    public Iterable<Person> findAll(Sort sort);

    public Page<Person> findAll(Pageable pageable);

    public <S extends Person> S save(S entity);

    public <S extends Person> Iterable<S> saveAll(Iterable<S> entities);

    public Optional<Person> findById(Integer id);

    public boolean existsById(Integer id);

    public Iterable<Person> findAll();

    public Iterable<Person> findAllById(Iterable<Integer> ids);

    public long count();

    public void deleteById(Integer id);

    public void delete(Person entity);

    public void deleteAll(Iterable<? extends Person> entities);

    public void deleteAll();
}
