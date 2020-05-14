package com.xws.tim12.repository;

import com.xws.tim12.model.NormalUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<NormalUser, Long> {

    NormalUser findByUsername(String username);

}
