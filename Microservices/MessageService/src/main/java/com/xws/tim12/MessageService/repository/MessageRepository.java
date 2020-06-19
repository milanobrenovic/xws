package com.xws.tim12.MessageService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim12.MessageService.model.Message;


public interface MessageRepository extends JpaRepository<Message, Long> {
	
	Message findOneById(Long id);
	
	Message deleteOneById(Long id);
}
