package com.cvaldiviape.dto.response;

import java.util.List;
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
public class ErrorMainValidateResponseDTO {

	private String timestamp;
	private List<ErrorValidateResponseDTO> errorsValidate;
	private String detail;
	
}