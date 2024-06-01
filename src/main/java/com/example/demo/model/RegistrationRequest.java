package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class RegistrationRequest {

    private String username;

    private String password;

    private String contactNumber;

    private Integer pinCode;


}
