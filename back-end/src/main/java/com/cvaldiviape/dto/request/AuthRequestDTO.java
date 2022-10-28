package com.cvaldiviape.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
public class AuthRequestDTO {

	@NotNull(message = "El campo 'username' no debe ser null.")
	@NotBlank(message = "El campo 'username' es obligatorio.")
	private String username;
	@NotNull(message = "El campo 'password' no debe ser null.")
	@NotBlank(message = "El campo 'password' es obligatorio.")
	private String password;
	
}