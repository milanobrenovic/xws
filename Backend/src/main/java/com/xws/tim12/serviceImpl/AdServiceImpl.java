package com.xws.tim12.serviceImpl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.xws.tim12.dto.AdDTO;
import com.xws.tim12.model.Ad;
import com.xws.tim12.repository.AdRepository;
import com.xws.tim12.service.AdService;


@Service
public class AdServiceImpl implements AdService {
	
	@Autowired
	private AdRepository adRepository;
	
	@Override
	public Ad findById(Long id) {
		Optional<Ad> optionalAd = adRepository.findById(id);
		Ad ad = optionalAd.get();
		return ad;
	}

	@Override
	public Ad create(AdDTO ad) {
		Ad newAd = new Ad(ad.getVehicle(), ad.getComments());
		return adRepository.save(newAd);
	}
	

}
