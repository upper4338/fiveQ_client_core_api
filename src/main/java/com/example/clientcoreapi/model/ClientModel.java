package com.example.clientcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientModel {
    @NotNull
    private String clientId;

    private String name;
    private String surname;
    private String email;
}
