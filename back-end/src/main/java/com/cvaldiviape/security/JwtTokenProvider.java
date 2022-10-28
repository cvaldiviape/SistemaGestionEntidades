package com.cvaldiviape.security;

import java.text.ParseException;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import com.cvaldiviape.dto.request.AuthRequestDTO;
import com.cvaldiviape.exception.StandarException;
import com.cvaldiviape.util.AppSettingProperties;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component // "JwtTokenProvider" este clase se va encargar de generar el TOKEN, obtener los CLAIMS, validar el TOKEN.
public class JwtTokenProvider {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private AppSettingProperties appSettingProperties;

	public String generateToken(Authentication authentication) {
		String username = authentication.getName();
		
		Date dateCurrent = new Date();
		Date dateExpired = new Date(dateCurrent.getTime() + this.appSettingProperties.JWT_EXPIRATION_IN_MLS);
		String token = Jwts.builder()
							.setSubject(username)
							.setIssuedAt(new Date())
							.setExpiration(dateExpired)
							.signWith(SignatureAlgorithm.HS512, this.appSettingProperties.JWT_SECRET)
							.compact();	
		return token;
	}
	
	public String getUsernameOfToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.appSettingProperties.JWT_SECRET).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(this.appSettingProperties.JWT_SECRET).parseClaimsJws(token);
			return true;
		}catch (Exception ex) {
			return false;
		}
	}
	
	public Optional<String> getToken(AuthRequestDTO authRequestDTO) {
		Authentication authentication = this.authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(
						authRequestDTO.getUsername(), 
						authRequestDTO.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return Optional.ofNullable(this.generateToken(authentication));
	}
	
	public Optional<String> refreshToken(String token) {
		String tokenRefresed = null;
		try {
			JWT jwt = JWTParser.parse(token);
			JWTClaimsSet claims = jwt.getJWTClaimsSet();
	        String username = claims.getSubject();
	        Date fechaActual = new Date();
			Date fechaExpiracion = new Date(fechaActual.getTime() + this.appSettingProperties.JWT_EXPIRATION_IN_MLS);
	      
	        tokenRefresed = Jwts.builder()
				                .setSubject(username)
				                .setIssuedAt(new Date())
				                .setExpiration(fechaExpiracion)
								.signWith(SignatureAlgorithm.HS512, this.appSettingProperties.JWT_SECRET)
								.compact();
		} catch (ParseException e) {
			throw new StandarException(HttpStatus.BAD_REQUEST,"Token no valido.");
		}
		return Optional.ofNullable(tokenRefresed);      
	}
	
}