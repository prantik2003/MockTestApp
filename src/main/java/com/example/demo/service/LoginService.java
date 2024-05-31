package com.example.demo.service;

import com.example.demo.model.LoginRequest;
import com.example.demo.model.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


    public LoginResponse validateLogin(LoginRequest loginRequest) {
        if ( "password".equals(loginRequest.getPassword())) {
            return new LoginResponse(true, "Login successful");
        } else {
            return new LoginResponse(false, "Invalid username or password");
        }
    }
}

