package com.cvaldiviape.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository <BaseEntity, ID> extends JpaRepository<BaseEntity, ID>{

}