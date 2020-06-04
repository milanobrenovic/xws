package com.xws.tim12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.dto.TransmissionTypeDTO;
import com.xws.tim12.model.TransmissionType;
import com.xws.tim12.repository.TransmissionTypeRepository;

@Service
public class TransmissionTypeService {

	@Autowired
	private TransmissionTypeRepository transmissionTypeRepository;
	
	public TransmissionType findOne(Long id) {
		return transmissionTypeRepository.findOneById(id);
	}
	
	public List<TransmissionType> findAll(){
		return transmissionTypeRepository.findAll();
	}
	
	public TransmissionType save(TransmissionType transmissionType) {
		return transmissionTypeRepository.save(transmissionType);
	}
	
	public TransmissionType convertFromDTO(TransmissionTypeDTO transmissionTypeDTO) {
		return  new TransmissionType(transmissionTypeDTO.getType());
	}
}
