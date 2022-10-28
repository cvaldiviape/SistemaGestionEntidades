package com.cvaldiviape.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppSettingProperties {

	@Value("${app.jwt-expiration-milliseconds}")
	public Integer JWT_EXPIRATION_IN_MLS;
	@Value("${app.jwt-type}")
	public String JWT_TYPE;
	@Value("${app.jwt-secret}")
	public String JWT_SECRET;
	
}