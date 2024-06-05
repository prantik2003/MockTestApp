package com.example.demo.model;

import org.springframework.web.bind.annotation.RequestParam;

public record ForgotPasswordRequest(String username,
                                     String newPassword,
                                     String confirmPassword) {
}
