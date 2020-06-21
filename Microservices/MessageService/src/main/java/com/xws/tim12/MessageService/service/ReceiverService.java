package com.xws.tim12.MessageService.service;

import java.util.Set;

import com.xws.tim12.MessageService.dto.ReceiverDTO;
import com.xws.tim12.MessageService.model.Message;
import com.xws.tim12.MessageService.model.Receiver;
import com.xws.tim12.MessageService.model.Sender;

public interface ReceiverService {

	Receiver findById(Long id);
	
	Receiver findByReceiverId(Long id);
	
	ReceiverDTO createReceiver(ReceiverDTO receiver);
	
	Set<Message> getAllMessages(Long id);
	
	Receiver saveReceiver(Receiver receiver);
	
	Sender setReceiverAsSender(Long id);
}
