package com.xws.tim12.MessageService.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.xws.tim12.MessageService.dto.MessageDTO;
import com.xws.tim12.MessageService.model.Message;
import com.xws.tim12.MessageService.model.Receiver;
import com.xws.tim12.MessageService.model.Sender;
import com.xws.tim12.MessageService.service.MessageService;
import com.xws.tim12.MessageService.service.ReceiverService;
import com.xws.tim12.MessageService.service.SenderService;

@RestController
@RequestMapping(value = "/api/message")
@CrossOrigin(origins = { "http://localhost:4200" })
public class MessageController {
	
	@Autowired 
	private MessageService messageService;
	
	@Autowired 
	private SenderService senderService;
	
	@Autowired 
	private ReceiverService receiverService;
	
	
	@PostMapping(value = "/create")
    public ResponseEntity<MessageDTO> create(@RequestBody MessageDTO msgDTO) {
		MessageDTO createdMessage = messageService.createMessage(msgDTO);
        if (createdMessage == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<MessageDTO>(createdMessage, HttpStatus.CREATED);
    }
	
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable Long id) {
		Message message = messageService.findById(id);

        if (message == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }
	
	@PutMapping(value = "/edit/{id}")
	public ResponseEntity<MessageDTO> editMessage(@RequestBody MessageDTO messageDTO, @PathVariable("id") Long id) {
		Message message = messageService.findById(id);
		message.setSubject(messageDTO.getSubject());
		message.setContent(messageDTO.getContent());
		Message editedMessage = messageService.saveMessage(message);
		return new ResponseEntity<MessageDTO>(new MessageDTO(editedMessage), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Long> deleteMessage(@PathVariable("id") Long id) {
		Message message = messageService.findById(id);

        if (message == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        /*messageService.deleteMessage(id);
        
        return new ResponseEntity<Long>(id , HttpStatus.OK);*/
        return null;
    }
	
	
	@GetMapping(value = "/allSenderMessages/{id}")
	public ResponseEntity<Set<Message>> getAllSenderMessages(@PathVariable("id") Long id) {
		Set<Message> messages = senderService.getAllMessages(id);
		
		if (messages == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
		
		return new ResponseEntity<Set<Message>>(messages, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/allReceiverMessages/{id}")
	public ResponseEntity<Set<Message>> getAllReceiverMessages(@PathVariable("id") Long id) {
		Set<Message> messages = receiverService.getAllMessages(id);
		
		if (messages == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
		
		return new ResponseEntity<Set<Message>>(messages, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/send/from/{id1}/to/{id2}")
    public ResponseEntity<Message> sendMessage(@RequestBody MessageDTO msgDTO, 
    												@PathVariable("id1") Long id1, 
    												@PathVariable("id2") Long id2) {
		MessageDTO createdMessage = messageService.createMessage(msgDTO);
        if (createdMessage == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        Message msg = new Message(createdMessage);
        
        Sender sender =  senderService.findBySenderId(id1);
        if(sender == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        Receiver receiver = receiverService.findByReceiverId(id2);
        if(receiver == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        
        msg.setSender(sender);
        msg.setReceiver(receiver);
        
        /*sender.getMessages().add(msg);
        
        receiver.getMessages().add(msg);*/
        
        messageService.saveMessage(msg);
        /*senderService.saveSender(sender);
        receiverService.saveReceiver(receiver);*/
        
        return new ResponseEntity<Message>(msg, HttpStatus.CREATED);
    }
	
	@PostMapping(value = "/sendBack/from/{id2}/to/{id1}")
    public ResponseEntity<Message> sendMessageBack(@RequestBody MessageDTO msgDTO, 
    												@PathVariable("id1") Long id1, 
    												@PathVariable("id2") Long id2) {
		MessageDTO createdMessage = messageService.createMessage(msgDTO);
        if (createdMessage == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        Message msg = new Message(createdMessage);
        
        
        Receiver receiver = receiverService.findByReceiverId(id2);
        if(receiver == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        
        Sender sender =  senderService.findBySenderId(id1);
        if(sender == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        
        msg.setReceiverAsSender(receiver);
        msg.setSenderAsReceiver(sender);
        
        /*sender.getMessages().add(msg);
        
        receiver.getMessages().add(msg);*/
        
        messageService.saveMessage(msg);
        /*senderService.saveSender(sender);
        receiverService.saveReceiver(receiver);*/
        
        return new ResponseEntity<Message>(msg, HttpStatus.CREATED);
    }
	
}
