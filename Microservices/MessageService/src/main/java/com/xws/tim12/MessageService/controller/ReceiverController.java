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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xws.tim12.MessageService.dto.ReceiverDTO;
import com.xws.tim12.MessageService.model.Message;
import com.xws.tim12.MessageService.model.Receiver;
import com.xws.tim12.MessageService.model.Sender;
import com.xws.tim12.MessageService.service.ReceiverService;

@RestController
@RequestMapping(value = "/api/receiver", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReceiverController {
	
	@Autowired
	private ReceiverService receiverService;
	
	@PostMapping(value = "/create")
    public ResponseEntity<ReceiverDTO> create(@RequestBody ReceiverDTO receiverDTO) {
		ReceiverDTO createdReceiver = receiverService.createReceiver(receiverDTO);
        if (createdReceiver == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<ReceiverDTO>(createdReceiver, HttpStatus.CREATED);
    }
	
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<Receiver> getReceiver(@PathVariable Long id) {
		Receiver receiver = receiverService.findById(id);

        if (receiver == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Receiver>(receiver, HttpStatus.OK);
    }
	
	/*@DeleteMapping(value = "/{id}")
    public ResponseEntity<Receiver> deleteReceiver(@PathVariable Long id) {
		Receiver receiver = receiverService.findById(id);

        if (receiver == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Receiver>(receiver, HttpStatus.OK);
    }*/
	
	@GetMapping(value = "/allMessages/{id}")
    public ResponseEntity<Set<Message>> getAllMessages(@PathVariable("id") Long id) {
		Receiver receiver = receiverService.findById(id);

        if (receiver == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        Set<Message> messages = receiver.getMessages();
        
        return new ResponseEntity<Set<Message>>(messages, HttpStatus.OK);
    }
}
