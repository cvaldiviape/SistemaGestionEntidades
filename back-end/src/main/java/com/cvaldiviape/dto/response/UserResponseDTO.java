package com.cvaldiviape.dto.response;

import java.util.Set;
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
public class UserResponseDTO {
	
	private Integer id;
	private String username;
	private Set<RoleResponseDTO> roles;
	
}