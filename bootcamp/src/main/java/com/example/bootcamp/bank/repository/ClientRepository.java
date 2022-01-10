package com.example.bootcamp.bank.repository;

import com.example.bootcamp.bank.modelo.*;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

//import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ClientRepository extends ReactiveMongoRepository<Client, String>{
   
    Mono<Client> findClientsByName(String name);

    Flux<Client> findClientsByClient_Type(String client_type);
}
