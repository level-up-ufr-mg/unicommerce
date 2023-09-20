package br.com.alura.unicommerce.controller;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.record.DadosCadastroCliente;
import br.com.alura.unicommerce.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@PostMapping ("/clienteTeste")
	private String method() {
		System.out.println("Hellooo world!!");
		return "Hellow World!!!!";
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Object> cadastrar(@RequestBody @Valid DadosCadastroCliente dados, BindingResult result){

		if(result.hasErrors()) {
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		clienteRepository.save(new Cliente(dados));
		
		return new ResponseEntity<>(HttpStatus.OK);

	}
}
