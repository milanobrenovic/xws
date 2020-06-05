package com.xws.tim12.dto;



import javax.validation.constraints.NotEmpty;

public class CommentDTO {
	
	private Long id;

    private Long normalUser;

    private Long agent;

    private Long admin;
    
    @NotEmpty(message = "Comment is empty.")
    private String comment;
    

	public CommentDTO(Long id, Long normalUser, String comment) {
		super();
		this.id = id;
		this.normalUser = normalUser;
		this.agent = null;
		this.admin = null;
		this.comment = comment;
	}
	
	/*public CommentDTO(Long id, Long agent, String comment) {
		super();
		this.id = id;
		this.normalUser = null;
		this.agent = agent;
		this.admin = null;
		this.comment = comment;
	}
	
	public CommentDTO(Long id, Long admin, String comment) {
		super();
		this.id = id;
		this.normalUser = null;
		this.agent = null;
		this.admin = admin;
		this.comment = comment;
	}*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNormalUser() {
		return normalUser;
	}

	public void setNormalUser(Long normalUser) {
		this.normalUser = normalUser;
	}

	public Long getAgent() {
		return agent;
	}

	public void setAgent(Long agent) {
		this.agent = agent;
	}

	public Long getAdmin() {
		return admin;
	}

	public void setAdmin(Long admin) {
		this.admin = admin;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
    
    

}
