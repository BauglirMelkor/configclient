package com.config.client.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.config.client.persistence.entity.ConfigEntity;

public interface ConfigRepository extends MongoRepository<ConfigEntity, String>{

}
