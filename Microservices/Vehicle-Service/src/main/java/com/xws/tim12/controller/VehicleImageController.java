package com.xws.tim12.controller;

import com.xws.tim12.dto.VehicleImageDTO;
import com.xws.tim12.model.VehicleImage;
import com.xws.tim12.service.VehicleImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = { "http://localhost:8087", "http://localhost:4200" })
public class VehicleImageController {

	@Autowired 
	private VehicleImageService vehicleImageService;
	
	@PostMapping("/uploadImage")
	public VehicleImageDTO uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		
		VehicleImage vehicleImage = vehicleImageService.storeImage(file);
		
		VehicleImageDTO vehicleImageDTO = new VehicleImageDTO(vehicleImage);
		
		return vehicleImageDTO;
	}
	
    @PostMapping("/uploadMultipleFiles")
    public List<VehicleImageDTO> uploadMultipleFiles(@RequestParam("imageFiles") MultipartFile[] files) {
    
    	return Arrays.asList(files)
                .stream()
                .map(file -> {
					try {
						return uploadImage(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				})
                .collect(Collectors.toList());
        
    }
	
	@GetMapping(path = { "/getImage/{id}" })
	public ResponseEntity<Resource> getImage(@PathVariable("id") Long id) throws IOException {
		VehicleImage retrievedImage = vehicleImageService.findOne(id);
		
	       return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(retrievedImage.getImageType()))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + retrievedImage.getImageName() + "\"")
	                .body(new ByteArrayResource(retrievedImage.getImageBytes()));
	}
	
	
}
