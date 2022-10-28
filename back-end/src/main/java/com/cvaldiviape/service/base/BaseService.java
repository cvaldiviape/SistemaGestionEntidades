package com.cvaldiviape.service.base;

public interface BaseService <PAGEABLE, ResponseDTO, RequestDTO, ID> {

	public PAGEABLE getAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir);
	
	public ResponseDTO getById(ID id);
	
	public ResponseDTO create(RequestDTO requestDTO);
	
	public ResponseDTO update(ID id, RequestDTO requestDTO);
	
	public ResponseDTO delete(ID id);

}