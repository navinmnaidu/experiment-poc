package com.experiment.poc.domain.repository;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
 
/**
 * @author vpurohi
 *
 */

@NoRepositoryBean
interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {
 
    void delete(T deleted);
 
    List<T> findAll();
     
    Optional<T> findOne(ID id);
 
    T save(T persisted);
}