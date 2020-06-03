package com.xws.tim12.repository;

import com.xws.tim12.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Authority, Long> {

    Authority findByName(String name);

}
