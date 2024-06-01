package com.example.demo.service;

import com.example.demo.exception.InvalidInputException;
import com.example.demo.model.*;
import com.example.demo.userRepository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationService {
    ArrayList<RegistrationRequest> registrationRequestArrayList = new ArrayList<>();

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    void processRegistration(){
        System.out.println("Inside postconstruct");
//        RegistrationRequest registrationRequest = new RegistrationRequest(123,"Anirban","123",String.valueOf(1342342),23423);
//        RegistrationRequest registrationRequest2 = new RegistrationRequest(123,"Jishu","124","1342342",23423);
//        RegistrationRequest registrationRequest3 = new RegistrationRequest(123,"Polulami","125","1342342",23423);
//        //registrationRequestArrayList.addAll(List.of(registrationRequest,registrationRequest2,registrationRequest3));
//        registrationRequestArrayList.add(registrationRequest);
//        registrationRequestArrayList.add(registrationRequest2);
//        registrationRequestArrayList.add(registrationRequest3);

    }

    public User registration(RegistrationRequest registrationRequest) throws InvalidInputException, JsonProcessingException {
        registrationRequestArrayList.add(registrationRequest);
        ObjectMapper objectMapper= new ObjectMapper();
        User user= objectMapper.readValue(objectMapper.writeValueAsString(registrationRequest), User.class);
        return userRepository.save(user);
    }

    public LoginResponse validateLogin(LoginRequest loginRequest) {
        for (RegistrationRequest registrationRequest : registrationRequestArrayList) {
            if (registrationRequest.getUsername().equals(loginRequest.getUsername())
                    && registrationRequest.getPassword().equals(loginRequest.getPassword())) {
                return new LoginResponse(true, "Login successful");
            }
        }
        return new LoginResponse(false, "Invalid username or password");
    }

    public List<User> getRegisteredUsers() {
        return userRepository.findAll();
    }

    public RegistrationRequest getUserById(Double userId) {
        for (RegistrationRequest registrationRequest : registrationRequestArrayList) {
//            if (registrationRequest.getId()== userId) {
//                return registrationRequest;
//            }
        }
        return null;
    }

    public RegistrationRequest getUserByUserName(String username) {
        for (RegistrationRequest registrationRequest : registrationRequestArrayList) {
            if (registrationRequest.getUsername().equals(username)) {
                return registrationRequest;
            }
        }
        return null;
    }
}
