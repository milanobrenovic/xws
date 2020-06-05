package com.xws.tim12.service;

import com.xws.tim12.dto.NormalUserDTO;
import com.xws.tim12.model.NormalUser;

public interface NormalUserService {
	NormalUser findById(Long id);
    NormalUser findByUsername(String username);
    NormalUser getUserLogin();
    NormalUserDTO createNormalUser(NormalUserDTO normalUser);

}