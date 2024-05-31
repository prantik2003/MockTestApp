package com.example.demo.service;

import com.example.demo.model.LoginRequest;
import com.example.demo.model.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private static final String VALID_USERNAME = "user";
    private static final String VALID_PASSWORD = "password";

    public LoginResponse validateLogin(LoginRequest loginRequest) {
        if (VALID_USERNAME.equals(loginRequest.getUsername()) && VALID_PASSWORD.equals(loginRequest.getPassword())) {
            return new LoginResponse(true, "Login successful");
        } else {
            return new LoginResponse(false, "Invalid username or password");
        }
    }
}

