package com.xws.tim12.MessageService.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xws.tim12.MessageService.dto.MessageDTO;
import com.xws.tim12.MessageService.model.Message;
import com.xws.tim12.MessageService.service.MessageService;
import com.xws.tim12.MessageService.service.ReceiverService;
import com.xws.tim12.MessageService.service.SenderService;

@RestController
@RequestMapping(value = "/api/message", produces = MediaType.APPLICATION_JSON_VALUE)
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
	
	@PutMapping(value = "/edit")
	public ResponseEntity<MessageDTO> editMessage(@RequestBody MessageDTO messageDTO) {
		Message message = messageService.findById(messageDTO.getId());
		message.setSubject(messageDTO.getSubject());
		message.setContent(messageDTO.getContent());
		Message editedMessage = messageService.saveMessage(message);
		return new ResponseEntity<MessageDTO>(new MessageDTO(editedMessage), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
    public ResponseEntity<MessageDTO> deleteMessage(@PathVariable("id") Long id) {
		Message message = messageService.findById(id);

        if (message == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        /*MessageDTO deletedMessage = messageService.deleteMessage(id);
        
        return new ResponseEntity<MessageDTO>(deletedMessage, HttpStatus.OK);*/
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
	
	
}
