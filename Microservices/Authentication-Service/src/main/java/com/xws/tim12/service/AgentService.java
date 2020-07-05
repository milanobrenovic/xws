package com.xws.tim12.service;

import com.xws.tim12.dto.AgentDTO;
import com.xws.tim12.model.Agent;

import java.util.List;

public interface AgentService {

    Agent findByUsername(String username);
    AgentDTO blockAgent(String username);
    AgentDTO unblockAgent(String username);

}
