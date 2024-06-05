package com.example.demo.service;

import com.example.demo.exception.InvalidInputException;
import com.example.demo.model.ForgotPasswordRequest;
import com.example.demo.model.User;
import com.example.demo.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean userExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public void updatePassword(ForgotPasswordRequest forgotPasswordRequest) throws InvalidInputException {
        if (!forgotPasswordRequest.newPassword().equals(forgotPasswordRequest.confirmPassword())) {
            throw new InvalidInputException("Passwords does not match");
        }
        User user = userRepository.findByUsername(forgotPasswordRequest.username()).orElseThrow(() ->
                new InvalidInputException("Invalid Username"));
        user.setPassword(forgotPasswordRequest.newPassword());
        userRepository.save(user);
    }
}

//        Optional<User> userOptional = userRepository.findByUsername(forgotPasswordRequest.username());
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            user.setPassword(forgotPasswordRequest.newPassword());
//            userRepository.save(user);
//            return true;
//        }
//        return false;
