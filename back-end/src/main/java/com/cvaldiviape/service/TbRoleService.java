package com.cvaldiviape.service;

import com.cvaldiviape.dto.request.RoleRequestDTO;
import com.cvaldiviape.dto.response.RoleResponseDTO;
import com.cvaldiviape.dto.response.page.PageBase;
import com.cvaldiviape.service.base.BaseService;

public interface TbRoleService extends BaseService<PageBase<RoleResponseDTO>, RoleResponseDTO, RoleRequestDTO, Integer> {

}
