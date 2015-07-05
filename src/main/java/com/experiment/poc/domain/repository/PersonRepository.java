package com.experiment.poc.domain.repository;

import com.experiment.poc.domain.entity.PersonEntity;

/**
 * @author Vikram Purohit
 *
 */
public interface PersonRepository extends BaseRepository<PersonEntity, Long> {

    PersonEntity findById(Long id);
}
