package com.xws.tim12.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.xws.tim12.dto.VehicleImageDTO;
import com.xws.tim12.model.VehicleImage;
import com.xws.tim12.repository.VehicleImageRepository;

@Service
public class VehicleImageService {

	@Autowired
	private VehicleImageRepository vehicleImageRepository;
	
	public VehicleImageService() {}
	
	public VehicleImage findOne(Long id) {
		return vehicleImageRepository.findOneById(id);
	}
	
	public List<VehicleImage> findAll(){
		return vehicleImageRepository.findAll();
	}
	
	public VehicleImage save(VehicleImage vehicleImage ) {
		return vehicleImageRepository.save(vehicleImage);
	}
	
	public VehicleImage convertFromDTO(VehicleImageDTO vehicleImageDTO) {
		return  new VehicleImage(vehicleImageDTO.getImageName(), vehicleImageDTO.getImageType(), vehicleImageDTO.getImageBytes());
	}
	
	public VehicleImage storeImage(MultipartFile image) throws IOException {
		
		String fileName = StringUtils.cleanPath(image.getOriginalFilename());
		
		VehicleImage vehicleImage = new VehicleImage(fileName, image.getContentType(), image.getBytes());

		return vehicleImageRepository.save(vehicleImage);
	}
	
}
