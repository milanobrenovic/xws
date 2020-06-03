package com.example.requestService.serviceImpl;

import com.example.requestService.dto.NormalUserDTO;
import com.example.requestService.model.NormalUser;
import com.example.requestService.repository.NormalUserRepository;

import com.example.requestService.service.NormalUserService;

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
    private NormalUserRepository normalUserRepository;

    
    @Override
    public NormalUser findById(Long id){
    	return normalUserRepository.findOneById(id);
    }
    @Override
    public NormalUser findByUsername(String username) {
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
        NormalUser normalUser = findByUsername(username);
        if (normalUser == null) {
            throw new UsernameNotFoundException(String.format("User %s not found", username));
        } else {
            return normalUser;
        }
    }

   
}
