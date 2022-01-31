package com.nttdata.bootcamp.bank.utils;

import com.nttdata.bootcamp.bank.modelo.Client;
import com.nttdata.bootcamp.bank.modelo.ClientDTO;
import org.springframework.beans.BeanUtils;
import reactor.core.publisher.Mono;

public class ConversionUtils {

    public static ClientDTO entityToClientDTO(Client client){
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        return clientDTO;
    }

    public static Client clientDtoToEntity(ClientDTO clientDTO){
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        return client;
    }

    public static Mono<ClientDTO> createClientEntity(ClientDTO clientDTO){
        ClientDTO modifiedClientDTO = new ClientDTO();
        BeanUtils.copyProperties(clientDTO, modifiedClientDTO);
        modifiedClientDTO.setStatus(Constants.ACTIVE.name());
        return Mono.just(modifiedClientDTO);
    }

    public static Mono<ClientDTO> updateClientEntity(ClientDTO clientDTO, String id){
        ClientDTO modifiedClientDTO = new ClientDTO();
        BeanUtils.copyProperties(clientDTO, modifiedClientDTO);
        modifiedClientDTO.setId(id);
        return Mono.just(modifiedClientDTO);
    }
}
