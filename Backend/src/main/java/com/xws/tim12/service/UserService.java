package com.xws.tim12.service;

import com.xws.tim12.model.NormalUser;

public interface UserService {

    NormalUser findByUsername(String username);

}
