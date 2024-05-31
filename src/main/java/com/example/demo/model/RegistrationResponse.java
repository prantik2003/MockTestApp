package com.example.demo.model;

import lombok.Data;

@Data
public class RegistrationResponse {

    private long id;

    private String username;

    private Integer contactNumber;

    private Integer pinCode;

}
