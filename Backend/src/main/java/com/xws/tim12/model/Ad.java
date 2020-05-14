package com.xws.tim12.model;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class Ad {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Vehicle vehicle;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Ad() {

    }

    public Ad(Vehicle vehicle, List<Comment> comments) {
        this.vehicle = vehicle;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", vehicle=" + vehicle.toString() +
                ", comments=" + comments.toString() +
                '}';
    }

}
