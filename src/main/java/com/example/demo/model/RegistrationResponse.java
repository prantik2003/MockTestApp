package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationResponse {

    private long id;

    private String username;

    private String contactNumber;

    private Integer pinCode;

}
