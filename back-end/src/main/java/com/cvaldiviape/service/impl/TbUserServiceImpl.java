package com.cvaldiviape.service.impl;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cvaldiviape.dto.request.AuthRequestDTO;
import com.cvaldiviape.dto.request.TokenRequestDTO;
import com.cvaldiviape.dto.request.UserRequestDTO;
import com.cvaldiviape.dto.response.AuthResponseDTO;
import com.cvaldiviape.dto.response.RoleResponseDTO;
import com.cvaldiviape.dto.response.TokenResponseDTO;
import com.cvaldiviape.dto.response.UserAuthResponseDTO;
import com.cvaldiviape.dto.response.UserResponseDTO;
import com.cvaldiviape.dto.response.page.PageBase;
import com.cvaldiviape.entity.TbRole;
import com.cvaldiviape.entity.TbUser;
import com.cvaldiviape.exception.ResourceNotFoundException;
import com.cvaldiviape.exception.StandarException;
import com.cvaldiviape.mapper.AuthMapper;
import com.cvaldiviape.mapper.TbRoleMapper;
import com.cvaldiviape.mapper.TbUserMapper;
import com.cvaldiviape.repository.TbRoleRepository;
import com.cvaldiviape.repository.TbUserRepository;
import com.cvaldiviape.security.JwtTokenProvider;
import com.cvaldiviape.service.TbUserService;
import com.cvaldiviape.util.AppSettingProperties;

@Service
@Transactional
public class TbUserServiceImpl implements TbUserService {

	@Autowired
	private TbUserRepository userRepository;
	@Autowired
	private TbRoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private AuthMapper authMapper;
	@Autowired
	private TbUserMapper userMapper;
	@Autowired
	private TbRoleMapper roleMapper;
	@Autowired
	private AppSettingProperties appSettingProperties;
	
	// ---------------------------------------------------- services ---------------------------------------------------- //
	@Override
	public PageBase<UserResponseDTO> getAll(Integer numberPage, Integer sizePage, String sortBy, String sortDir) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserResponseDTO getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserResponseDTO create(UserRequestDTO requestDTO) {
		// TODO Auto-generated method stub
		this.verifyUserNameUnique(requestDTO.getUsername());
	
		TbUser user = this.userMapper.mapRequestToEntity(requestDTO);
		user.setPassword(this.passwordEncoder.encode(requestDTO.getPassword())); // encriptando la contraseña
		
		TbRole role = getRoleByIdCustom(1);		
		if(role==null) {
			user.setRoles(addedRoleToList("ROLE_ADMIN"));
		}else {
			user.setRoles(addedRoleToList(role));
		}
		
		UserResponseDTO dataCreated = this.userMapper.mapEntityToResponseDTO(this.userRepository.save(user));		
		return dataCreated;
	}

	@Override
	public UserResponseDTO update(Integer id, UserRequestDTO requestDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserResponseDTO delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthResponseDTO login(AuthRequestDTO authRequestDTO) {
		// TODO Auto-generated method stub
		String username = authRequestDTO.getUsername();
		Integer roleId = 1;

		String token = this.auth(authRequestDTO);
		TbUser userEntity = this.getUserIfExistWithRole(roleId, username);
		TbRole roleEntity = this.getRoleById(roleId);
		
		UserAuthResponseDTO userAuthResponseDTO = this.authMapper.mapEntityToResponse(userEntity);
		RoleResponseDTO roleResponseDTO = this.roleMapper.mapEntityToResponseDTO(roleEntity);
		TokenResponseDTO tokenResponseDTO = new TokenResponseDTO(token, this.appSettingProperties.JWT_TYPE, this.appSettingProperties.JWT_EXPIRATION_IN_MLS);
	
		return AuthResponseDTO.builder()
				.user(userAuthResponseDTO)
				.role(roleResponseDTO)
				.token(tokenResponseDTO)
				.build();			
	}

	@Override
	public String refreshToken(TokenRequestDTO tokenRequestDTO) {
		// TODO Auto-generated method stub
		String tokenRefreshed = this.jwtTokenProvider.refreshToken(tokenRequestDTO.getTokenAccess())
				.orElseThrow(() -> new StandarException(HttpStatus.INTERNAL_SERVER_ERROR, "Bad credentials"));
		return tokenRefreshed;
	}
	
	// ----------------------------------------------------------- utils ----------------------------------------------------------- //
	public String auth(AuthRequestDTO authRequestDTO) {
		return this.jwtTokenProvider.getToken(authRequestDTO)
				.orElseThrow(() -> new StandarException(HttpStatus.INTERNAL_SERVER_ERROR, "Bad credentials"));
	}
	
	public TbRole getRoleById(Integer id) {
		return this.roleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Role", "id", id));
	}
	
	public TbRole getRoleByIdCustom(Integer id) {
		return this.roleRepository.findById(id).orElse(null);
	}
	
	public TbUser getUserIfExistWithRole(Integer roleId, String usernameOrEmail) {
		return this.userRepository.findByUsernameAndRoleId(roleId, usernameOrEmail)
				.orElseThrow(() -> new StandarException(HttpStatus.INTERNAL_SERVER_ERROR, "Bad credentials"));
	}

	public void verifyUserNameUnique(String username) {
		Boolean existUsername = this.userRepository.existsByUsername(username);
		if(existUsername) {
			throw new StandarException(HttpStatus.BAD_REQUEST, "El username " + username + " ya existe.");
		}
	}
	
	public Set<TbRole> addedRoleToList(String nameRole) {
		TbRole role = new TbRole();
		role.setName(nameRole);
		Set<TbRole> roles = new HashSet<>();	
		roles.add(role);
		return roles;
	}
	
	public Set<TbRole> addedRoleToList(TbRole role) {
		Set<TbRole> roles = new HashSet<>();	
		roles.add(role);
		return roles;
	}
	
}