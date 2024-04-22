package com.turkcell.pair8.authservice.services.concretes;

import com.pair4.jwt.JwtService;
import com.turkcell.pair8.authservice.services.abstracts.AuthService;
import com.turkcell.pair8.authservice.services.abstracts.UserService;
import com.turkcell.pair8.authservice.services.dtos.requests.LoginRequest;
import com.turkcell.pair8.authservice.services.dtos.requests.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;
    @Override
    public void register(RegisterRequest request) {
        // 9:15
        // TODO: Mapstruct
        userService.add(request);
    }

    @Override
    public String login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        if(!authentication.isAuthenticated())
            throw new RuntimeException("Username or password is incorrect.");

        UserDetails user = userService.loadUserByUsername(request.getEmail());
        return jwtService.generateToken(user.getUsername());
    }
}