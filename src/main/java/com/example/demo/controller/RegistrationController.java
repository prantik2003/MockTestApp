package com.example.demo.controller;


import com.example.demo.exception.InvalidInputException;
import com.example.demo.model.RegistrationRequest;
import com.example.demo.model.User;
import com.example.demo.service.RegistrationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping()
    public ResponseEntity<User> registration(@RequestBody RegistrationRequest registrationRequest){
        try {
            return new ResponseEntity<>(registrationService.registration(registrationRequest), HttpStatus.CREATED);
        }catch(InvalidInputException | JsonProcessingException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<List<User>> getRegisteredUsers() {
        return ResponseEntity.ok(registrationService.getRegisteredUsers());
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
