package com.cvaldiviape.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.cvaldiviape.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
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
@Table(name = "tb_entidad") 
public class TbEntity extends BaseEntity {

	@Column(name = "nro_documento", nullable = false, unique = true, columnDefinition="char(8)")
	private String nroDocument;
	@Column(name = "razon_social", nullable = false, unique = true, columnDefinition="varchar(20)")
	private String companyName;
	@Column(name = "nombre_comercial", nullable = false, unique = true, columnDefinition="varchar(20)")
	private String commercialName;
	@Column(name = "direccion", nullable = false, columnDefinition="varchar(50)")
	private String address;
	@Column(name = "telefono", nullable = false, columnDefinition="char(9)")
	private String phone;
	@Column(name = "estado",nullable = false)
	private Boolean state;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_documento")
	private TbTypeDocument typeDocument;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_contribuyente")
	private TbTypeContributor typeContributor;

}