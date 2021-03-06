package com.xws.tim12.serviceImpl;

import com.xws.tim12.model.Admin;
import com.xws.tim12.repository.AdminRepository;
import com.xws.tim12.service.AdminService;
import com.xws.tim12.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServiceImpl implements UserDetailsService, AdminService {

    @Autowired
    private AuthService authService;

    @Autowired
    private AdminRepository adminRepository;

    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    public void insertHardcodedAdminAfterStartup() {
//        Set<Authority> authorities = authService.findByName("ROLE_ADMIN");
//        Admin admin = new Admin();
//        admin.setUsername("admin");
//        admin.setPassword("$2a$10$l8J.2UoFqfOwj9t7GRAtAen1/t8Sz2HfAxYT9LehVxq58wa9LihEi"); // pwd: 123
//        admin.setAuthorities(authorities);
//
//        if (findByUsername(admin.getUsername()) != null) {
//            return;
//        }
//
//        adminRepository.save(admin);
    }

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public Admin getAdminLogin() {
    	System.out.println("UlAZIS OVDE KADA???");
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        try {
            Admin admin = adminRepository.findByUsername(currentUser.getName());
            if (admin != null) {
                return admin;
            }
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = findByUsername(username);
        if (admin == null) {
            throw new UsernameNotFoundException(String.format("User %s not found", username));
        } else {
            return admin;
        }
    }
}
