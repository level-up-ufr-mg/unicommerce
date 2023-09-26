package br.com.alura.util.Infra.Security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.alura.util.Domain.Usuario.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private TokenServices tokenServices;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		var token = recuperarToken(request);

		if (token != null) {
			var subjet = tokenServices.getSubjet(token);
			
			
			var usuario = usuarioRepository.findByLogin(subjet);
			var authentication = new UsernamePasswordAuthenticationToken(usuario, null,usuario.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} 

		filterChain.doFilter(request, response);
	}

	private String recuperarToken(HttpServletRequest request) {
		var authorizationHeader = request.getHeader("Authorization");

		if (authorizationHeader != null) {
			return authorizationHeader.replace("Bearer ", "");
		}

		return null;
	}

}
