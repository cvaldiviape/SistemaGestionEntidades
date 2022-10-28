package com.cvaldiviape.dto.request;

import javax.validation.constraints.Min;
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
public class EntityRequestDTO {

	@NotNull(message = "El campo 'nroDocument' no debe ser null.")
	@NotBlank(message = "El campo 'nroDocument' es obligatorio.")
	@Size(min = 8, max = 8, message = "El campo 'nroDocument' debe contener 8 números.")
	@Pattern(regexp= "^[0-9]+$", message = "El campo 'nroDocument' solo admite números.")
	private String nroDocument;
	@NotNull(message = "El campo 'companyName' no debe ser null.")
	@NotBlank(message = "El campo 'companyName' es obligatorio.")
	@Size(max = 20, message = "El campo 'companyName' debe contener un maximo de 20 caracteres.")
	@Pattern(regexp= "^[a-zA-ZÀ-ÿ]+(\s?[a-zA-ZÀ-ÿ]+?)+$", message = "El campo 'companyName' solo admite letras.")
	private String companyName;
	@NotNull(message = "El campo 'commercialName' no debe ser null.")
	@NotBlank(message = "El campo 'commercialName' es obligatorio.")
	@Size(max = 20, message = "El campo 'commercialName' debe contener un maximo de 20 caracteres.")
	@Pattern(regexp= "^[a-zA-ZÀ-ÿ]+(\s?[a-zA-ZÀ-ÿ]+?)+$", message = "El campo 'commercialName' solo admite letras.")
	private String commercialName;
	@NotNull(message = "El campo 'address' no debe ser null.")
	@NotBlank(message = "El campo 'address' es obligatorio.")
	@Size(max = 50, message = "El description 'address' debe contener un maximo de 50 caracteres.")
	@Pattern(regexp= "^[a-zA-ZÀ-ÿ0-9¿?,.!¡:\\-\\#$\\(\\)]+(\\s?[a-zA-ZÀ-ÿ0-9¿?,.!¡:\\-\\#$\\(\\)]+?)+$", message = "El campo 'address' no admite caracteres extraños.")
	private String address;
	@NotNull(message = "El campo 'phone' no debe ser null.")
	@NotBlank(message = "El campo 'phone' es obligatorio.")
	@Size(max = 20, message = "El campo 'phone' debe contener un maximo de 20 caracteres.")
	@Pattern(regexp= "^[0-9]+$", message = "El campo 'phone' solo admite números." )
	private String phone;
	@NotNull(message = "El campo 'typeContributorId' no debe ser null.")
	@Min(value = 1, message = "El campo 'typeContributorId' debe contener un número mayor a '0'")
	private Integer typeContributorId;
	@NotNull(message = "El campo 'typeDocumentId' no debe ser null.")
	@Min(value = 1, message = "El campo 'typeContributorId' debe contener un número mayor a '0'")
	private Integer typeDocumentId;
	
}