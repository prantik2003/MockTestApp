package com.example.demo.controller;

import com.example.demo.model.LoginRequest;
import com.example.demo.model.LoginResponse;
import com.example.demo.model.RegistrationRequest;
import com.example.demo.model.RegistrationResponse;
import com.example.demo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping()
    public ResponseEntity<RegistrationResponse> registration(@RequestBody RegistrationRequest registrationRequest) {
        return new ResponseEntity<>(registrationService.registration(registrationRequest), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<ArrayList> getRegisteredUsers() {
        return new ResponseEntity<ArrayList>(registrationService.getRegisteredUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<RegistrationRequest> getUserById(@PathVariable Double userId ) {
        RegistrationRequest registrationRequest = registrationService.getUserById(userId);
        if(Objects.isNull(registrationRequest)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(registrationRequest,HttpStatus.OK);
    }

}
