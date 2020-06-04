package com.xws.tim12.CarRentService.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class VehicleImagePaths {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Vehicle id cannot be empty.")
    @Column(nullable = false)
    private Long vehicleId;

    @NotEmpty(message = "Image path cannot be empty.")
    @Column(nullable = false)
    private String imagePath;

    public VehicleImagePaths() {

    }

    public VehicleImagePaths(Long vehicleId, String imagePath) {
        this.vehicleId = vehicleId;
        this.imagePath = imagePath;
    }

    public VehicleImagePaths(VehicleImagePaths vehicleImagePaths) {
        this.vehicleId = vehicleImagePaths.vehicleId;
        this.imagePath = vehicleImagePaths.imagePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "VehicleImagePaths{" +
                "id=" + id +
                ", vehicleId=" + vehicleId +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }

}
