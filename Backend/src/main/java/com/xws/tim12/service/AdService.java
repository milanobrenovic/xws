package com.xws.tim12.service;

import com.xws.tim12.dto.AdDTO;
import com.xws.tim12.model.Ad;

public interface AdService {
	Ad findById(Long id);

	Ad create(AdDTO ad);
}
