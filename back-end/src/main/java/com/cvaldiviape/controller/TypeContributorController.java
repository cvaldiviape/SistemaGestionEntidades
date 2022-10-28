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
import com.cvaldiviape.dto.request.TypeContributorRequestDTO;
import com.cvaldiviape.dto.response.MainResponse;
import com.cvaldiviape.dto.response.TypeContributorResponseDTO;
import com.cvaldiviape.dto.response.page.PageBase;
import com.cvaldiviape.service.TbTypeContributorService;
import com.cvaldiviape.util.AppConstants;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("type-contributor")
public class TypeContributorController {
	
	@Autowired
	private TbTypeContributorService typeContributorService;
	
	// ---------------------------------------------------------- controllers ----------------------------------------------------------- //
	@ApiOperation("Esta operación se encarga de listar a todos los tipos de contribuyentes.")
	@PreAuthorize("hasRole('ADMIN')") 
	@GetMapping
	public ResponseEntity<MainResponse> getAll(@RequestParam(value = "numberPage", defaultValue = AppConstants.NUM_PAGE_DEFAULT, required = false) int numberPage,
	      									   @RequestParam(value = "sizePage", defaultValue = AppConstants.SIZE_PAGE_DEFAULT, required = false) int sizePage,
	      									   @RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY_DEFAULT, required = false) String sortBy,
	      									   @RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR_DEFAULT, required = false) String sortDir){
		PageBase<TypeContributorResponseDTO> listDTO = this.typeContributorService.getAll(numberPage, sizePage, sortBy, sortDir);
		MainResponse mainResponse = new MainResponse(true, "Lista de tipos de contribuyentes.", listDTO);
		return new ResponseEntity<MainResponse>(mainResponse, HttpStatus.OK);
	}
	
	@ApiOperation("Esta operación se encarga de obtener los datos de un tipo de contribuyente en base a su ID.")
	@PreAuthorize("hasRole('ADMIN')") 
	@GetMapping("/{type_contributor_id}")
	public ResponseEntity<MainResponse> getById(@PathVariable (name = "type_contributor_id") int typeContributorId){
		TypeContributorResponseDTO dataDTO = this.typeContributorService.getById(typeContributorId);
		MainResponse mainResponse = new MainResponse(true, "Obteniendo tipo de contribuyente por ID.", dataDTO);
		return new ResponseEntity<MainResponse>(mainResponse, HttpStatus.OK);
	}

	@ApiOperation("Esta operación se encarga de crear una nuevo tipo de contribuyente.")
	@PreAuthorize("hasRole('ADMIN')") 
	@PostMapping
	public ResponseEntity<MainResponse> create(@Valid @RequestBody TypeContributorRequestDTO requestDTO){
		TypeContributorResponseDTO dataDTO = this.typeContributorService.create(requestDTO); 
		MainResponse mainResponse = new MainResponse(true, "El tipo de contribuyente ha sido creado exitosamente!", dataDTO);
		return new ResponseEntity<MainResponse>(mainResponse, HttpStatus.OK);
	}

	@ApiOperation("Esta operación se encarga de actualizar los datos de un tipo de contribuyente en base a su ID.")
	@PreAuthorize("hasRole('ADMIN')") 
	@PutMapping("/{type_contributor_id}")
	public ResponseEntity<MainResponse> update(@PathVariable (name = "type_contributor_id") int typeContributorId, 
											   @Valid @RequestBody TypeContributorRequestDTO requestDTO ){
		TypeContributorResponseDTO dataDTO = this.typeContributorService.update(typeContributorId, requestDTO); 
		MainResponse mainResponse = new MainResponse(true, "El tipo de contribuyente ha sido actualizado exitosamente!", dataDTO);
		return new ResponseEntity<MainResponse>(mainResponse, HttpStatus.OK);
	}

	@ApiOperation("Esta operación se encarga de eliminar un tipo de contribuyente en base a su ID.")
	@PreAuthorize("hasRole('ADMIN')") 
	@DeleteMapping("/{type_contributor_id}")
	public ResponseEntity<MainResponse> delete(@PathVariable (name = "type_contributor_id") int typeContributorId){
		TypeContributorResponseDTO dataDTO = this.typeContributorService.delete(typeContributorId);
		MainResponse mainResponse = new MainResponse(true, "El tipo de contribuyente ha sido eliminado exitosamente!", dataDTO);
		return new ResponseEntity<MainResponse>(mainResponse, HttpStatus.OK);
	}
	
}