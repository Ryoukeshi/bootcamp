package com.example.bootcamp.bank.repository;

import com.example.bootcamp.bank.modelo.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientRepository {

    Mono<Client> findById(String pruebaId);

    Flux<Client> findAll();
    
}
