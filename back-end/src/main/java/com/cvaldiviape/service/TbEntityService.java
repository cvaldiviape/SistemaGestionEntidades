package com.cvaldiviape.service;

import com.cvaldiviape.dto.request.EntityRequestDTO;
import com.cvaldiviape.dto.response.EntityResponseDTO;
import com.cvaldiviape.dto.response.page.PageBase;
import com.cvaldiviape.service.base.BaseService;

public interface TbEntityService extends BaseService<PageBase<EntityResponseDTO>, EntityResponseDTO, EntityRequestDTO, Integer> {

}