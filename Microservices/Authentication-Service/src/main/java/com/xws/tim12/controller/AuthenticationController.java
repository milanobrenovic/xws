package com.xws.tim12.controller;

import com.xws.tim12.dto.AgentDTO;
import com.xws.tim12.dto.LoggedInUserDTO;
import com.xws.tim12.dto.NormalUserDTO;
import com.xws.tim12.model.Agent;
import com.xws.tim12.model.NormalUser;
import com.xws.tim12.security.TokenUtils;
import com.xws.tim12.security.auth.JwtAuthenticationRequest;
import com.xws.tim12.service.AgentService;
import com.xws.tim12.service.AuthService;
import com.xws.tim12.service.NormalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = { "http://localhost:4200" })
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @Autowired
    private NormalUserService normalUserService;

    @Autowired
    private AgentService agentService;

    @Autowired 
    private TokenUtils tokenUtils;

    @PostMapping(value = "/login")
    public ResponseEntity<LoggedInUserDTO> login(@RequestBody JwtAuthenticationRequest authenticationRequest)
        throws AuthenticationException, IOException {
        try {
            LoggedInUserDTO loggedInUserDTO = authService.login(authenticationRequest);

            if (loggedInUserDTO == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                if (loggedInUserDTO.getRole().equals("ROLE_NORMAL_USER")) {
                    NormalUser normalUser = normalUserService.findOneByUsername(loggedInUserDTO.getUsername());
                    NormalUserDTO normalUserDTO = new NormalUserDTO(normalUser);
                    if (normalUserDTO.getIsBanned()) {
                        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
                    }
                } else if (loggedInUserDTO.getRole().equals("ROLE_AGENT")) {
                    Agent agent = agentService.findByUsername(loggedInUserDTO.getUsername());
                    AgentDTO agentDTO = new AgentDTO(agent);
                    if (agentDTO.getIsBanned()) {
                        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
                    }
                }
                return new ResponseEntity<>(loggedInUserDTO, HttpStatus.OK);
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
   /* @PostMapping(value = "/setHeader")
    public ResponseEntity<?> setHeader(@RequestBody String role,HttpServletRequest request)
    {
       	request.setAttribute("role", role);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }*/
   // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/role/{role}")
    public Boolean hasRole(@PathVariable("role") String role,HttpServletRequest request){
    	String token = tokenUtils.getToken(request);
    	String rolee = tokenUtils.getRoleFromToken(token);
    	int duzina = rolee.length();
    	role = role.substring(1, duzina+1);
    	System.out.println("header:::  "+ rolee+ "   ROLE::: "+role);
    		if(rolee.equals(role)){
    			return true;
    		}else
    		return false;
          
        }	
    
    

}
