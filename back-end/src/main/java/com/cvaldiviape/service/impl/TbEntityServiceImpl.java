package com.cvaldiviape.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cvaldiviape.dto.request.EntityRequestDTO;
import com.cvaldiviape.dto.response.EntityResponseDTO;
import com.cvaldiviape.dto.response.page.PageBase;
import com.cvaldiviape.entity.TbEntity;
import com.cvaldiviape.mapper.TbEntityMapper;
import com.cvaldiviape.repository.TbEntityRepository;
import com.cvaldiviape.service.TbEntityService;
import com.cvaldiviape.service.util.TbEntityServiceUtil;
import com.cvaldiviape.util.AppHelpers;

@Service
@Transactional
public class TbEntityServiceImpl implements TbEntityService {
	
	@Autowired
	private TbEntityRepository entityRepository;
	@Autowired
	private TbEntityMapper entityMapper;
	@Autowired
	private AppHelpers appHelpers;
	@Autowired
	private TbEntityServiceUtil serviceUtil;	

	// ---------------------------------------------------- services ---------------------------------------------------- //
	@Override
	public PageBase<EntityResponseDTO> getAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir) {
		// TODO Auto-generated method stub
		Pageable pageable = this.appHelpers.getPageable(numberPage, sizePage, sortBy, sortDir);
		Page<TbEntity> listPage = this.entityRepository.findAll(pageable);	
		List<TbEntity> listTable = listPage.getContent();
		
		List<EntityResponseDTO> listDTO = listTable
				.stream()
				.map((x) -> this.entityMapper.mapEntityToResponseDTO(x))
				.collect(Collectors.toList());
		
		return PageBase.<EntityResponseDTO>builder()
				.elements(listDTO)
				.numberPage(listPage.getNumber())
				.sizePage(listPage.getSize())
				.totalElements(listPage.getTotalElements())
				.totalPages(listPage.getTotalPages())
				.isLastPage(listPage.isLast())
				.build();
	}

	@Override
	public EntityResponseDTO getById(Integer id) {
		// TODO Auto-generated method stub
		TbEntity entity = this.serviceUtil.getEntidadById(id);
		return this.entityMapper.mapEntityToResponseDTO(entity);
	}

	@Override
	public EntityResponseDTO create(EntityRequestDTO requestDTO) {
		// TODO Auto-generated method stub
		this.serviceUtil.verifyCompanyNameUnique(requestDTO.getCompanyName());
		this.serviceUtil.verifyCommercialNameUnique(requestDTO.getCommercialName());
		this.serviceUtil.verifyNroDocumentUnique(requestDTO.getNroDocument());
		
		TbEntity entity = this.entityMapper.mapRequestToEntity(requestDTO);
		entity.setTypeDocument(this.serviceUtil.getTypeDocumentById(requestDTO.getTypeDocumentId()));
		entity.setTypeContributor(this.serviceUtil.getTypeContributorById(requestDTO.getTypeContributorId()));
		entity.setState(false);
		
		return  this.entityMapper.mapEntityToResponseDTO(this.entityRepository.save(entity));	
	}

	@Override
	public EntityResponseDTO update(Integer id, EntityRequestDTO requestDTO) {
		// TODO Auto-generated method stub
		TbEntity entityCurrent = this.serviceUtil.getEntidadById(id);
		this.serviceUtil.verifyCompanyNameUnique(requestDTO.getCompanyName(), entityCurrent.getCompanyName());
		this.serviceUtil.verifyCommercialNameUnique(requestDTO.getCommercialName(), entityCurrent.getCommercialName());
		this.serviceUtil.verifyNroDocumentUnique(requestDTO.getNroDocument(), entityCurrent.getNroDocument());

		entityCurrent.setCompanyName(requestDTO.getCompanyName());
		entityCurrent.setCommercialName(requestDTO.getCommercialName());
		entityCurrent.setNroDocument(requestDTO.getNroDocument());
		entityCurrent.setAddress(requestDTO.getAddress());
		entityCurrent.setPhone(requestDTO.getPhone());		
		entityCurrent.setTypeContributor(this.serviceUtil.getTypeContributorById(requestDTO.getTypeContributorId()));
		entityCurrent.setTypeDocument(this.serviceUtil.getTypeDocumentById(requestDTO.getTypeDocumentId()));
		entityCurrent.setState(false);
		
		return this.entityMapper.mapEntityToResponseDTO(this.entityRepository.save(entityCurrent));
	}

	@Override 	
	public EntityResponseDTO delete(Integer id) {
		// TODO Auto-generated method stub
		TbEntity entity = this.serviceUtil.getEntidadById(id);
		this.entityRepository.delete(entity);
		return this.entityMapper.mapEntityToResponseDTO(entity);
	}

}