package com.xws.tim12.MessageService.controller;

import com.xws.tim12.MessageService.dto.ChatDTO;
import com.xws.tim12.MessageService.dto.GreetingDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

@Controller
@CrossOrigin(origins = { "http://localhost:4200" })
public class ChatController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public GreetingDTO greeting(ChatDTO message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new GreetingDTO("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}
