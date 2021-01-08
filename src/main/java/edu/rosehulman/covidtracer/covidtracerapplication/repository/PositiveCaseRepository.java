package edu.rosehulman.covidtracer.covidtracerapplication.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public class PositiveCaseRepository<PositiveCase, ID> implements PagingAndSortingRepository<PositiveCase, ID> {
    @Override
    public Iterable<PositiveCase> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<PositiveCase> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends PositiveCase> S save(S entity) {
        return null;
    }

    @Override
    public <S extends PositiveCase> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<PositiveCase> findById(ID id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(ID id) {
        return false;
    }

    @Override
    public Iterable<PositiveCase> findAll() {
        return null;
    }

    @Override
    public Iterable<PositiveCase> findAllById(Iterable<ID> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(ID id) {

    }

    @Override
    public void delete(PositiveCase entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends PositiveCase> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
