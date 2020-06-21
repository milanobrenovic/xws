package com.xws.tim12.MessageService.service;

import java.util.List;
import java.util.Set;

import com.xws.tim12.MessageService.dto.SenderDTO;
import com.xws.tim12.MessageService.model.Message;
import com.xws.tim12.MessageService.model.Receiver;
import com.xws.tim12.MessageService.model.Sender;

public interface SenderService {
	
	Sender findById(Long id);
	
	Sender findBySenderId(Long id);
	
	SenderDTO createSender(SenderDTO sender);
	
	Set<Message> getAllMessages(Long id);
	
	Sender saveSender(Sender sender);
	
	List<Sender> getAllSenders();
	
	Set<Long> getAllReceiverIds(Long id);
	
	Set<Message> getAllReceiverMessages(Long id);
	
	Receiver setSenderAsReciever(Long id);
}
