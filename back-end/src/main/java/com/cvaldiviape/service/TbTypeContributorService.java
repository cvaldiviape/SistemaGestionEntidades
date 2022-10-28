package com.cvaldiviape.service;

import com.cvaldiviape.dto.request.TypeContributorRequestDTO;
import com.cvaldiviape.dto.response.TypeContributorResponseDTO;
import com.cvaldiviape.dto.response.page.PageBase;
import com.cvaldiviape.service.base.BaseService;

public interface TbTypeContributorService extends BaseService<PageBase<TypeContributorResponseDTO>, TypeContributorResponseDTO, TypeContributorRequestDTO, Integer> {

}