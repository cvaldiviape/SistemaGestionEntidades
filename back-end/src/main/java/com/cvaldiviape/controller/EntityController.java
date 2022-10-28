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
import com.cvaldiviape.dto.request.EntityRequestDTO;
import com.cvaldiviape.dto.response.EntityResponseDTO;
import com.cvaldiviape.dto.response.MainResponse;
import com.cvaldiviape.dto.response.page.PageBase;
import com.cvaldiviape.service.TbEntityService;
import com.cvaldiviape.util.AppConstants;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("entity")
public class EntityController {

	@Autowired
	private TbEntityService entityService;
	
	// ---------------------------------------------------------- controllers ----------------------------------------------------------- //
	@ApiOperation("Esta operación se encarga de listar a todas las entidades.")
	@PreAuthorize("hasRole('ADMIN')") 
	@GetMapping
	public ResponseEntity<MainResponse> getAll(@RequestParam(value = "numberPage", defaultValue = AppConstants.NUM_PAGE_DEFAULT, required = false) int numberPage,
	      									   @RequestParam(value = "sizePage", defaultValue = AppConstants.SIZE_PAGE_DEFAULT, required = false) int sizePage,
	      									   @RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY_DEFAULT, required = false) String sortBy,
	      									   @RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR_DEFAULT, required = false) String sortDir){
		PageBase<EntityResponseDTO> listDTO = this.entityService.getAll(numberPage, sizePage, sortBy, sortDir);
		MainResponse mainResponse = new MainResponse(true, "Lista de entidades.", listDTO);
		return new ResponseEntity<MainResponse>(mainResponse, HttpStatus.OK);
	}
	
	@ApiOperation("Esta operación se encarga de obtener los datos de una entidad en base a su ID.")
	@PreAuthorize("hasRole('ADMIN')") 
	@GetMapping("/{entity_id}")
	public ResponseEntity<MainResponse> getById(@PathVariable (name = "entity_id") int entityId){
		EntityResponseDTO dataDTO = this.entityService.getById(entityId);
		MainResponse mainResponse = new MainResponse(true, "Obteniendo entidad por ID.", dataDTO);
		return new ResponseEntity<MainResponse>(mainResponse, HttpStatus.OK);
	}

	@ApiOperation("Esta operación se encarga de crear una nueva entidad.")
	@PreAuthorize("hasRole('ADMIN')") 
	@PostMapping
	public ResponseEntity<MainResponse> create(@Valid @RequestBody EntityRequestDTO requestDTO){
		EntityResponseDTO dataDTO = this.entityService.create(requestDTO); 
		MainResponse mainResponse = new MainResponse(true, "La entidad ha sido creada exitosamente!", dataDTO);
		return new ResponseEntity<MainResponse>(mainResponse, HttpStatus.OK);
	}

	@ApiOperation("Esta operación se encarga de actualizar los datos de una entidad en base a su ID.")
	@PreAuthorize("hasRole('ADMIN')") 
	@PutMapping("/{entity_id}")
	public ResponseEntity<MainResponse> update(@PathVariable (name = "entity_id") int entityId, 
											   @Valid @RequestBody EntityRequestDTO requestDTO ){
		EntityResponseDTO dataDTO = this.entityService.update(entityId, requestDTO); 
		MainResponse mainResponse = new MainResponse(true, "La entidad ha sido actualizada exitosamente!", dataDTO);
		return new ResponseEntity<MainResponse>(mainResponse, HttpStatus.OK);
	}

	@ApiOperation("Esta operación se encarga de eliminar una entidad en base a su ID.")
	@PreAuthorize("hasRole('ADMIN')") 
	@DeleteMapping("/{entity_id}")
	public ResponseEntity<MainResponse> delete(@PathVariable (name = "entity_id") int entityId){
		EntityResponseDTO dataDTO = this.entityService.delete(entityId);
		MainResponse mainResponse = new MainResponse(true, "La entidad ha sido eliminada exitosamente!", dataDTO);
		return new ResponseEntity<MainResponse>(mainResponse, HttpStatus.OK);
	}
	
}