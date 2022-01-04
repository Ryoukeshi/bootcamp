package com.example.bootcamp.bank.repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface Client {

    Mono<Client> findById(String pruebaId);

    Flux<Client> findAll();
    
}
