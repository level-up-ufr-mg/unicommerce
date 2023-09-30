package br.com.alura.unicommerce.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
	
	@Autowired
	private SecutityFilter securityFilter;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable())
				.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeRequests(authorize -> authorize.antMatchers(HttpMethod.POST, "/login").permitAll() //usa o método post
				.antMatchers("/swagger-ui.html/", "/v3/api-docs/**", "/swagger-ui/**").permitAll()//não usam métodos HTTP
				.anyRequest().authenticated()
				.and().addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class))
				.build();
	}

	@Bean // Serve para Ensinar o Spring a criar o objeto para ser injetado
	AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	@Bean // Configuração para que o Spring use o algoritmo BCrypt
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
