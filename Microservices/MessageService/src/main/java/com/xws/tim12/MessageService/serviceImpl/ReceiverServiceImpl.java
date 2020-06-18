package com.xws.tim12.MessageService.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.MessageService.dto.ReceiverDTO;
import com.xws.tim12.MessageService.model.Message;
import com.xws.tim12.MessageService.model.Receiver;
import com.xws.tim12.MessageService.model.Sender;
import com.xws.tim12.MessageService.repository.ReceiverRepository;
import com.xws.tim12.MessageService.service.ReceiverService;

@Service
public class ReceiverServiceImpl implements ReceiverService {
	
	@Autowired
	private ReceiverRepository receiverRepository;
	
	@Override
	public Receiver findById(Long id) {
		if(receiverRepository.findOneByUserId(id) == null){
			return null;
		}
		
		return receiverRepository.findOneByUserId(id);
	}

	@Override
	public ReceiverDTO createReceiver(ReceiverDTO receiver) {
		Receiver newReceiver = new Receiver(receiver);
		
		return new ReceiverDTO(receiverRepository.save(newReceiver));
	}
	
	
	public Set<Message> getAllMessages(Long id) {
		Receiver receiver = receiverRepository.findOneByUserId(id);
		if(receiver == null) {
			return null;
		}
		Set<Message> messages = receiver.getMessages();
		return messages;
	}

}
