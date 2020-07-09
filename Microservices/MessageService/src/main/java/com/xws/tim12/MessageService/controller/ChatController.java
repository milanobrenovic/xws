package com.xws.tim12.MessageService.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@CrossOrigin(origins = { "http://localhost:4200" })
public class ChatController {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
/*    @MessageMapping("/send/message")
    @SendTo("/topic/greetings")
    public GreetingDTO greeting(ChatDTO message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new GreetingDTO("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
*/
	
	@MessageMapping("/send/message")
	public Map<String, String> broadcastNotification(String message) {
		Map<String, String> messageConverted = parseMessage(message);
		
		if(messageConverted != null) {
			if (messageConverted.containsKey("toId") && messageConverted.get("toId") != null && !messageConverted.get("toId").equals("")) {
				this.simpMessagingTemplate.convertAndSend("/socket-publisher/" + messageConverted.get("toId"), messageConverted);
				this.simpMessagingTemplate.convertAndSend("/socket-publisher/" + messageConverted.get("fromId"), messageConverted);
			} else {
				this.simpMessagingTemplate.convertAndSend("/socket-publisher", messageConverted);
			}
		}
		return messageConverted;
	}
	
	@SuppressWarnings("unchecked")
	private Map<String, String> parseMessage(String message) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> retVal;
		
		try {
			retVal = mapper.readValue(message, Map.class);
		} catch (IOException e) {
			retVal = null;
		}
		
		return retVal;
	}
	

}
