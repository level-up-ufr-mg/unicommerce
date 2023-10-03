package br.com.alura.util.infra.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.alura.util.domain.produto.DadosCadastroProdutoDTO;
import br.com.alura.util. infra.filter.SecurityFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
 
	@Autowired
	private SecurityFilter securityFilter;
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    return http.csrf().disable()
	            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	            .and().authorizeHttpRequests()
	            .requestMatchers(HttpMethod.POST, "/login").permitAll() 
	            .requestMatchers(HttpMethod.GET,"/api/produto").permitAll()
	            .requestMatchers(HttpMethod.GET,"/api/categoria/lista").permitAll()
	            .requestMatchers("/v3/api-docs/**" , "/swagger-ui.html" , "/swagger-ui/**").permitAll()
	            .anyRequest().authenticated()
	            .and().addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
	}
	
 
	
	

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
 
	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
