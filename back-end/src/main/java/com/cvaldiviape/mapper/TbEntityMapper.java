package com.cvaldiviape.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cvaldiviape.dto.request.EntityRequestDTO;
import com.cvaldiviape.dto.response.EntityResponseDTO;
import com.cvaldiviape.entity.TbEntity;

@Component
public class TbEntityMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	// ---------------------------------------------------------- modelMapper --------------------------------------------------------- //
	public EntityResponseDTO mapEntityToResponseDTO(TbEntity entity) {
		return this.modelMapper.map(entity, EntityResponseDTO.class);
	}
	
	public TbEntity mapRequestToEntity(EntityRequestDTO requestDTO) {
		this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return this.modelMapper.map(requestDTO, TbEntity.class);
	}
	
}