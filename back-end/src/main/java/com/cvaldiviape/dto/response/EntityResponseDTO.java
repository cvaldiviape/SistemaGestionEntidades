package com.cvaldiviape.dto.response;

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
public class EntityResponseDTO {

	private Integer id;
	private String nroDocument;
	private String companyName;
	private String commercialName;
	private String address;
	private String phone;
	private TypeContributorResponseDTO typeContributor;
	private TypeDocumentResponseDTO typeDocument;
	
}
