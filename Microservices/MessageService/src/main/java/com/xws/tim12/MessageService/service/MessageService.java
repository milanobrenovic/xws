package com.xws.tim12.MessageService.service;

import com.xws.tim12.MessageService.dto.MessageDTO;
import com.xws.tim12.MessageService.model.Message;

public interface MessageService {
	
	Message findById(Long id);
	
	MessageDTO createMessage(MessageDTO message);
	
	void deleteMessage(Long id);
	
	Message saveMessage(Message message);
}
