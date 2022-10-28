package com.cvaldiviape.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.cvaldiviape.entity.TbEntity;
import com.cvaldiviape.entity.TbTypeContributor;
import com.cvaldiviape.entity.TbTypeDocument;
import com.cvaldiviape.exception.ResourceNotFoundException;
import com.cvaldiviape.exception.StandarException;
import com.cvaldiviape.repository.TbEntityRepository;
import com.cvaldiviape.repository.TbTypeContributorRepository;
import com.cvaldiviape.repository.TbTypeDocumentRepository;

@Component
public class TbEntityServiceUtil {
	
	@Autowired
	private TbEntityRepository entityRepository;
	@Autowired
	private TbTypeDocumentRepository typeDocumentRepository;
	@Autowired
	private TbTypeContributorRepository typeContributorRepository;

	// ---------------------------------------------------- utils ---------------------------------------------------- //
	public TbEntity getEntidadById(Integer id) {
		return this.entityRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Entidad", "id", id));
	}

	public TbTypeDocument getTypeDocumentById(Integer id) {
		return this.typeDocumentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tipo de documento", "id", id));
	}
	
	public TbTypeContributor getTypeContributorById(Integer id) {
		return this.typeContributorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tipo de contribuyente", "id", id));
	}
	
	public void verifyCompanyNameUnique(String companyName) {
		Boolean existCompanyName = this.entityRepository.existsByCompanyName(companyName);
		if(existCompanyName) {
			throw new StandarException(HttpStatus.BAD_REQUEST, "La razón social '" + companyName + "' ya existe!");
		}
	}
	
	public void verifyCompanyNameUnique(String companyName, String companyNameCurrent) {
		Boolean existCompanyName = this.entityRepository.existsByCompanyName(companyName);
		Boolean diferentCompanyNameCurrent = (!companyName.equalsIgnoreCase(companyNameCurrent));
		if(existCompanyName && diferentCompanyNameCurrent) {
			throw new StandarException(HttpStatus.BAD_REQUEST, "La razón social '" + companyName + "' ya existe!");
		}
	}
	
	public void verifyCommercialNameUnique(String commercialName) {
		Boolean existCommercialName = this.entityRepository.existsByCommercialName(commercialName);
		if(existCommercialName) {
			throw new StandarException(HttpStatus.BAD_REQUEST, "El nombre comercial '" + commercialName + "' ya existe!");
		}
	}
	
	public void verifyCommercialNameUnique(String commercialName, String commercialNameCurrent) {
		Boolean existCommercialName = this.entityRepository.existsByCommercialName(commercialName);
		Boolean diferentCommercialNameCurrent = (!commercialName.equalsIgnoreCase(commercialNameCurrent));
		if(existCommercialName && diferentCommercialNameCurrent) {
			throw new StandarException(HttpStatus.BAD_REQUEST, "El nombre comercial '" + commercialName + "' ya existe!");
		}
	}
	
	public void verifyNroDocumentUnique(String nroDocument) {
		Boolean existNroDocument = this.entityRepository.existsByNroDocument(nroDocument);
		if(existNroDocument) {
			throw new StandarException(HttpStatus.BAD_REQUEST, "El número de documento '" + nroDocument + "' ya existe!");
		}
	}
	
	public void verifyNroDocumentUnique(String nroDocument, String nroDocumentCurrent) {
		Boolean existNroDocument = this.entityRepository.existsByNroDocument(nroDocument);
		Boolean diferentNroDocumentCurrent = (!nroDocument.equalsIgnoreCase(nroDocumentCurrent));
		if(existNroDocument && diferentNroDocumentCurrent) {
			throw new StandarException(HttpStatus.BAD_REQUEST, "El número de documento '" + nroDocument + "' ya existe!");
		}
	}
}
