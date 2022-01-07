package com.example.bootcamp.bank.impl;

import com.example.bootcamp.bank.business.ClientService;
import com.example.bootcamp.bank.modelo.Client;
import com.example.bootcamp.bank.repository.ClientRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ClientImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    private static final Logger log = LoggerFactory.getLogger(ClientImpl.class);

    @Override
    public Mono<Client> create(Client client) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<Client> findById(String clientId) {

        return clientRepository.findById(clientId);
    }

    @Override
    public Flux<Client> findAll() {

        return clientRepository.findAll();
    }

    @Override
    public Mono<Client> update(Client client) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<Client> change(Client client) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<Client> remove(String clientId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<Client> findByName(String name) {

        return clientRepository.findByName(name);
    }

    @Override
    public Flux<Client> findByClient_Type(String client_type) {

        return clientRepository.findByClient_Type(client_type);
    }
    
}
