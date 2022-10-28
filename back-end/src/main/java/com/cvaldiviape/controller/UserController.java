package com.cvaldiviape.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cvaldiviape.dto.request.AuthRequestDTO;
import com.cvaldiviape.dto.request.TokenRequestDTO;
import com.cvaldiviape.dto.request.UserRequestDTO;
import com.cvaldiviape.dto.response.AuthResponseDTO;
import com.cvaldiviape.dto.response.MainResponse;
import com.cvaldiviape.dto.response.UserResponseDTO;
import com.cvaldiviape.service.TbUserService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private TbUserService userService;

	// ---------------------------------------------------------- controllers ----------------------------------------------------------- //
	@ApiOperation("Esta operación se encarga de la autenticación del usuario.")
	@PostMapping("/login")
	public ResponseEntity<MainResponse> login(@Valid @RequestBody AuthRequestDTO authRequestDTO) {
		AuthResponseDTO  authDataDTO = this.userService.login(authRequestDTO);
		MainResponse mainResponse = new MainResponse(true, "El usuario se ha autenticado exitosamente!", authDataDTO);
		return new ResponseEntity<MainResponse>(mainResponse, HttpStatus.OK);
	}

	@ApiOperation("Esta operación se encarga de verificar que el token se encuentre vigente.")
	@PostMapping("/refresh-token")
	public ResponseEntity<MainResponse> refreshToken(@Valid @RequestBody TokenRequestDTO tokenRequestDTO) {
		String tokenRefreshed = this.userService.refreshToken(tokenRequestDTO);
		MainResponse mainResponse = new MainResponse(true, "Token refrescado exitosamente!", tokenRefreshed);
		return new ResponseEntity<MainResponse>(mainResponse, HttpStatus.OK);
	}
	
	@ApiOperation("Esta operación se encarga de crear un nuevo usuario.")
	@PostMapping("/register")
	public ResponseEntity<MainResponse> createUser(@Valid @RequestBody UserRequestDTO requestDTO){
		UserResponseDTO dataDTO = this.userService.create(requestDTO); 
		MainResponse mainResponse = new MainResponse(true, "El usuario ha sido creado exitosamente!", dataDTO);
		return new ResponseEntity<MainResponse>(mainResponse, HttpStatus.OK);	
	}

}