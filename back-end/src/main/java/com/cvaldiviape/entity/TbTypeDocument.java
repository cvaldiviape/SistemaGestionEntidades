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
@Table(name = "tb_tipo_documento") 
public class TbTypeDocument extends BaseEntity {

	@Column(name = "codigo", nullable = false, unique = true, columnDefinition="varchar(20)")
	private String code;
	@Column(name = "nombre", nullable = false, unique = true, columnDefinition="varchar(100)")
	private String name;
	@Column(name = "descripcion", columnDefinition="varchar(500)")
	private String description;
	@Column(name = "estado", nullable = false)
	private Boolean state;
	@Builder.Default
	@JsonBackReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "typeDocument")
	private Set<TbEntity> tbEntities = new HashSet<>();
	
}