package com.radt.repository;

import org.springframework.data.repository.CrudRepository;

import com.radt.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
