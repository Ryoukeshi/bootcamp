package com.example.bootcamp.bank.modelo;
import java.util.UUID;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String client_type;
    private String status;
}
