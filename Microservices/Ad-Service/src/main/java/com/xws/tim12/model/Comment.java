package com.xws.tim12.model;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long normalUser;

    private Long agent;

    private Long admin;

    @Column(columnDefinition = "VARCHAR(500)", nullable = false)
    private String comment;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Ad ad;
    

    public Comment() {

    }
    
    public Comment(Long normalUser, Long agent, Long admin, String comment) {
        this.normalUser = normalUser;
        this.agent = agent;
        this.admin = admin;
        this.comment = comment;
    }
    
    public Comment(Long id, Long normalUser, Long agent, Long admin, String comment, Ad ad) {
		super();
		this.id = id;
		this.normalUser = normalUser;
		this.agent = agent;
		this.admin = admin;
		this.comment = comment;
		this.ad = ad;
	}

	public Ad getAd() {
		return ad;
	}

	public void setAd(Ad ad) {
		this.ad = ad;
	}

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

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", user=" + normalUser +
                ", agent=" + agent +
                ", admin=" + admin +
                ", comment='" + comment + '\'' +
                '}';
    }

}
