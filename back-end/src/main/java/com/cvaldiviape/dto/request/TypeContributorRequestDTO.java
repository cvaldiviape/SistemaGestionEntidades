package com.cvaldiviape.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
public class TypeContributorRequestDTO {

	@NotNull(message = "El campo 'nombre' no debe ser null.")
	@NotBlank(message = "El campo 'nombre' es obligatorio.")
	@Size(max = 50, message = "El campo 'nombre' debe contener un maximo de 50 caracteres.")
	@Pattern(regexp= "^[a-zA-ZÀ-ÿ]+(\s?[a-zA-ZÀ-ÿ]+?)+$", message = "El campo 'nombre' solo admite letras." )
	private String name;
	
}