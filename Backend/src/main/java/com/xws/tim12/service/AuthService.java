package com.xws.tim12.service;

import com.xws.tim12.dto.LoggedInUserDTO;
import com.xws.tim12.model.Authority;
import com.xws.tim12.security.auth.JwtAuthenticationRequest;

import java.util.Set;

public interface AuthService {

    Set<Authority> findById(Long id);
    Set<Authority> findByName(String name);
    LoggedInUserDTO login(JwtAuthenticationRequest jwtAuthenticationRequest);

}
