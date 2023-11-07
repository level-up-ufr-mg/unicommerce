package br.com.alura.unicommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.unicommerce.DTO.DadosAtualizacao;
import br.com.alura.unicommerce.DTO.DadosTokenJWT;
import br.com.alura.unicommerce.Domain.Usuario.Usuario;
import br.com.alura.unicommerce.Infra.Security.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAtualizacao dados) {
		var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		var authentication = manager.authenticate(authenticationToken);
		var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
		return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
	}
}
