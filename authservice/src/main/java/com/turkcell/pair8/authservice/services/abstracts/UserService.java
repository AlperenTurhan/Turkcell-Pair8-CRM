package com.turkcell.pair8.authservice.services.abstracts;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void register();
}
