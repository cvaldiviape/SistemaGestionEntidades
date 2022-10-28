package com.cvaldiviape.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.cvaldiviape.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tb_rol") 
public class TbRole extends BaseEntity {

	@Column(name = "name", nullable = false, unique = true)
	private String name;
	@Column(name = "description")
	private String description;
	@Builder.Default
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private Set<TbUser> users = new HashSet<>();
	
}