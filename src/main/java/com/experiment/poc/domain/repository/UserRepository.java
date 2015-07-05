package com.experiment.poc.domain.repository;

import com.experiment.poc.domain.User;

/**
 * @author Vikram Purohit
 *
 */
public interface UserRepository extends BaseRepository<User, Long> {

    User findById(Long id);
}
