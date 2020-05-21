package com.example.requestService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.requestService.model.NormalUser;

public interface NormalUserRepository extends JpaRepository<NormalUser, Long> {
	NormalUser findOneById(Long id);
    NormalUser findByUsername(String username);

}
