package com.cvaldiviape.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import com.cvaldiviape.entity.TbUser;
import com.cvaldiviape.repository.base.BaseRepository;

public interface TbUserRepository extends BaseRepository<TbUser, Integer> {
	
	public Optional<TbUser> findByUsername(String username);
	
	public Boolean existsByUsername(String username);
	
	@Query("SELECT u FROM TbUser u "
	     + "JOIN u.roles r "
	     + "WHERE r.id = ?1 AND u.username = ?2")
	public Optional<TbUser> findByUsernameAndRoleId(Integer roleId, String userNameOrEmail);
	
}