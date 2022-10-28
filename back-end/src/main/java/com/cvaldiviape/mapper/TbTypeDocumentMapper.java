package com.cvaldiviape.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cvaldiviape.dto.request.TypeDocumentRequestDTO;
import com.cvaldiviape.dto.response.TypeDocumentResponseDTO;
import com.cvaldiviape.entity.TbTypeDocument;

@Component
public class TbTypeDocumentMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	// ---------------------------------------------------------- modelMapper --------------------------------------------------------- //
	public TypeDocumentResponseDTO mapEntityToResponseDTO(TbTypeDocument typeDocument) {
		return this.modelMapper.map(typeDocument, TypeDocumentResponseDTO.class);
	}
	
	public TbTypeDocument mapRequestToEntity(TypeDocumentRequestDTO requestDTO) {
		return this.modelMapper.map(requestDTO, TbTypeDocument.class);
	}
	
}