package com.example.demo.service;

import com.example.demo.model.LoginRequest;
import com.example.demo.model.LoginResponse;
import com.example.demo.model.RegistrationRequest;
import com.example.demo.model.RegistrationResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationService {
    ArrayList<RegistrationRequest> registrationRequestArrayList = new ArrayList<>();

    @PostConstruct
    void processRegistration(){
        System.out.println("Inside postconstruct");
        RegistrationRequest registrationRequest = new RegistrationRequest(123,"Anirban","123",1342342,23423);
        RegistrationRequest registrationRequest2 = new RegistrationRequest(123,"Jishu","124",1342342,23423);
        RegistrationRequest registrationRequest3 = new RegistrationRequest(123,"Polulami","125",1342342,23423);
        //registrationRequestArrayList.addAll(List.of(registrationRequest,registrationRequest2,registrationRequest3));
        registrationRequestArrayList.add(registrationRequest);
        registrationRequestArrayList.add(registrationRequest2);
        registrationRequestArrayList.add(registrationRequest3);

    }

    public RegistrationResponse registration(RegistrationRequest registrationRequest) {
        registrationRequest.setId((long) Math.floor(Math.random()*100));
        registrationRequestArrayList.add(registrationRequest);
        RegistrationResponse registrationResponse = new RegistrationResponse();
        registrationResponse.setUsername(registrationRequest.getUsername());
        registrationResponse.setContactNumber(registrationRequest.getContactNumber());
        registrationResponse.setPinCode(registrationRequest.getPinCode());
        registrationResponse.setId(registrationRequest.getId());
        return registrationResponse;
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

    public ArrayList<RegistrationRequest> getRegisteredUsers() {
        return registrationRequestArrayList;
    }

    public RegistrationRequest getUserById(Double userId) {
        for (RegistrationRequest registrationRequest : registrationRequestArrayList) {
            if (registrationRequest.getId()== userId) {
                return registrationRequest;
            }
        }
        return null;
    }
}
