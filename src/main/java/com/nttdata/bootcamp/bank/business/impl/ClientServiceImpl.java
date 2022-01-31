package com.nttdata.bootcamp.bank.business.impl;

import com.nttdata.bootcamp.bank.business.ClientService;
import com.nttdata.bootcamp.bank.modelo.Client;
import com.nttdata.bootcamp.bank.modelo.ClientDTO;
import com.nttdata.bootcamp.bank.repository.ClientRepository;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import com.nttdata.bootcamp.bank.utils.Constants;
import com.nttdata.bootcamp.bank.utils.ConversionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Mono<ClientDTO> create(ClientDTO clientDTO) {

          return clientRepository.findById(clientDTO.getId())
                  .switchIfEmpty(Mono.just(new Client()))
                  .flatMap(client1 -> ConversionUtils.createClientEntity(clientDTO))
                  .map(ConversionUtils::clientDtoToEntity)
                  .flatMap(clientRepository::save)
                  .map(ConversionUtils::entityToClientDTO);
    }

    @Override
    public Mono<ClientDTO> findById(String clientId) {

        log.info("Finding Client by Id...");

        return clientRepository.findById(clientId)
                .switchIfEmpty(Mono.empty())
                .filter(client -> client.getStatus().equalsIgnoreCase(Constants.ACTIVE.name()))
                .map(ConversionUtils::entityToClientDTO);
    }

    @Override
    public Flux<ClientDTO> findAll() {

        log.info("Finding All Clients...");

        return clientRepository.findAll()
                .filter(client -> client.getStatus().equalsIgnoreCase(Constants.ACTIVE.name()))
                .map(ConversionUtils::entityToClientDTO);
    }

    @Override
    public Mono<ClientDTO> update(ClientDTO clientDTO, String id) {
        
        return clientRepository.findById(clientDTO.getId())
                .switchIfEmpty(Mono.empty())
                .flatMap(cl -> ConversionUtils.updateClientEntity(clientDTO, id))
                .map(ConversionUtils::clientDtoToEntity)
                .flatMap(clientRepository::save)
                .map(ConversionUtils::entityToClientDTO);
    }


    @Override
    public Mono<ClientDTO> delete(String clientId) {
        log.info("----remove----");

        return clientRepository.findById(clientId)
                .switchIfEmpty(Mono.empty())
                .doOnNext(c -> c.setStatus(Constants.INACTIVE.name()))
                .flatMap(clientRepository::save)
                .map(ConversionUtils::entityToClientDTO);
    }

    @Override
    public Mono<ClientDTO> findByName(String name) {

        return clientRepository.findByName(name)
                .switchIfEmpty(Mono.empty())
                .filter(client -> client.getStatus().equalsIgnoreCase(Constants.ACTIVE.name()))
                .map(ConversionUtils::entityToClientDTO);
    }

    @Override
    public Flux<ClientDTO> findByClientType(String clientType) {

        return clientRepository.findByClientType(clientType)
                .switchIfEmpty(Mono.empty())
                .filter(client -> client.getStatus().equalsIgnoreCase(Constants.ACTIVE.name()))
                .map(ConversionUtils::entityToClientDTO);
    }
    
}
