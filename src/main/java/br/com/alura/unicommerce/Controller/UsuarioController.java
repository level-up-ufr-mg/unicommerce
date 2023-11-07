package br.com.alura.unicommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.unicommerce.DTO.DadosCadastroUsuario;
import br.com.alura.unicommerce.service.AtenticacaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	AtenticacaoService service;

	@PostMapping
	@Transactional
	public ResponseEntity<Object> cadastrar(@RequestBody @Valid DadosCadastroUsuario dados, BindingResult result) {
		if (result.hasErrors())
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		service.cadastra(dados);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}