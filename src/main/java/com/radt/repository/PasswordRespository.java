package com.radt.repository;

import org.springframework.data.repository.CrudRepository;

import com.radt.model.Password;

public interface PasswordRespository  extends CrudRepository<Password, Long>{

}
