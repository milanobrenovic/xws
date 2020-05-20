package com.xws.tim12.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class VehicleImagePath {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Image path cannot be empty.")
    @Column(nullable = false)
    private String imagePath;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Vehicle vehicle;
    
    public VehicleImagePath() {

    }

    public VehicleImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public VehicleImagePath(VehicleImagePath vehicleImagePath) {
        this.imagePath = vehicleImagePath.imagePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "VehicleImagePath{" +
                "id=" + id +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }

}
