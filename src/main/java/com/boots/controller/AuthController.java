package com.boots.controller;

import com.boots.config.jwt.JwtProvider;

import com.boots.domain.User;

import com.boots.dto.AuthRequest;
import com.boots.dto.AuthResponse;
import com.boots.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    /**
     * The method that generates the JWT token
     * @param //request
     * @return AuthResponse(token) - JSON
     * @author dfcz652
     */
    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        User user = userService.PasswordEncryption(request.getUsername(), request.getPassword());
        String token = jwtProvider.generateToken(user.getUsername());
        System.out.println(new AuthResponse(token));
        return new AuthResponse(token);
    }

//    @PostMapping("/auth")
//    public AuthResponse auth(@RequestParam("username") String username, @RequestParam("password") String password) {
//        User user = userService.PasswordEncryption(request.getUsername(), request.getPassword());
//        String token = jwtProvider.generateToken(user.getUsername());
//        System.out.println(new AuthResponse(token));
//        return new AuthResponse(token);
//    }
}
