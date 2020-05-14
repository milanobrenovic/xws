package com.xws.tim12.repository;

import com.xws.tim12.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {

    Agent findByUsername(String username);

}
