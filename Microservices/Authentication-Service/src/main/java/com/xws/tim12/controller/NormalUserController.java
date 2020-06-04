package com.xws.tim12.controller;

import com.xws.tim12.dto.NormalUserDTO;
import com.xws.tim12.model.NormalUser;
import com.xws.tim12.repository.NormalUserRepository;
import com.xws.tim12.service.NormalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth/user")
public class NormalUserController {

    @Autowired
    private NormalUserService normalUserService;
    @Autowired
    private NormalUserRepository normalUserRepository;
    @PostMapping(value = "/register")
    public ResponseEntity<NormalUserDTO> register(@RequestBody NormalUserDTO normalUser) {
        try {
            NormalUserDTO normalUserDTO = normalUserService.createNormalUser(normalUser);
            if (normalUserDTO == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(normalUserDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/incrementNumberOfAdds/{id}")
    public ResponseEntity<?> incrementAds(@PathVariable("id") Long id) {
        NormalUser user = normalUserService.findById(id);
        if(user == null){
        	return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        user.setNumberOfAds(user.getNumberOfAds()+1);
        normalUserRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
