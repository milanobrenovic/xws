package com.xws.tim12.dto;

import com.xws.tim12.model.Admin;
import com.xws.tim12.model.Agent;
import com.xws.tim12.model.NormalUser;

import javax.validation.constraints.NotEmpty;

public class CommentDTO {
	
	private Long id;

    private NormalUser normalUser;

    private Agent agent;

    private Admin admin;
    
    @NotEmpty(message = "Comment is empty.")
    private String comment;
    

	public CommentDTO(Long id, NormalUser normalUser, String comment) {
		super();
		this.id = id;
		this.normalUser = normalUser;
		this.agent = null;
		this.admin = null;
		this.comment = comment;
	}
	
	public CommentDTO(Long id, Agent agent, String comment) {
		super();
		this.id = id;
		this.normalUser = null;
		this.agent = agent;
		this.admin = null;
		this.comment = comment;
	}
	
	public CommentDTO(Long id, Admin admin, String comment) {
		super();
		this.id = id;
		this.normalUser = null;
		this.agent = null;
		this.admin = admin;
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NormalUser getNormalUser() {
		return normalUser;
	}

	public void setNormalUser(NormalUser normalUser) {
		this.normalUser = normalUser;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
    
    

}
