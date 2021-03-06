package com.xws.tim12.MessageService.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.MessageService.dto.ReceiverDTO;
import com.xws.tim12.MessageService.model.Message;
import com.xws.tim12.MessageService.model.Receiver;
import com.xws.tim12.MessageService.model.Sender;
import com.xws.tim12.MessageService.repository.ReceiverRepository;
import com.xws.tim12.MessageService.repository.SenderRepository;
import com.xws.tim12.MessageService.service.ReceiverService;

@Service
public class ReceiverServiceImpl implements ReceiverService {
	
	@Autowired
	private ReceiverRepository receiverRepository;
	
	@Autowired
	private SenderRepository senderRepository;
	
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

	@Override
	public Receiver findByReceiverId(Long id) {
		if(receiverRepository.findOneById(id) == null){
			return null;
		}
		
		return receiverRepository.findOneById(id);
	}

	@Override
	public Receiver saveReceiver(Receiver receiver) {
		return receiverRepository.save(receiver);
	}
	
	public Sender setReceiverAsSender(Long id) {
		Receiver receiver = receiverRepository.findOneByUserId(id);
		if(receiver == null) {
			System.out.println("Sender je null u Service.");
			return null;
		}
		
		Sender sender = new Sender();
		sender.setId(receiver.getId());
		sender.setUserId(receiver.getUserId());
		sender.setMessages(receiver.getMessages());
		
		return new Sender(senderRepository.save(sender));
	}

}
