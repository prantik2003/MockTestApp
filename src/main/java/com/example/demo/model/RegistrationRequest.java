package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class RegistrationRequest {
    private long id;

    private String username;

    private String password;

    private Integer contactNumber;

    private Integer pinCode;


}
