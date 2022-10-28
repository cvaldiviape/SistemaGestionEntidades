package com.cvaldiviape.service;

import com.cvaldiviape.dto.request.AuthRequestDTO;
import com.cvaldiviape.dto.request.UserRequestDTO;
import com.cvaldiviape.dto.request.TokenRequestDTO;
import com.cvaldiviape.dto.response.AuthResponseDTO;
import com.cvaldiviape.dto.response.UserResponseDTO;
import com.cvaldiviape.dto.response.page.PageBase;
import com.cvaldiviape.service.base.BaseService;

public interface TbUserService extends BaseService<PageBase<UserResponseDTO>, UserResponseDTO, UserRequestDTO, Integer> {

	public AuthResponseDTO login(AuthRequestDTO authRequestDTO);

	public String refreshToken(TokenRequestDTO tokenRequestDTO);
	
}