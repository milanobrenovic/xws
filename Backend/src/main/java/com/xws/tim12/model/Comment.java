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
    private NormalUser normalUser;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Agent agent;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Admin admin;

    @Column(columnDefinition = "VARCHAR(500)", nullable = false)
    private String comment;

    public Comment() {

    }

    public Comment(NormalUser normalUser, Agent agent, Admin admin, String comment) {
        this.normalUser = normalUser;
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
