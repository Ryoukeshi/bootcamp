package com.example.bootcamp.bank.impl;

import com.example.bootcamp.bank.business.ClientService;
import com.example.bootcamp.bank.modelo.Client;
import com.example.bootcamp.bank.repository.ClientRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private WebClient webClient;

    private static final Logger log = LoggerFactory.getLogger(ClientImpl.class);

    @Override
    public Mono<Client> create(Client client) {
        /*
        if(!client.getName().isBlank()){

            return webClient.get()
            .uri(uriBuilder -> uriBuilder
                .queryParam("name", client.getName())
                .build())
                .retrieve()
                .bodyToFlux(Client.class)
                .next()
                .flatMap(
                    return clientRepository.save(client)
                );
          }*/
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
    public Mono<Client> delete(String clientId) {
        log.info("----remove----");

        return clientRepository
            .findById(clientId)
            .flatMap(p -> clientRepository.deleteById(p.getId()).thenReturn(p));
    }

    @Override
    public Mono<Client> findByName(String name) {

        return clientRepository.findClientsByName(name);
    }

    @Override
    public Flux<Client> findByClient_Type(String client_type) {

        return clientRepository.findClientsByClient_Type(client_type);
    }
    
}
