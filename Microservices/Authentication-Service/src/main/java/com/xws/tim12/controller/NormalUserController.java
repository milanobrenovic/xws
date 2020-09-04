package com.xws.tim12.controller;

import com.xws.tim12.dto.NormalUserDTO;
import com.xws.tim12.model.NormalUser;
import com.xws.tim12.repository.NormalUserRepository;
import com.xws.tim12.service.NormalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping(value = "/api/normal-user")
@CrossOrigin(origins = { "http://localhost:4200" })
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
    @PostMapping(value = "/getId/{id}")
    public ResponseEntity<NormalUser> getIdd(@PathVariable Long id) {
    	return new ResponseEntity<>(normalUserService.findById(id),HttpStatus.OK);
    }
    @GetMapping(value = "/getNumberOfAds/{id}")
    public Integer getNumberOfAds(@PathVariable Long id){
    	return normalUserService.findById(id).getNumberOfAds();
    }
    @GetMapping(value = "/getLoggedInUserRank/{id}")
    public String getRanking(@PathVariable Long id) {
    	
    	return normalUserService.findById(id).getRank().toString();
    }

    @PutMapping(value = "/block/{username}")
    public ResponseEntity<NormalUserDTO> blockNormalUser(@PathVariable("username") String username) {
        try {
            NormalUserDTO normalUserDTO = normalUserService.blockNormalUser(username);
            if (normalUserDTO == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(normalUserDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/unblock/{username}")
    public ResponseEntity<NormalUserDTO> unblockNormalUser(@PathVariable("username") String username) {
        try {
            NormalUserDTO normalUserDTO = normalUserService.unblockNormalUser(username);
            if (normalUserDTO == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(normalUserDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<NormalUserDTO>> getNormalUsers() {
        try {
            List<NormalUserDTO> normalUsersDTO = normalUserService.findAllNormalUsers();
            if (normalUsersDTO == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(normalUsersDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete/{username}")
    public ResponseEntity<NormalUserDTO> deleteNormalUser(@PathVariable("username") String username) {
        try {
            NormalUserDTO normalUserDTO = normalUserService.deleteNormalUser(username);
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
        	System.out.println("udjes u null pa unauthorised???");
        	return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if(user.getNumberOfAds() > 2){
        	return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        user.setNumberOfAds(user.getNumberOfAds()+1);
        normalUserRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
