package com.xws.tim12.MessageService.dto;

import javax.persistence.Column;

import com.xws.tim12.MessageService.model.Receiver;

public class ReceiverDTO {
	
	private Long id;
	
	private Long userId;
	
	
	public ReceiverDTO() {
		
	}

	public ReceiverDTO(Long id, Long userId) {
		super();
		this.id = id;
		this.userId = userId;
	}
	
	public ReceiverDTO(Long userId) {
		super();
		this.userId = userId;
	}
	
	
	public ReceiverDTO(Receiver r) {
		this(r.getId(), r.getUserId());
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
