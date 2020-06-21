package com.xws.tim12.MessageService.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xws.tim12.MessageService.dto.SenderDTO;

@Entity
public class Sender {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long userId;
	
	@JsonIgnore
	@OneToMany(mappedBy="sender", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Message> messages = new HashSet<Message>();

	
	public Sender() {
		super();
	}
	
	public Sender(Long userId, Set<Message> messages) {
		super();
		this.userId = userId;
		this.messages = messages;
	}
	
	public Sender(Long userId) {
		super();
		this.userId = userId;
		this.messages = new HashSet<Message>();
	}
	
	
	public Sender(Long id, Long userId, Set<Message> messages) {
		super();
		this.id = id;
		this.userId = userId;
		this.messages = messages;
	}
	
	public Sender(Sender s) {
		super();
		this.id = s.getId();
		this.userId = s.getUserId();
		this.messages = s.getMessages();
	}
	
	public Sender(SenderDTO s) {
		this(s.getUserId());
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

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
	
	
	
}
