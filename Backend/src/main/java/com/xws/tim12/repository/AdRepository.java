package com.xws.tim12.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim12.model.Ad;

public interface AdRepository extends JpaRepository<Ad, Long> {
	Optional<Ad> findById(Long id);
}
