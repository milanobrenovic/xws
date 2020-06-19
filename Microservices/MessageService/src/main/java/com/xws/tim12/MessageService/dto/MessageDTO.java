package com.xws.tim12.MessageService.dto;

import java.util.Date;

import javax.persistence.Column;

import com.xws.tim12.MessageService.model.Message;

public class MessageDTO {
	
	private Long id;
	
	private String subject;
	
	private String content;
	
	private Date date;
	
	
	public MessageDTO() {
		super();
	}
	
	public MessageDTO(String subject, String content, Date date) {
		super();
		this.subject = subject;
		this.content = content;
		this.date = date;
	}

	public MessageDTO(Long id, String subject, String content, Date date) {
		super();
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.date = date;
	}
	
	public MessageDTO(Message m) {
		this(m.getId(), m.getSubject(), m.getContent(), m.getDate());
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
	
	
}
