package com.cvaldiviape.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.cvaldiviape.entity.TbRole;
import com.cvaldiviape.entity.TbUser;
import com.cvaldiviape.repository.TbUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private TbUserRepository userRepository;

	// este metodo veririficara la existencia de un usuario en base a su "username" o "correo" para posteriormente retornar al usuario y 
	// sus roles en caso existiera. (este metodo lo uso en la clase "JwtAuthenticationFilter")
 	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 	    TbUser user = this.userRepository.findByUsername(username)
 				.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el 'username': " + username));
 	    return new User(user.getUsername(), user.getPassword(), this.mapperRoles(user.getRoles()));
 	}
 	
 	private Collection<? extends GrantedAuthority> mapperRoles(Set<TbRole> roles){
 		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
 	}

}