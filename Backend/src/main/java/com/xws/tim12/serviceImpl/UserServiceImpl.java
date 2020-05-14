package com.xws.tim12.serviceImpl;

import com.xws.tim12.model.NormalUser;
import com.xws.tim12.repository.UserRepository;
import com.xws.tim12.service.AuthService;
import com.xws.tim12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    public void insertHardcodedNormalUserAfterStartup() {
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
    public NormalUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NormalUser normalUser = findByUsername(username);
        if (normalUser == null) {
            throw new UsernameNotFoundException(String.format("User %s not found", username));
        } else {
            return normalUser;
        }
    }

}
