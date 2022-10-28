package com.cvaldiviape.repository;

import com.cvaldiviape.entity.TbTypeContributor;
import com.cvaldiviape.repository.base.BaseRepository;

public interface TbTypeContributorRepository extends BaseRepository<TbTypeContributor, Integer> {

	public Boolean existsByName(String name);
	
}