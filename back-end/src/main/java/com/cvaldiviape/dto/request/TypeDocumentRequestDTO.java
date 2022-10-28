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
public class TypeDocumentRequestDTO {
	
	@NotNull(message = "El campo 'código' no debe ser null.")
	@NotBlank(message = "El campo 'código' es obligatorio.")
	@Size(max = 20, message = "El campo 'código' debe contener un maximo de 20 caracteres.")
	@Pattern(regexp= "^[a-zA-ZÀ-ÿ0-9]+$", message = "El campo 'código' solo admite letras o números." )
	private String code;
	@NotNull(message = "El campo 'nombre' no debe ser null.")
	@NotBlank(message = "El campo 'nombre' es obligatorio.")
	@Size(max = 100, message = "El campo 'nombre' debe contener un maximo de 100 caracteres.")
	@Pattern(regexp= "^[a-zA-ZÀ-ÿ]+(\s?[a-zA-ZÀ-ÿ]+?)+$", message = "El nombre 'name' solo admite letras." )
	private String name;
	@Size(max = 500, message = "El campos 'descripción' debe contener un maximo de 500 caracteres.")
	@Pattern(regexp= "^[a-zA-ZÀ-ÿ0-9¿?,.\"\'%!¡:\\-\\#$\\(\\)]+(\\s?[a-zA-ZÀ-ÿ0-9¿?,.\"\'%!¡:\\-\\#$\\(\\)]+?)$", message = "El campo 'descripción' no admite caracteres extraños.")
	private String description;
	
}