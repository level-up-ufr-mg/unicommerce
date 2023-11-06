package br.com.alura.unicommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.unicommerce.DTO.DadosCadastraCliente;
import br.com.alura.unicommerce.DTO.DadosListagemCliente;
import br.com.alura.unicommerce.Domain.Cliente.Cliente;
import br.com.alura.unicommerce.Domain.Repository.ClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity<Object> cadastrar(@RequestBody @Valid DadosCadastraCliente dados, BindingResult result) {

		if (result.hasErrors())
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		repository.save(new Cliente(dados));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping
	public Page<DadosListagemCliente> listar(@PageableDefault(size = 5, sort = { "nome" }) Pageable paginacao) {

		return repository.findAll(paginacao).map(DadosListagemCliente::new);
	}
}