package com.xws.tim12.MessageService.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.xws.tim12.MessageService.dto.ReceiverDTO;
import com.xws.tim12.MessageService.model.Message;
import com.xws.tim12.MessageService.model.Receiver;
import com.xws.tim12.MessageService.model.Sender;
import com.xws.tim12.MessageService.service.ReceiverService;

@RestController
@RequestMapping(value = "/api/receiver", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = { "http://localhost:4200" })
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
	
	
	@PostMapping(value = "/setReceiverAsSender/{id}")
    public ResponseEntity<Sender> setReceiverAsSender(@PathVariable("id") Long id) {
		Receiver receiver = receiverService.findById(id);

        if (receiver == null) {
        	System.out.println("Receiver je null;");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        Sender sender = receiverService.setReceiverAsSender(id);
        
        if(sender == null) {
        	System.out.println("Sender je null;");
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<Sender>(sender, HttpStatus.OK);
    }
	
}
