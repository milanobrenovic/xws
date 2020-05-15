package com.xws.tim12.service;

import com.xws.tim12.dto.NormalUserDTO;
import com.xws.tim12.model.NormalUser;

public interface NormalUserService {

    NormalUser findByUsername(String username);

    NormalUserDTO createNormalUser(NormalUserDTO normalUser);

}
