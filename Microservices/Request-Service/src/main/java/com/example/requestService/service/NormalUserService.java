package com.example.requestService.service;

import com.example.requestService.dto.NormalUserDTO;
import com.example.requestService.model.NormalUser;

public interface NormalUserService {
	NormalUser findById(Long id);
    NormalUser findByUsername(String username);
    NormalUser getUserLogin();

}
