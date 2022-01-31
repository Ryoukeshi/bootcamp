package com.nttdata.bootcamp.bank.controller;

import com.nttdata.bootcamp.bank.business.ClientService;
import com.nttdata.bootcamp.bank.modelo.Client;

import com.nttdata.bootcamp.bank.modelo.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    //private static final Logger log = LoggerFactory.getLogger(ClientController.class);

    @GetMapping("/clients/{id}")
    public Mono<ClientDTO> byId(@PathVariable("id") String id) {
        return clientService.findById(id);
    };

    @GetMapping("/clients")
    public Flux<ClientDTO> findAll(){
        return clientService.findAll();
    }

    @GetMapping("/clients/findByType")
    public Flux<ClientDTO> findByType(
        @RequestParam("type") String type) {

            return clientService.findByClientType(type);
    }

    @GetMapping("/clients/findByName")
    public Mono<ResponseEntity<ClientDTO>> findByName(
        @RequestParam("name") String name) {

        return clientService.findByName(name)
                .flatMap(c -> Mono.just(ResponseEntity.ok(c)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PostMapping("/clients")
    public Mono<ClientDTO> create(@RequestBody ClientDTO clientDTO){

        log.info("----create----");
        
        return clientService.create(clientDTO);
    }

    @PutMapping("/clients/{id}")
    public Mono<ResponseEntity<ClientDTO>> update(@PathVariable String id,@RequestBody ClientDTO clientDTO){

        log.info("----update----");
        
        return clientService.update(clientDTO, id)
            .flatMap(clientUpdate -> Mono.just(ResponseEntity.ok(clientUpdate)))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/clients/{id}")
    public Mono<ResponseEntity<ClientDTO>> delete(@PathVariable ("id") String id){
        
        log.info("----delete----");

        return clientService.delete(id)
            .flatMap(clientDelete -> Mono.just(ResponseEntity.ok(clientDelete)))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
    
}
