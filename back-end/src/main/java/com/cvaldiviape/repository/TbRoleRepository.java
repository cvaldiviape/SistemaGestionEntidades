package com.cvaldiviape.repository;

import java.util.Optional;
import com.cvaldiviape.entity.TbRole;
import com.cvaldiviape.repository.base.BaseRepository;

public interface TbRoleRepository extends BaseRepository<TbRole, Integer> {
	
	public Optional<TbRole> findByName(String name);
	
	public Boolean existsByName(String name);
	
}