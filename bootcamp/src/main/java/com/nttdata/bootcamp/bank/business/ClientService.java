package com.nttdata.bootcamp.bank.business;

import com.nttdata.bootcamp.bank.modelo.Client;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {

    Mono<Client> create(Client client);

    Mono<Client> findById(String clientId);
    
    Flux<Client> findAll();

    Mono<Client> update(Client client);

    Mono<Client> delete(String clientId);

    Mono<Client> findClientsByName(String name);

    Flux<Client> findClientsByClient_Type(String client_type);
}
