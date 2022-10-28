package com.cvaldiviape.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cvaldiviape.dto.request.UserRequestDTO;
import com.cvaldiviape.dto.response.UserResponseDTO;
import com.cvaldiviape.entity.TbUser;

@Component
public class TbUserMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	// ---------------------------------------------------------- modelMapper --------------------------------------------------------- //
	public UserResponseDTO mapEntityToResponseDTO(TbUser user) {
		return this.modelMapper.map(user, UserResponseDTO.class);
	}
	
	public TbUser mapRequestToEntity(UserRequestDTO requestDTO) {
		return this.modelMapper.map(requestDTO, TbUser.class);
	}

}