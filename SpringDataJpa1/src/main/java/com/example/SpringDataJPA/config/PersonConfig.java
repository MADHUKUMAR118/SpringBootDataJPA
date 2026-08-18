package com.example.SpringDataJPA.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class PersonConfig {
	
	
	
	@Bean
	public PasswordEncoder getEncoder() {
		return new   BCryptPasswordEncoder(12);
	}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)  {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/register","/verify").permitAll()
                .anyRequest().authenticated()
            );

        return http.build();
    }
}