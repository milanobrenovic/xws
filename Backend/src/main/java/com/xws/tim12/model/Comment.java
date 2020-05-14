package com.xws.tim12.model;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
public class Comment {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Agent agent;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Admin admin;

    @Column(columnDefinition = "VARCHAR(500)", nullable = false)
    private String comment;

    public Comment() {

    }

    public Comment(User user, Agent agent, Admin admin, String comment) {
        this.user = user;
        this.agent = agent;
        this.admin = admin;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", user=" + user +
                ", agent=" + agent +
                ", admin=" + admin +
                ", comment='" + comment + '\'' +
                '}';
    }

}
