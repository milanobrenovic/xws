package com.xws.tim12.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.xws.tim12.dto.ReservationDate;
import com.xws.tim12.dto.TransportationVehicleDTO;
import com.xws.tim12.enumeration.UserRanking;
import com.xws.tim12.model.NormalUser;
import com.xws.tim12.model.TransportationVehicle;
import com.xws.tim12.repository.TransportationVehicleRepository;
import com.xws.tim12.service.AgencyService;
import com.xws.tim12.service.NormalUserService;
import com.xws.tim12.service.TransportationVehicleService;

@RestController
//@RequestMapping(value = "/api/request/")
@CrossOrigin(origins = { "http://localhost:4200" })
public class TransportationVehicleController {
	@Autowired
	private TransportationVehicleService transportationVehicleService;
	@Autowired
	private TransportationVehicleRepository transportationVehicleRepository;
	@Autowired
	private NormalUserService normalUserService;
	@Autowired
	private AgencyService agencyService;
	
	
	@PostMapping(value = "/createVehicle/{idAgencije}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransportationVehicleDTO> createVehicle(@RequestBody TransportationVehicleDTO transportationVehicleDTO, @RequestHeader(value = "Id") String id, @RequestHeader(value = "Role") String role,@PathVariable Long idAgencije){
		if(transportationVehicleDTO.getClass() == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Long idd = (Long.parseLong(id));
		if(normalUserService.findById(idd).getRank() != UserRanking.ELITE) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		if(normalUserService.findById(idd).getAgency().getId() != idAgencije) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		TransportationVehicle vehicle = new TransportationVehicle(222L, transportationVehicleDTO.getBrand(), transportationVehicleDTO.getModel(),transportationVehicleDTO.getType() );		
		vehicle.setAgency(agencyService.findById(idAgencije));
		transportationVehicleRepository.save(vehicle);
		
		return new ResponseEntity<>(transportationVehicleDTO, HttpStatus.CREATED);
	}
	
	
	@PostMapping(value = "/reserveTransportation/{idAgencije}/{idVozila}") //PROMENI REQUESTBODY AKO BUDE TREBALO
    public ResponseEntity<TransportationVehicle> reserveVehicle(@PathVariable Long idAgencije ,@PathVariable Long idVozila,@RequestBody ReservationDate dates,@RequestHeader(value = "Id") String id) {
        TransportationVehicle tv = transportationVehicleService.findById(idVozila);
        if(tv== null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Long idd = (Long.parseLong(id));
        if(normalUserService.findById(idd).getRank().equals("NORMAL") || normalUserService.findById(idd).getRank() == UserRanking.NORMAL) {
        	return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        }
        
        
        
        Boolean dozvoljeno = true;
        if(!normalUserService.findById(idd).getAgency().getAgencies().contains(agencyService.findById(idAgencije))) {
        	System.out.println("NE SADRZI");
        	dozvoljeno = false;
        }
        for (int i=0;i<tv.getStartDates().size();i++) {
			if(tv.getStartDates().get(i).compareTo(dates.getRentDateTo()) < 0 ){
				dozvoljeno = false;
			}
			else if (tv.getEndDates().get(i).compareTo(dates.getRentDateFrom()) > 0 ){
				dozvoljeno = false;
			}
			else if(tv.getStartDates().get(i).compareTo(dates.getRentDateFrom()) > 0 && tv.getEndDates().get(i).compareTo(dates.getRentDateTo()) < 0){
				dozvoljeno = false;
        }	else if(tv.getStartDates().get(i).compareTo(dates.getRentDateFrom()) == 0 || tv.getEndDates().get(i).compareTo(dates.getRentDateTo()) == 0){
				dozvoljeno = false;
        }
        }
		if(dozvoljeno) {
        tv.getStartDates().add(dates.getRentDateFrom());
        tv.getEndDates().add(dates.getRentDateTo());
        tv.getAgencyId().add(idAgencije);
        transportationVehicleRepository.save(tv);
        
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
        return new ResponseEntity<TransportationVehicle>(tv,HttpStatus.ACCEPTED);
    }
	
	@PostMapping(value = "/cancelReservation/{idAgencije}/{idVozila}") //PROMENI REQUESTBODY AKO BUDE TREBALO
    public ResponseEntity<TransportationVehicle> cancelVehicle(@PathVariable Long idAgencije ,@PathVariable Long idVozila,@RequestBody ReservationDate dates,@RequestHeader(value = "Id") String id) {
        TransportationVehicle tv = transportationVehicleService.findById(idVozila);
        Long idd = (Long.parseLong(id));
        
        for (int i=0;i<tv.getStartDates().size();i++) {
        	if(tv.getStartDates().get(i).compareTo(dates.getRentDateFrom()) == 0 ){
				if(tv.getEndDates().get(i).compareTo(dates.getRentDateTo()) == 0 ) {
					System.out.println((normalUserService.findById(idd).getRank()));
					System.out.println(normalUserService.findById(idd).getRank() == UserRanking.ELITE);
					if(normalUserService.findById(idd).getRank() == UserRanking.ELITE && normalUserService.findById(idd).getAgency().getId() == idAgencije /*&& tv.getAgencyId().get(i) == idAgencije*/) {
					tv.getStartDates().remove(i);
					tv.getEndDates().remove(i);
					tv.getAgencyId().remove(i);
					transportationVehicleRepository.save(tv);
					return new ResponseEntity<TransportationVehicle>(tv,HttpStatus.ACCEPTED);
					}else {
						return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
					}
				}
			}
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}
}
