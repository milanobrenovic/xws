package com.xws.tim12.serviceImpl;

import com.xws.tim12.dto.NormalUserDTO;
import com.xws.tim12.model.Admin;
import com.xws.tim12.model.NormalUser;
import com.xws.tim12.repository.NormalUserRepository;
import com.xws.tim12.service.AuthService;
import com.xws.tim12.service.NormalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NormalUserServiceImpl implements UserDetailsService, NormalUserService {

    @Autowired
    private AuthService authService;

    @Autowired
    private NormalUserRepository normalUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
    public NormalUser findById(Long id){
    	return normalUserRepository.findOneById(id);
    }
    @Override
    public NormalUser findOneByUsername(String username) {
        return normalUserRepository.findByUsername(username);
    }
    
    @Override
    public NormalUser getUserLogin() {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        try {
            NormalUser normalUser = normalUserRepository.findByUsername(currentUser.getName());
            if (normalUser != null) {
                return normalUser;
            }
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NormalUser normalUser = findOneByUsername(username);
        if (normalUser == null) {
            throw new UsernameNotFoundException(String.format("User %s not found", username));
        } else {
            return normalUser;
        }
    }

    @Override
    public NormalUserDTO createNormalUser(NormalUserDTO normalUserDTO) {
        if (normalUserRepository.findByUsername(normalUserDTO.getUsername()) != null) {
            return null;
        }

        String hashedPassword = passwordEncoder.encode(normalUserDTO.getPassword());

        NormalUser newNormalUser = new NormalUser(
                normalUserDTO.getUsername(),
                hashedPassword,
                normalUserDTO.getFirstName(),
                normalUserDTO.getLastName(),
                normalUserDTO.getEmail(),
                normalUserDTO.getCountry(),
                normalUserDTO.getPhoneNumber(),
                normalUserDTO.getAddress(),
                normalUserDTO.getCity(),
                normalUserDTO.getNumberOfAds() == null ? 0 : normalUserDTO.getNumberOfAds(),
                normalUserDTO.getIsBanned()
        );
        newNormalUser.setAuthorities(authService.findById(2L));
        return new NormalUserDTO(normalUserRepository.save(newNormalUser));
    }

    @Override
    public NormalUserDTO blockNormalUser(String username) {
        return block(username, true);
    }

    @Override
    public NormalUserDTO unblockNormalUser(String username) {
        return block(username, false);
    }

    @Override
    public NormalUserDTO deleteNormalUser(String username) {
        if (normalUserRepository.findByUsername(username) == null) {
            return null;
        }

        NormalUser normalUser = findOneByUsername(username);
        normalUserRepository.delete(normalUser);

        return new NormalUserDTO(normalUser);
    }

    private NormalUserDTO block(String username, boolean block) {
        if (normalUserRepository.findByUsername(username) == null) {
            return null;
        }

        NormalUser normalUser = findOneByUsername(username);
        normalUser.setBanned(block);
        normalUserRepository.save(normalUser);

        return new NormalUserDTO(normalUser);
    }

}
