package com.xws.tim12.service;

import com.xws.tim12.model.Admin;

public interface AdminService {

    Admin findByUsername(String username);

    Admin getAdminLogin();

}
