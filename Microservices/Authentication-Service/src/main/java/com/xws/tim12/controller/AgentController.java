package com.xws.tim12.controller;

import com.xws.tim12.dto.AgentDTO;
import com.xws.tim12.dto.NormalUserDTO;
import com.xws.tim12.repository.AgentRepository;
import com.xws.tim12.repository.NormalUserRepository;
import com.xws.tim12.service.AgentService;
import com.xws.tim12.service.NormalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/agent")
@CrossOrigin(origins = { "http://localhost:4200" })
public class AgentController {

    @Autowired
    private AgentService agentService;

    @Autowired
    private AgentRepository agentRepository;

    @PutMapping(value = "/block/{username}")
    public ResponseEntity<AgentDTO> blockAgent(@PathVariable("username") String username) {
        try {
            AgentDTO agentDTO = agentService.blockAgent(username);
            if (agentDTO == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(agentDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/unblock/{username}")
    public ResponseEntity<AgentDTO> unblockAgent(@PathVariable("username") String username) {
        try {
            AgentDTO agentDTO = agentService.unblockAgent(username);
            if (agentDTO == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(agentDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
