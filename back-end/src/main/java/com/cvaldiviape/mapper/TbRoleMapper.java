package com.cvaldiviape.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cvaldiviape.dto.request.RoleRequestDTO;
import com.cvaldiviape.dto.response.RoleResponseDTO;
import com.cvaldiviape.entity.TbRole;

@Component
public class TbRoleMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	// ---------------------------------------------------------- modelMapper --------------------------------------------------------- //
	public RoleResponseDTO mapEntityToResponseDTO(TbRole entity) {
		return this.modelMapper.map(entity, RoleResponseDTO.class);
	}
	
	public TbRole mapRequestToEntity(RoleRequestDTO requestDTO) {
		return this.modelMapper.map(requestDTO, TbRole.class);
	}
	
}