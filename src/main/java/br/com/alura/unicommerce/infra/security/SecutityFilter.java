package br.com.alura.unicommerce.infra.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class SecutityFilter extends OncePerRequestFilter {

	@Autowired
	private TokenService tokenService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		var tokenJwt = recuperarToken(request); // Recupera o token do cabeçalho
		
		if(tokenJwt != null) {
			var subject = tokenService.getSubject(tokenJwt); // Valida o token e recupera o subjetc (Login)
		}

		// Para continuar o fluxo da requisição e chamar os próximos filtros
		filterChain.doFilter(request, response);
	}

	// Passa o request e recebe a String do token
	private String recuperarToken(HttpServletRequest request) {
		var authorizationHeader = request.getHeader("Authorization"); // nome do cabeçalho
		if (authorizationHeader != null) {
			return authorizationHeader.replace("Bearer ", ""); // Imprimi apenas o prefixo
		}
		return null;

	}
}
