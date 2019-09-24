package com.example.lab02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab02Application {
	
	@Bean
	public FilterRegistrationBean<TokenFilter> filterJwt() {
		FilterRegistrationBean<TokenFilter> filterRB = new FilterRegistrationBean<TokenFilter>();
		filterRB.setFilter(new TokenFilter());
		filterRB.addUrlPatterns( "/auth/usuarios/{email}", "/v1/api/disciplinas/{id}", "/api/disciplinas/likes/{id}", 
				"/api/disciplinas/nota/{id}", "/api/disciplinas/comentarios/{id}");
		return filterRB;
	}

	public static void main(String[] args) {
		SpringApplication.run(Lab02Application.class, args);
	}

}
