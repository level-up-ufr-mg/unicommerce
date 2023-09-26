package br.com.alura.util.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.util.Domain.Usuario.CadastroUsuarioDto;
import br.com.alura.util.Domain.Usuario.Usuario;
import br.com.alura.util.Infra.Security.DadosTokenJWT;
import br.com.alura.util.Infra.Security.TokenServices;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoControle {
	
	@Autowired	
	private AuthenticationManager manager;
	
	@Autowired
	private TokenServices services;
	
	
	@PostMapping
	public ResponseEntity<Object> EfetuarLogin(@RequestBody @Valid CadastroUsuarioDto dados){
		
		var tokenAutenticado = new  UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		
		var authenticatio = manager.authenticate(tokenAutenticado);
		
		var token  = services.gerarToken((Usuario)authenticatio.getPrincipal());
		
		return ResponseEntity.ok(new DadosTokenJWT(token));
	}
	
	 
}
