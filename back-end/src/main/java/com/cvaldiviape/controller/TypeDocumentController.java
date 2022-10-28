package com.cvaldiviape.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cvaldiviape.dto.request.TypeDocumentRequestDTO;
import com.cvaldiviape.dto.response.MainResponse;
import com.cvaldiviape.dto.response.TypeDocumentResponseDTO;
import com.cvaldiviape.dto.response.page.PageBase;
import com.cvaldiviape.service.TbTypeDocumentService;
import com.cvaldiviape.util.AppConstants;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("type-document")
public class TypeDocumentController {

	@Autowired
	private TbTypeDocumentService typeDocumentService;
	
	// ---------------------------------------------------------- controllers ----------------------------------------------------------- //
	@ApiOperation("Esta operación se encarga de listar a todos los tipos de documentos.")
	@PreAuthorize("hasRole('ADMIN')") 
	@GetMapping
	public ResponseEntity<MainResponse> getAll(@RequestParam(value = "numberPage", defaultValue = AppConstants.NUM_PAGE_DEFAULT, required = false) int numberPage,
	      									   @RequestParam(value = "sizePage", defaultValue = AppConstants.SIZE_PAGE_DEFAULT, required = false) int sizePage,
	      									   @RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY_DEFAULT, required = false) String sortBy,
	      									   @RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR_DEFAULT, required = false) String sortDir){
		PageBase<TypeDocumentResponseDTO> listDTO = this.typeDocumentService.getAll(numberPage, sizePage, sortBy, sortDir);
		MainResponse mainResponse = new MainResponse(true, "Lista de tipos de documentos.", listDTO);
		return new ResponseEntity<MainResponse>(mainResponse, HttpStatus.OK);
	}
	
	@ApiOperation("Esta operación se encarga de obtener los datos de un tipo de documento en base a su ID.")
	@PreAuthorize("hasRole('ADMIN')") 
	@GetMapping("/{type_document_id}")
	public ResponseEntity<MainResponse> getById(@PathVariable (name = "type_document_id") int typeDocumentId){
		TypeDocumentResponseDTO dataDTO = this.typeDocumentService.getById(typeDocumentId);
		MainResponse mainResponse = new MainResponse(true, "Obteniendo tipo de documento por ID.", dataDTO);
		return new ResponseEntity<MainResponse>(mainResponse, HttpStatus.OK);
	}

	@ApiOperation("Esta operación se encarga de crear una nuevo tipo de documento.")
	@PreAuthorize("hasRole('ADMIN')") 
	@PostMapping
	public ResponseEntity<MainResponse> create(@Valid @RequestBody TypeDocumentRequestDTO requestDTO){
		TypeDocumentResponseDTO dataDTO = this.typeDocumentService.create(requestDTO); 
		MainResponse mainResponse = new MainResponse(true, "El tipo de documento ha sido creado exitosamente!", dataDTO);
		return new ResponseEntity<MainResponse>(mainResponse, HttpStatus.OK);
	}

	@ApiOperation("Esta operación se encarga de actualizar los datos de un tipo de documenento en base a su ID.")
	@PreAuthorize("hasRole('ADMIN')") 
	@PutMapping("/{type_document_id}")
	public ResponseEntity<MainResponse> update(@PathVariable (name = "type_document_id") int typeDocumentId, 
											   @Valid @RequestBody TypeDocumentRequestDTO requestDTO ){
		TypeDocumentResponseDTO dataDTO = this.typeDocumentService.update(typeDocumentId, requestDTO); 
		MainResponse mainResponse = new MainResponse(true, "El tipo de documento ha sido actualizado exitosamente!", dataDTO);
		return new ResponseEntity<MainResponse>(mainResponse, HttpStatus.OK);
	}

	@ApiOperation("Esta operación se encarga de eliminar un tipo de documento en base a su ID.")
	@PreAuthorize("hasRole('ADMIN')") 
	@DeleteMapping("/{type_document_id}")
	public ResponseEntity<MainResponse> delete(@PathVariable (name = "type_document_id") int typeDocumentId){
		TypeDocumentResponseDTO dataDTO = this.typeDocumentService.delete(typeDocumentId);
		MainResponse mainResponse = new MainResponse(true, "El tipo de documento ha sido eliminado exitosamente!", dataDTO);
		return new ResponseEntity<MainResponse>(mainResponse, HttpStatus.OK);
	}
	
}