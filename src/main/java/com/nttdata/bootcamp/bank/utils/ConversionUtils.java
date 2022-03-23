package com.nttdata.bootcamp.bank.utils;

import com.nttdata.bootcamp.bank.modelo.Client;
import com.nttdata.bootcamp.bank.modelo.ClientDTO;
import com.nttdata.bootcamp.bank.modelo.NClient;
import com.nttdata.bootcamp.bank.modelo.NClientDTO;
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

    public static NClientDTO entityToNClientDTO(NClient nClient){
        NClientDTO nClientDTO = new NClientDTO();
        BeanUtils.copyProperties(nClient, nClientDTO);
        return nClientDTO;
    }

    public static NClient nClientDTOToEntity(NClientDTO nClientDTO){
        NClient nClient = new NClient();
        BeanUtils.copyProperties(nClientDTO, nClient);
        return nClient;
    }

    public static Mono<NClientDTO> createNClientEntity(NClientDTO nClientDTO){
        NClientDTO modifiedNClientDTO = new NClientDTO();
        BeanUtils.copyProperties(nClientDTO, modifiedNClientDTO);
        modifiedNClientDTO.setStatus(Constants.ACTIVE.name());
        return Mono.just(modifiedNClientDTO);
    }

    public static Mono<NClientDTO> updateNClientEntity(String id, NClientDTO nClientDTO){
        NClientDTO modifiedNClientDTO = new NClientDTO();
        BeanUtils.copyProperties(nClientDTO, modifiedNClientDTO);
        modifiedNClientDTO.setId(id);
        return Mono.just(modifiedNClientDTO);
    }
}
