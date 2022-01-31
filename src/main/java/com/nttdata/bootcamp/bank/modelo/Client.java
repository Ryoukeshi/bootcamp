package com.nttdata.bootcamp.bank.modelo;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "clients")
public class Client {

    @Field(name = "id")
    @Id
    private  String id;

    @Field(name = "name")
    private String name;

    @Field(name = "lastName")
    private String lastName;

    @Field(name = "documentType")
    private String documentType;

    @Field(name = "documentNumber")
    private String documentNumber;

    @Field(name = "clientType")
    private String clientType;

    @Field(name = "clientProfile")
    private String clientProfile;

    @Field(name = "debt")
    private boolean debt;

    @Field(name = "status")
    private String status;
}
