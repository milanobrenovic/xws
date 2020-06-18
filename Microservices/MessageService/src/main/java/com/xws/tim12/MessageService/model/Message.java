package com.xws.tim12.MessageService.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xws.tim12.MessageService.dto.MessageDTO;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="content")
	private String content;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	@Column(name="date", nullable = false)
	private Date date;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Sender sender;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Receiver receiver;
	
	
	
	public Message() {
		super();
	}
	
	
	public Message(String subject, String content) {
		super();
		this.subject = subject;
		this.content = content;
	}
	
	public Message(String subject, String content, Date date) {
		super();
		this.subject = subject;
		this.content = content;
		this.date = date;
	}

	public Message(String subject, String content, Date date, Sender sender, Receiver receiver) {
		super();
		this.subject = subject;
		this.content = content;
		this.date = date;
		this.sender = sender;
		this.receiver = receiver;
	}
	
	public Message(MessageDTO m) {
		this(m.getSubject(), m.getContent(), m.getDate());
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Sender getSender() {
		return sender;
	}

	public void setSender(Sender sender) {
		this.sender = sender;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	
}
