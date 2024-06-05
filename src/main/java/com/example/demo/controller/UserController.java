package com.example.demo.controller;

import com.example.demo.exception.InvalidInputException;
import com.example.demo.model.ForgotPasswordRequest;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/forgot-password")
    public ResponseEntity<Void> forgotPassword(@RequestBody ForgotPasswordRequest forgotPasswordRequest) throws InvalidInputException {
        userService.updatePassword(forgotPasswordRequest);
        return ResponseEntity.ok().build();
    }
}

