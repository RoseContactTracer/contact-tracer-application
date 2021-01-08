package edu.rosehulman.covidtracer.covidtracerapplication.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository<Student, Integer> extends PagingAndSortingRepository<Student, Integer> {

    /* Note: Method stubs left in for reference */

    public Iterable<Student> findAll(Sort sort);

    public Page<Student> findAll(Pageable pageable);

    public <S extends Student> S save(S entity);

    public <S extends Student> Iterable<S> saveAll(Iterable<S> entities);

    public Optional<Student> findById(Integer id);

    public boolean existsById(Integer id);

    public Iterable<Student> findAll();

    public Iterable<Student> findAllById(Iterable<Integer> ids);

    public long count();

    public void deleteById(Integer id);

    public void delete(Student entity);

    public void deleteAll(Iterable<? extends Student> entities);

    public void deleteAll();
}
