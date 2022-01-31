package com.nttdata.bootcamp.bank.business;

import com.nttdata.bootcamp.bank.modelo.Client;

import com.nttdata.bootcamp.bank.modelo.ClientDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {

    Mono<ClientDTO> create(ClientDTO client);

    Mono<ClientDTO> findById(String clientId);
    
    Flux<ClientDTO> findAll();

    Mono<ClientDTO> update(ClientDTO clientDTO, String id);

    Mono<ClientDTO> delete(String clientId);

    Mono<ClientDTO> findByName(String name);

    Flux<ClientDTO> findByClientType(String client_type);
}
