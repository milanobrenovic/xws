package com.xws.tim12.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xws.tim12.dto.AdDTO;
import com.xws.tim12.dto.CommentDTO;
import com.xws.tim12.model.Ad;
import com.xws.tim12.model.Comment;
import com.xws.tim12.repository.CommentRepository;
import com.xws.tim12.service.AdService;

@RestController
public class CommentController {
	@Autowired 
	private CommentRepository commentRepository;
	@Autowired
	private AdService adServise;
	
	@PostMapping(value = "/commentAd")
	public ResponseEntity<CommentDTO> commentAd(@RequestBody CommentDTO commentDTO,HttpServletRequest httpRequest){
	System.out.println("longId: "+commentDTO.getVehicleId());
	Ad adForComment = adServise.findById((Long)commentDTO.getVehicleId());
	if(adForComment == null){
		System.out.println("bad REQUFAWOREWOAI");
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	Comment comment = new Comment(commentDTO.getNormalUser(),commentDTO.getAgent(),commentDTO.getAdmin(),commentDTO.getComment());
	adForComment.getComments().add(comment);	
	commentRepository.save(comment);
	return new ResponseEntity<>(commentDTO,HttpStatus.OK);

	
	}
	
}
