package com.nttdata.bootcamp.bank.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NClientDTO {

    private String id;
    private String name;
    private String lastName;
    private String documentType;
    private String documentNumber;
    private String phoneNumber;
    private String email;
    private String status;
}
