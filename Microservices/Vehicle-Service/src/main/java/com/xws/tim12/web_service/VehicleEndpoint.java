package com.xws.tim12.web_service;

import org.example.vehicles.GetVehicleRequest;
import org.example.vehicles.GetVehicleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.xws.tim12.model.Vehicle;
import com.xws.tim12.service.VehicleService;

@Endpoint
public class VehicleEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.org/vehicles";

    @Autowired
    private VehicleService vehicleService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getVehicleRequest")
    @ResponsePayload
    public GetVehicleResponse getVehicleResponse(@RequestPayload GetVehicleRequest request) {
        GetVehicleResponse response = new GetVehicleResponse();

        Vehicle v = new Vehicle();
        v.setId(request.getVehicle().getId());
        v.setIdOwner(request.getVehicle().getIdOwner());
        v.setBrand(request.getVehicle().getBrand());
        v.setModel(request.getVehicle().getModel());
        //v.setFuelType(1);
        //v.setTransmissionType(transmissionType);
        //v.setVehicleType(request.getVehicle().getVehicletype());
        v.setPrice(request.getVehicle().getPrice());
        v.setTravelledMileage(request.getVehicle().getTravelledMileage());
        v.setPlannedMileageToTravel(request.getVehicle().getPlannedMileageToTravel());
        v.setMileageUnlimited(request.getVehicle().isIsMileageUnlimited());
        v.setHasCollisionDamageWaiver(request.getVehicle().isHasCollisionDamageWaiver());
        v.setNumberOfSeats(request.getVehicle().getNumberOfSeats());
        v.setGrade(request.getVehicle().getGrade());
        v.setAvailable(request.getVehicle().isAvailable());
        v.setVehicleDiscount(request.getVehicle().getVehicleDiscount());
        v.setInsurancePrice(request.getVehicle().getInsurancePrice());
        //response.setVehicle(request.getName());

        Vehicle newVehicle = vehicleService.save(v);

        return response;
    }

}
