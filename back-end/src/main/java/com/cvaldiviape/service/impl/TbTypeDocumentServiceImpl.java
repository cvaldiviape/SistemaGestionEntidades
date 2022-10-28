package com.cvaldiviape.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cvaldiviape.dto.request.TypeDocumentRequestDTO;
import com.cvaldiviape.dto.response.TypeDocumentResponseDTO;
import com.cvaldiviape.dto.response.page.PageBase;
import com.cvaldiviape.entity.TbTypeDocument;
import com.cvaldiviape.mapper.TbTypeDocumentMapper;
import com.cvaldiviape.repository.TbTypeDocumentRepository;
import com.cvaldiviape.service.TbTypeDocumentService;
import com.cvaldiviape.service.util.TbTypeDocumentServiceUtil;
import com.cvaldiviape.util.AppHelpers;

@Service
@Transactional
public class TbTypeDocumentServiceImpl implements TbTypeDocumentService {

	@Autowired
	private TbTypeDocumentRepository typeDocumentRepository;
	@Autowired
	private TbTypeDocumentMapper typeDocumentMapper;
	@Autowired
	private AppHelpers appHelpers;	
	@Autowired
	private TbTypeDocumentServiceUtil serviceUtil;	
	
	// ---------------------------------------------------- services ---------------------------------------------------- //
	@Override
	public PageBase<TypeDocumentResponseDTO> getAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir) {
		// TODO Auto-generated method stub
		Pageable pageable = this.appHelpers.getPageable(numberPage, sizePage, sortBy, sortDir);
		Page<TbTypeDocument> listPage = this.typeDocumentRepository.findAll(pageable);	
		List<TbTypeDocument> listTable = listPage.getContent();
		
		List<TypeDocumentResponseDTO> listDTO = listTable
				.stream()
				.map((x) -> this.typeDocumentMapper.mapEntityToResponseDTO(x))
				.collect(Collectors.toList());
		
		return PageBase.<TypeDocumentResponseDTO>builder()
				.elements(listDTO)
				.numberPage(listPage.getNumber())
				.sizePage(listPage.getSize())
				.totalElements(listPage.getTotalElements())
				.totalPages(listPage.getTotalPages())
				.isLastPage(listPage.isLast())
				.build();
	}

	@Override
	public TypeDocumentResponseDTO getById(Integer id) {
		// TODO Auto-generated method stub
		TbTypeDocument entity = this.serviceUtil.getTypeDocumentById(id);
		return this.typeDocumentMapper.mapEntityToResponseDTO(entity);
	}

	@Override
	public TypeDocumentResponseDTO create(TypeDocumentRequestDTO requestDTO) {
		// TODO Auto-generated method stub
		this.serviceUtil.verifyNameUnique(requestDTO.getName());
		this.serviceUtil.verifyCodeUnique(requestDTO.getCode());
		TbTypeDocument entity = this.typeDocumentMapper.mapRequestToEntity(requestDTO);
		entity.setState(false);
		return  this.typeDocumentMapper.mapEntityToResponseDTO(this.typeDocumentRepository.save(entity));	
	}

	@Override
	public TypeDocumentResponseDTO update(Integer id, TypeDocumentRequestDTO requestDTO) {
		// TODO Auto-generated method stub
		TbTypeDocument entityCurrent = this.serviceUtil.getTypeDocumentById(id);
		this.serviceUtil.verifyNameUnique(requestDTO.getName(), entityCurrent.getName());
		this.serviceUtil.verifyCodeUnique(requestDTO.getCode(), entityCurrent.getCode());
		
		entityCurrent.setName(requestDTO.getName());
		entityCurrent.setCode(requestDTO.getCode());
		entityCurrent.setDescription(requestDTO.getDescription());
		
		return this.typeDocumentMapper.mapEntityToResponseDTO(this.typeDocumentRepository.save(entityCurrent));
	}

	@Override
	public TypeDocumentResponseDTO delete(Integer id) {
		// TODO Auto-generated method stub
		TbTypeDocument entity = this.serviceUtil.getTypeDocumentById(id);
		this.typeDocumentRepository.delete(entity);
		return this.typeDocumentMapper.mapEntityToResponseDTO(entity);
	}
	
}