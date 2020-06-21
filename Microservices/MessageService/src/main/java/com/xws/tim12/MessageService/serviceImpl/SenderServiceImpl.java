package com.xws.tim12.MessageService.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
		List<Sender> senders = senderRepository.findAll();
		/*int counter = 0;
		for(Sender s : senders) {
			counter++;
		}

		Sender newSender = new Sender(sender);
		Long id = (long) ++counter;
		newSender.setId(id);*/
		
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

	@Override
	public Sender findBySenderId(Long id) {
		if(senderRepository.findOneById(id) == null) {
			return null;
		}
		
		return senderRepository.findOneById(id);
	}

	@Override
	public Sender saveSender(Sender sender) {
		return senderRepository.save(sender);
	}
	
	public List<Sender> getAllSenders() {
		List<Sender> senders = senderRepository.findAll();
		return senders;
	}
	
	public Set<Long> getAllReceiverIds(Long id) {
		Sender sender = senderRepository.findOneByUserId(id);
		if(sender == null) {
			return null;
		}
		Set<Message> messages = sender.getMessages();
		Set<Long> ids = new HashSet<>();
		for(Message m : messages) {
			ids.add(m.getReceiver().getUserId());
		}
		return ids;
	}
	
	
	public Set<Message> getAllReceiverMessages(Long id) {
		Sender sender = senderRepository.findOneByUserId(id);
		if(sender == null) {
			return null;
		}
		Set<Message> messages = sender.getMessages();
		Set<Message> receiverMessages = new HashSet<Message>();
		
		for(Message m : messages) {
			for(Message m2 : m.getReceiver().getMessages()) {
				if(m2.getSender().getId() == sender.getId()) {
					receiverMessages.add(m2);
				}
			}
		}
		return receiverMessages;
	}

}
