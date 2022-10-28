package com.cvaldiviape.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cvaldiviape.dto.request.TypeContributorRequestDTO;
import com.cvaldiviape.dto.response.TypeContributorResponseDTO;
import com.cvaldiviape.dto.response.page.PageBase;
import com.cvaldiviape.entity.TbTypeContributor;
import com.cvaldiviape.mapper.TbTypeContributorMapper;
import com.cvaldiviape.repository.TbTypeContributorRepository;
import com.cvaldiviape.service.TbTypeContributorService;
import com.cvaldiviape.service.util.TbTypeContributorServiceUtil;
import com.cvaldiviape.util.AppHelpers;

@Service
@Transactional
public class TbTypeContributorServiceImpl implements TbTypeContributorService {

	@Autowired
	private TbTypeContributorRepository typeContributorRepository;
	@Autowired
	private TbTypeContributorMapper typeContributorMapper;
	@Autowired
	private AppHelpers appHelpers;	
	@Autowired
	private TbTypeContributorServiceUtil serviceUtil;	
	// ---------------------------------------------------- services ---------------------------------------------------- //
	@Override
	public PageBase<TypeContributorResponseDTO> getAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir) {
		// TODO Auto-generated method stub
		Pageable pageable = this.appHelpers.getPageable(numberPage, sizePage, sortBy, sortDir);
		Page<TbTypeContributor> listPage = this.typeContributorRepository.findAll(pageable);	
		List<TbTypeContributor> listTable = listPage.getContent();
		
		List<TypeContributorResponseDTO> listDTO = listTable
				.stream()
				.map((x) -> this.typeContributorMapper.mapEntityToResponseDTO(x))
				.collect(Collectors.toList());
		
		return PageBase.<TypeContributorResponseDTO>builder()
				.elements(listDTO)
				.numberPage(listPage.getNumber())
				.sizePage(listPage.getSize())
				.totalElements(listPage.getTotalElements())
				.totalPages(listPage.getTotalPages())
				.isLastPage(listPage.isLast())
				.build();
	}

	@Override
	public TypeContributorResponseDTO getById(Integer id) {
		// TODO Auto-generated method stub
		TbTypeContributor entity = this.serviceUtil.getTypeContributorById(id);
		return this.typeContributorMapper.mapEntityToResponseDTO(entity);
	}

	@Override
	public TypeContributorResponseDTO create(TypeContributorRequestDTO requestDTO) {
		// TODO Auto-generated method stub
		this.serviceUtil.verifyNameUnique(requestDTO.getName());
		TbTypeContributor entity = this.typeContributorMapper.mapRequestToEntity(requestDTO);
		entity.setState(false);
		return  this.typeContributorMapper.mapEntityToResponseDTO(this.typeContributorRepository.save(entity));	
	}

	@Override
	public TypeContributorResponseDTO update(Integer id, TypeContributorRequestDTO requestDTO) {
		// TODO Auto-generated method stub
		TbTypeContributor entityCurrent = this.serviceUtil.getTypeContributorById(id);
		this.serviceUtil.verifyNameUnique(requestDTO.getName(), entityCurrent.getName());
		entityCurrent.setName(requestDTO.getName());
		return this.typeContributorMapper.mapEntityToResponseDTO(this.typeContributorRepository.save(entityCurrent));
	}

	@Override
	public TypeContributorResponseDTO delete(Integer id) {
		// TODO Auto-generated method stub
		TbTypeContributor entity = this.serviceUtil.getTypeContributorById(id);
		this.typeContributorRepository.delete(entity);
		return this.typeContributorMapper.mapEntityToResponseDTO(entity);
	}

}