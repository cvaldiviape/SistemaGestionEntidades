package com.cvaldiviape;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableTransactionManagement
public class A010PruebaTecnicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(A010PruebaTecnicaApplication.class, args);	
	}
	
}