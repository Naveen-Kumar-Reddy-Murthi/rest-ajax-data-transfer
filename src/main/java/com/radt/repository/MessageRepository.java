package com.radt.repository;

import org.springframework.data.repository.CrudRepository;

import com.radt.model.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
