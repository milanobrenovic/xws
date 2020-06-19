package com.xws.tim12.MessageService.service;

import java.util.Set;

import com.xws.tim12.MessageService.dto.SenderDTO;
import com.xws.tim12.MessageService.model.Message;
import com.xws.tim12.MessageService.model.Sender;

public interface SenderService {
	
	Sender findById(Long id);
	
	Sender findBySenderId(Long id);
	
	SenderDTO createSender(SenderDTO sender);
	
	Set<Message> getAllMessages(Long id);
	
	Sender saveSender(Sender sender);
}
