package org.airport.repository;

import org.airport.entity.AbstractEntity;

import java.util.List;
import java.util.Optional;

public interface MyRepository<E extends AbstractEntity> {

    void save(E entity);

    Optional<E> findById(Long id);

    List<E> findAll();

    void deleteById(Long id);
}