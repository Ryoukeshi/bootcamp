package com.nttdata.bootcamp.bank.controller;

import com.nttdata.bootcamp.bank.business.ClientService;
import com.nttdata.bootcamp.bank.modelo.Client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class ClientController {
    
    @Autowired
    private ClientService clientService;

    private static final Logger log = LoggerFactory.getLogger(ClientController.class);

    @GetMapping("/api/clients/specific")
    public Mono<Client> byId(@RequestParam("id") String id) {
        return clientService.findById(id);
    };

    @GetMapping("/api/clients/findByType")
    public Flux<Client> findByType(
        @RequestParam("type") String type) {

            if (type.isEmpty())
                return clientService.findAll();
            else
                return clientService.findByClient_Type(type);
    }

    @GetMapping("/api/clients/findByName")
    public Mono<Client> findByName(
        @RequestParam("name") String name) {

        return clientService.findByName(name);
    }

    @PostMapping("/api/clients")
    public Mono<Client> create(@RequestBody Client client){

        log.info("----create----");
        
        return clientService.create(client);
    }

    @PutMapping("/api/clients")
    public Mono<ResponseEntity<Client>> update(@RequestBody Client client){

        log.info("----update----");
        
        return clientService.update(client)
            .flatMap(clientUpdate -> Mono.just(ResponseEntity.ok(clientUpdate)))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    
}
