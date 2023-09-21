package br.com.alura.unicommerce.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.alura.unicommerce.dto.ClienteDTO;
import br.com.alura.unicommerce.dto.DadosListagemCliente;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.service.ClienteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

	@Autowired
	ClienteService service;

	@PostMapping
	@Transactional
	public ResponseEntity<Object> inserirCliente(@RequestBody @Valid Cliente cliente) {
		System.out.println(cliente);
		service.inserirCliente(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente).toUri();
		return ResponseEntity.created(uri).body(cliente);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> buscaClientePorId(@PathVariable("id") Long clienteId) {

		if (clienteId == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

		Optional<Cliente> cliente = service.buscaPorId(clienteId);

		if (cliente.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

		return ResponseEntity.status(HttpStatus.OK).body(new ClienteDTO(cliente.get()));
	}

	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<Cliente> update(@PathVariable("id") Long clienteId, @RequestBody Cliente cliente) {
		cliente = service.update(clienteId, cliente);
		return ResponseEntity.ok().body(cliente);
	}

	@DeleteMapping(value = "/{clienteId}")
	public ResponseEntity<ClienteDTO> delete(@PathVariable Long clienteId) {
		service.delete(clienteId);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<Page<DadosListagemCliente>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		Page<DadosListagemCliente> list = service.findAllPaged(pageRequest);

		return ResponseEntity.ok().body(list);
	}

}
