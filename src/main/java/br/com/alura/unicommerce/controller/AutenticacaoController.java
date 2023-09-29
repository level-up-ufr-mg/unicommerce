package br.com.alura.unicommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.unicommerce.dto.DadosTokenJWT;
import br.com.alura.unicommerce.dto.DdadosAutenticacao;
import br.com.alura.unicommerce.modelo.Usuario;
import br.com.alura.unicommerce.security.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/login")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity efetuarLogin(@RequestBody @Valid DdadosAutenticacao dados) {
		
		var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		var  authentication = manager.authenticate(authenticationToken);
		
		var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
		
		return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
		
	}
	
}
