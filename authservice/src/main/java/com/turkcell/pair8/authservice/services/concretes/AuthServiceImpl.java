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
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;
    @Override
    public void register(RegisterRequest request) {
        userService.add(request);
    }

    @Override
    public String login(LoginRequest request) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        if(!authentication.isAuthenticated())
            throw new RuntimeException("E-posta veya şifre hatalı.");

        UserDetails user = userService.loadUserByUsername(request.getEmail());

        return jwtService.generateToken(user.getUsername(),
            user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());
    }
}