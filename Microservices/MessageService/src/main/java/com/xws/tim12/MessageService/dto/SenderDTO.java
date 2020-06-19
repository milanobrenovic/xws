package com.xws.tim12.MessageService.dto;

import javax.persistence.Column;

import com.xws.tim12.MessageService.model.Sender;

public class SenderDTO {
	
	private Long id;
	
	private Long userId;
	
	
	
	public SenderDTO() {
		
	}
	

	public SenderDTO(Long id, Long userId) {
		super();
		this.id = id;
		this.userId = userId;
	}
	
	public SenderDTO(Long userId) {
		super();
		this.userId = userId;
	}
	
	public SenderDTO(Sender s) {
		this(s.getId(), s.getUserId());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
}
