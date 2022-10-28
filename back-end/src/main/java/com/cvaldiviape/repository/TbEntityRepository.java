package com.cvaldiviape.repository;

import com.cvaldiviape.entity.TbEntity;
import com.cvaldiviape.repository.base.BaseRepository;

public interface TbEntityRepository extends BaseRepository<TbEntity, Integer> {

	public Boolean existsByCompanyName(String companyName);
	
	public Boolean existsByCommercialName(String commercialName);
	
	public Boolean existsByNroDocument(String nroDocument);
	
}