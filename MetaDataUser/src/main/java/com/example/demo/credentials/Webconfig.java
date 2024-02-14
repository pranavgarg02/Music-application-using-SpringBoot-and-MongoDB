package com.example.demo.credentials;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Webconfig {
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authz)->authz.requestMatchers("/v1/actuator/**").permitAll());
		http.cors();
		return http.build();
	}
}