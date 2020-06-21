package com.xws.tim12.MessageService.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xws.tim12.MessageService.dto.SenderDTO;
import com.xws.tim12.MessageService.model.Message;
import com.xws.tim12.MessageService.model.Sender;
import com.xws.tim12.MessageService.service.SenderService;

@RestController
@RequestMapping(value = "/api/sender", produces = MediaType.APPLICATION_JSON_VALUE)
public class SenderController {
	
	@Autowired
	private SenderService senderService;
	
	@PostMapping(value = "/create")
    public ResponseEntity<SenderDTO> create(@RequestBody SenderDTO senderDTO) {
		SenderDTO createdSender = senderService.createSender(senderDTO);
        if (createdSender == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<SenderDTO>(createdSender, HttpStatus.CREATED);
    }
	
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<Sender> getSender(@PathVariable Long id) {
		Sender sender = senderService.findById(id);

        if (sender == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Sender>(sender, HttpStatus.OK);
    }
	
	/*@DeleteMapping(value = "/{id}")
    public ResponseEntity<Sender> deleteSender(@PathVariable Long id) {
		Sender sender = senderService.findById(id);

        if (sender == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Sender>(sender, HttpStatus.OK);
    }*/
	
	@GetMapping(value = "/allMessages/{id}")
    public ResponseEntity<Set<Message>> getAllMessages(@PathVariable("id") Long id) {
		Sender sender = senderService.findById(id);

        if (sender == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        Set<Message> messages = sender.getMessages();
        
        return new ResponseEntity<Set<Message>>(messages, HttpStatus.OK);
    }
	
	@GetMapping(value = "/allReceiverIds/{id}")
    public ResponseEntity<Set<Long>> getAllReceiverIds(@PathVariable("id") Long id) {
		Sender sender = senderService.findById(id);

        if (sender == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        Set<Long> ids = senderService.getAllReceiverIds(id);
        
        return new ResponseEntity<Set<Long>>(ids, HttpStatus.OK);
    }
	
	
	@GetMapping(value = "/allReceiverMessages/{id}")
    public ResponseEntity<Set<Message>> getAllReceiverMessages(@PathVariable("id") Long id) {
		Sender sender = senderService.findById(id);

        if (sender == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        Set<Message> messages = senderService.getAllReceiverMessages(id);
        
        return new ResponseEntity<Set<Message>>(messages, HttpStatus.OK);
    }
}
