package com.cvaldiviape.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.cvaldiviape.entity.TbTypeDocument;
import com.cvaldiviape.exception.ResourceNotFoundException;
import com.cvaldiviape.exception.StandarException;
import com.cvaldiviape.repository.TbTypeDocumentRepository;

@Component
public class TbTypeDocumentServiceUtil {
	
	@Autowired
	private TbTypeDocumentRepository typeDocumentRepository;
		
	// ---------------------------------------------------- utils ---------------------------------------------------- //
	public TbTypeDocument getTypeDocumentById(Integer id) {
		return this.typeDocumentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tipo de documento", "id", id));
	}
	
	public void verifyNameUnique(String name) {
		Boolean existName = this.typeDocumentRepository.existsByName(name);
		if(existName) {
			throw new StandarException(HttpStatus.BAD_REQUEST, "El nombre '" + name + "' ya existe!");
		}
	}
	
	public void verifyNameUnique(String name, String nameCurrent) {
		Boolean existName = this.typeDocumentRepository.existsByName(name);
		Boolean diferentNameCurrent = (!name.equalsIgnoreCase(nameCurrent));
		if(existName && diferentNameCurrent) {
			throw new StandarException(HttpStatus.BAD_REQUEST, "El nombre '" + name + "' ya existe!");
		}
	}
	
	public void verifyCodeUnique(String code) {
		Boolean existCode = this.typeDocumentRepository.existsByCode(code);
		if(existCode) {
			throw new StandarException(HttpStatus.BAD_REQUEST, "El código '" + code + "' ya existe!");
		}
	}
	
	public void verifyCodeUnique(String code, String codeCurrent) {
		Boolean existCode = this.typeDocumentRepository.existsByCode(code);
		Boolean diferentCodeCurrent = (!code.equalsIgnoreCase(codeCurrent));
		if(existCode && diferentCodeCurrent) {
			throw new StandarException(HttpStatus.BAD_REQUEST, "El código '" + code + "' ya existe!");
		}
	}

}