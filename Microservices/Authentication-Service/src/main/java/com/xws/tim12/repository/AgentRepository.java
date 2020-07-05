package com.xws.tim12.repository;

import com.xws.tim12.dto.AgentDTO;
import com.xws.tim12.dto.NormalUserDTO;
import com.xws.tim12.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgentRepository extends JpaRepository<Agent, Long> {

    Agent findByUsername(String username);

}
