package com.xws.tim12.MessageService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim12.MessageService.model.Receiver;

public interface ReceiverRepository extends JpaRepository<Receiver, Long> {
	
	Receiver findOneById(Long id);
	
	Receiver findOneByUserId(Long id);
	
}
