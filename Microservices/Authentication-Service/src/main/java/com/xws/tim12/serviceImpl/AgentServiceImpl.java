package com.xws.tim12.serviceImpl;

import com.xws.tim12.model.Agent;
import com.xws.tim12.repository.AgentRepository;
import com.xws.tim12.service.AgentService;
import com.xws.tim12.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgentServiceImpl implements UserDetailsService, AgentService {

    @Autowired
    private AuthService authService;

    @Autowired
    private AgentRepository agentRepository;

    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    public void insertHardcodedAgentAfterStartup() {
//        Set<Authority> authorities = authService.findByName("ROLE_NORMAL_USER");
//        User user = new User();
//        user.setUsername("user");
//        user.setPassword("$2a$10$l8J.2UoFqfOwj9t7GRAtAen1/t8Sz2HfAxYT9LehVxq58wa9LihEi"); // pwd: 123
//        user.setAuthorities(authorities);
//
//        if (findByUsername(user.getUsername()) != null) {
//            return;
//        }
//
//        userRepository.save(user);
    }

    @Override
    public Agent findByUsername(String username) {
        return agentRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Agent agent = findByUsername(username);
        if (agent == null) {
            throw new UsernameNotFoundException(String.format("User %s not found", username));
        } else {
            return agent;
        }
    }

}
