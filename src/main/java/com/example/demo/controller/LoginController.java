package com.example.demo.controller;

import com.example.demo.model.LoginRequest;
import com.example.demo.model.LoginResponse;
import com.example.demo.model.RegistrationRequest;
import com.example.demo.model.UserDetails;
import com.example.demo.service.JWTService;
import com.example.demo.service.LoginService;
import com.example.demo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private JWTService jwtService;

    @PostMapping()
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        if(registrationService.validateLogin(loginRequest).isSuccess()){
            RegistrationRequest registrationRequest = registrationService.getUserByUserName(loginRequest.getUsername());
            UserDetails userDetails= new UserDetails(registrationRequest.getUsername(), null,registrationRequest.getContactNumber());
            String token = jwtService.generateToken(userDetails);
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

}
