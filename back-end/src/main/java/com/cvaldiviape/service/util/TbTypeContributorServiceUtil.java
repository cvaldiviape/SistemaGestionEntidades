package com.cvaldiviape.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.cvaldiviape.entity.TbTypeContributor;
import com.cvaldiviape.exception.ResourceNotFoundException;
import com.cvaldiviape.exception.StandarException;
import com.cvaldiviape.repository.TbTypeContributorRepository;

@Component
public class TbTypeContributorServiceUtil {

	@Autowired
	private TbTypeContributorRepository typeContributorRepository;

	// ---------------------------------------------------- utils ---------------------------------------------------- //
	public TbTypeContributor getTypeContributorById(Integer id) {
		return this.typeContributorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tipo de contribuyente", "id", id));
	}
	
	public void verifyNameUnique(String name) {
		Boolean existName = this.typeContributorRepository.existsByName(name);
		if(existName) {
			throw new StandarException(HttpStatus.BAD_REQUEST, "El nombre '" + name + "' ya existe!");
		}
	}
	
	public void verifyNameUnique(String name, String nameCurrent) {
		Boolean existName = this.typeContributorRepository.existsByName(name);
		Boolean diferentNameCurrent = (!name.equalsIgnoreCase(nameCurrent));
		if(existName && diferentNameCurrent) {
			throw new StandarException(HttpStatus.BAD_REQUEST, "El nombre '" + name + "' ya existe!");
		}
	}
	
}