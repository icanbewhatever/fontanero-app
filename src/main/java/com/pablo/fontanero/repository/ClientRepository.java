package com.pablo.fontanero.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.pablo.fontanero.domain.Clients;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository  extends MongoRepository<Clients, String> {
}
