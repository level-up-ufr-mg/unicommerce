package br.com.alura.unicommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.unicommerce.infra.security.TokenService;
import br.com.alura.unicommerce.modelo.Usuario;
import br.com.alura.unicommerce.record.DadosAutenticacao;
import br.com.alura.unicommerce.record.DadosTokenJwt;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenService;
	
	
	
	@PostMapping
	public ResponseEntity<Object> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
		var AuthenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
		var authentication = manager.authenticate(AuthenticationToken);
		var tokenJwt = tokenService.gerarToken((Usuario)authentication.getPrincipal());
		return ResponseEntity.ok(new DadosTokenJwt(tokenJwt));

	}
}
