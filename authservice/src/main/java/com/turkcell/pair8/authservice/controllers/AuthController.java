package com.turkcell.pair8.authservice.controllers;

import com.turkcell.pair8.authservice.services.abstracts.AuthService;
import com.turkcell.pair8.authservice.services.dtos.requests.LoginRequest;
import com.turkcell.pair8.authservice.services.dtos.requests.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody RegisterRequest request)
    {
        authService.register(request);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public void login(@RequestBody LoginRequest request)
    {
        authService.login(request);
    }
}