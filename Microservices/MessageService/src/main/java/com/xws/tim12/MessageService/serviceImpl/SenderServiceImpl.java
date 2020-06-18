package com.xws.tim12.MessageService.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.MessageService.dto.SenderDTO;
import com.xws.tim12.MessageService.model.Message;
import com.xws.tim12.MessageService.model.Sender;
import com.xws.tim12.MessageService.repository.SenderRepository;
import com.xws.tim12.MessageService.service.SenderService;

@Service
public class SenderServiceImpl implements SenderService {
	
	@Autowired
	private SenderRepository senderRepository;
	
	@Override
	public Sender findById(Long id) {
		if(senderRepository.findOneByUserId(id) == null) {
			return null;
		}
		
		return senderRepository.findOneByUserId(id);
	}

	@Override
	public SenderDTO createSender(SenderDTO sender) {
		Sender newSender = new Sender(sender);
		
		return new SenderDTO(senderRepository.save(newSender));
	}
	
	public Set<Message> getAllMessages(Long id) {
		Sender sender = senderRepository.findOneByUserId(id);
		if(sender == null) {
			return null;
		}
		Set<Message> messages = sender.getMessages();
		return messages;
	}

}
