package com.cvaldiviape.repository;

import com.cvaldiviape.entity.TbTypeDocument;
import com.cvaldiviape.repository.base.BaseRepository;

public interface TbTypeDocumentRepository extends BaseRepository<TbTypeDocument, Integer> {

	public Boolean existsByCode(String code);
	
	public Boolean existsByName(String name);
	
}