package br.com.alura.unicommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.unicommerce.modelo.DadosCadastraUsuario;
import br.com.alura.unicommerce.modelo.Usuario;
import br.com.alura.unicommerce.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;

	@PostMapping
	@Transactional
    public ResponseEntity<Object> cadastrar(@RequestBody @Valid DadosCadastraUsuario dados, BindingResult result) {	
		
	if (result.hasErrors()) ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		
		repository.save(new Usuario(dados));
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
}
