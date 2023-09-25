package br.com.alura.unicommerce.security;

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
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	private SecurityFilter securityFilter;
	
	@Bean
    public  DefaultSecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    	
    	return http.csrf().disable().sessionManagement()
    			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    	     		.and().authorizeHttpRequests()
        			.requestMatchers(HttpMethod.POST, "/api/login").permitAll()
			.and().authorizeHttpRequests()
   				.requestMatchers(HttpMethod.GET, "/api/categoria").permitAll()
			.and().authorizeHttpRequests()
    				.requestMatchers(HttpMethod.GET, "/api/produto").permitAll()
    			.anyRequest().authenticated()
    			.and().addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    	
    	//indica ao Spring Security que as requisições do tipo DELETE para as URLs /medicos  somente podem ser executadas por usuários autenticados e cujo perfil de acesso seja ADMIN
    	// .requestMatchers(HttpMethod.DELETE, "/medicos").hasRole("ADMIN")
    	
//    	
//    	    return http.csrf(csrf -> csrf.disable())
//    	            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//    	            .authorizeHttpRequests(req -> {
//    	                req.requestMatchers(HttpMethod.POST, "/login").permitAll();
//    	                req.anyRequest().authenticated();
//    	            })
//    	            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
//    	            .build();
    	

    }
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
}
