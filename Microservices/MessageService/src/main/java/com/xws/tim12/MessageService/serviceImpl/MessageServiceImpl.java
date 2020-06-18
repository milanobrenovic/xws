package com.xws.tim12.MessageService.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.MessageService.dto.MessageDTO;
import com.xws.tim12.MessageService.model.Message;
import com.xws.tim12.MessageService.repository.MessageRepository;
import com.xws.tim12.MessageService.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Override
	public Message findById(Long id) {
		if(messageRepository.findOneById(id) == null) {
			return null;
		}
		
		return messageRepository.findOneById(id);
	}

	@Override
	public MessageDTO createMessage(MessageDTO message) {
		Message newMessage = new Message(message);
		
		return new MessageDTO(messageRepository.save(newMessage));
	}
	
	public void deleteMessage(Long id) {
		if(messageRepository.findOneById(id) == null) {
			return;
		}
		
		messageRepository.deleteOneById(id);
		
	}
	
	public Message saveMessage(Message message) {
		return messageRepository.save(message);
	}


}
