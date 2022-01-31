package com.nttdata.bootcamp.bank.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NClient {

    @Field(name = "id")
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "lastName")
    private String lastName;

    @Field(name = "phoneNumber")
    private String phoneNumber;
}
