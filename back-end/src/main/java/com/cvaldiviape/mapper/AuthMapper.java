package com.cvaldiviape.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cvaldiviape.dto.response.UserAuthResponseDTO;
import com.cvaldiviape.entity.TbUser;

@Component
public class AuthMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	// ---------------------------------------------------------- modelMapper --------------------------------------------------------- //
	public UserAuthResponseDTO mapEntityToResponse(TbUser entity) {
		return this.modelMapper.map(entity, UserAuthResponseDTO.class);
	}

}