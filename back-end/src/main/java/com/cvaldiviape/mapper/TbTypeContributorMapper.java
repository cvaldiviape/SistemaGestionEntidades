package com.cvaldiviape.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cvaldiviape.dto.request.TypeContributorRequestDTO;
import com.cvaldiviape.dto.response.TypeContributorResponseDTO;
import com.cvaldiviape.entity.TbTypeContributor;

@Component
public class TbTypeContributorMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	// ---------------------------------------------------------- modelMapper --------------------------------------------------------- //
	public TypeContributorResponseDTO mapEntityToResponseDTO(TbTypeContributor typeContributor) {
		return this.modelMapper.map(typeContributor, TypeContributorResponseDTO.class);
	}
	
	public TbTypeContributor mapRequestToEntity(TypeContributorRequestDTO requestDTO) {
		return this.modelMapper.map(requestDTO, TbTypeContributor.class);
	}
	
}