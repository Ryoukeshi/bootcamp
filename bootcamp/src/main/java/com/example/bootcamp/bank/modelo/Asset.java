package com.example.bootcamp.bank.modelo;

import lombok.Getter;
import lombok.AllArgsConstructor;

import java.util.UUID;

import org.springframework.data.annotation.Id;

@Getter
@AllArgsConstructor
public class Asset {

    @Id
    private String id=UUID.randomUUID().toString();

    private String owner;
    private String asset_type;
    private String amount;
}
