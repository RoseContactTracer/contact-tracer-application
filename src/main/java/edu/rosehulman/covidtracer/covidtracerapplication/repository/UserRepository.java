package edu.rosehulman.covidtracer.covidtracerapplication.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository<User, Integer> extends PagingAndSortingRepository<User, Integer> {

    /*Note: Method stubs left in for reference */

    public Iterable<User> findAll(Sort sort);

    public Page<User> findAll(Pageable pageable);

    public <S extends User> S save(S entity);

    public <S extends User> Iterable<S> saveAll(Iterable<S> entities);

    public Optional<User> findById(Integer id);

    public boolean existsById(Integer id);

    public Iterable<User> findAll();

    public Iterable<User> findAllById(Iterable<Integer> ids);

    public long count();

    public void deleteById(Integer id);

    public void delete(User entity);

    public void deleteAll(Iterable<? extends User> entities);

    public void deleteAll();
}
