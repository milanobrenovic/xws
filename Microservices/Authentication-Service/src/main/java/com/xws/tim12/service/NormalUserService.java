package com.xws.tim12.service;

import com.xws.tim12.dto.NormalUserDTO;
import com.xws.tim12.model.NormalUser;

import java.util.List;

public interface NormalUserService {

	NormalUser findById(Long id);
    NormalUser findOneByUsername(String username);
    NormalUser getUserLogin();
    NormalUserDTO createNormalUser(NormalUserDTO normalUser);
    NormalUserDTO blockNormalUser(String username);
    NormalUserDTO unblockNormalUser(String username);
    NormalUserDTO deleteNormalUser(String username);
    List<NormalUserDTO> findAllNormalUsers();

}
