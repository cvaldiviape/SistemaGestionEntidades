package com.cvaldiviape.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cvaldiviape.dto.request.RoleRequestDTO;
import com.cvaldiviape.dto.response.RoleResponseDTO;
import com.cvaldiviape.dto.response.page.PageBase;
import com.cvaldiviape.entity.TbRole;
import com.cvaldiviape.exception.ResourceNotFoundException;
import com.cvaldiviape.mapper.TbRoleMapper;
import com.cvaldiviape.repository.TbRoleRepository;
import com.cvaldiviape.service.TbRoleService;

@Service
@Transactional
public class TbRoleServiceImpl implements TbRoleService {

	@Autowired
	private TbRoleRepository roleRepository;
	@Autowired
	private TbRoleMapper roleMapper;
	
	// ---------------------------------------------------- services ---------------------------------------------------- //
	@Override
	public PageBase<RoleResponseDTO> getAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleResponseDTO getById(Integer id) {
		// TODO Auto-generated method stub
		TbRole entity = this.getRoleById(id);
		return this.roleMapper.mapEntityToResponseDTO(entity);
	}

	@Override
	public RoleResponseDTO create(RoleRequestDTO requestDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleResponseDTO update(Integer id, RoleRequestDTO requestDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleResponseDTO delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// ----------------------------------------------------------- utils ----------------------------------------------------------- //
	public TbRole getRoleById(Integer id) {
		return this.roleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Rol", "id", id));
	}
		
}