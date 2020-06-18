package com.xws.tim12.MessageService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim12.MessageService.model.Sender;

public interface SenderRepository extends JpaRepository<Sender, Long>{
	
	Sender findOneById(Long id);
	
	Sender findOneByUserId(Long id);
	
}
