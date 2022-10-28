package com.cvaldiviape.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.cvaldiviape.entity.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "tb_tipo_contribuyente") 
public class TbTypeContributor extends BaseEntity {

	@Column(name = "nombre", nullable = false, unique = true, columnDefinition="varchar(50)")
	private String name;
	@Column(name = "estado",nullable = false)
	private Boolean state;
	@Builder.Default
	@JsonBackReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "typeContributor")
	private Set<TbEntity> tbEntities = new HashSet<>();
	
}