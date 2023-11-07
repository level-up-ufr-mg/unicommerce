package br.com.alura.unicommerce.Controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.unicommerce.DTO.DadosAtualizaCliente;
import br.com.alura.unicommerce.DTO.DadosCadastroCliente;
import br.com.alura.unicommerce.DTO.DadosDetalhamentoCliente;
import br.com.alura.unicommerce.DTO.DadosListagemCliente;
import br.com.alura.unicommerce.Domain.Cliente.Cliente;
import br.com.alura.unicommerce.Domain.Repository.ClienteRepository;
import br.com.alura.unicommerce.Domain.Repository.UsuarioRepository;
import br.com.alura.unicommerce.Domain.Usuario.Usuario;
import br.com.alura.unicommerce.service.ClienteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@SecurityRequirement(name = "bearer-key")
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private ClienteService service;

	@PostMapping
	@Transactional
	public ResponseEntity<Object> cadastrar(@RequestBody @Valid DadosCadastroCliente dados, BindingResult result,
			UriComponentsBuilder uriBuilder) {

		if (result.hasErrors())
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		Usuario usuarioID = dados.usuario();
		Long usuarioIDLong = usuarioID.getId();
		Usuario dadosUsuarioID = usuarioRepository.getReferenceById(usuarioIDLong);

		Optional<Usuario> object = usuarioRepository.findById(usuarioIDLong);

		if (!object.isEmpty()) {
			Cliente cliente = new Cliente(dados, dadosUsuarioID);
			service.create(cliente);

			URI uri = uriBuilder.path("/api/clientes/{id}").buildAndExpand(cliente.getId()).toUri();

			return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));
		}
		return null;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity excluir(@PathVariable Long id) {
		Cliente cliente = repository.getReferenceById(id);
		return ResponseEntity.noContent().build();
	}

	@PutExchange
	@Transactional
	public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaCliente dados) {
		Cliente cliente = repository.getReferenceById(dados.id());
		return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
	}

	@GetMapping
	public Page<DadosListagemCliente> listar(@PageableDefault(size = 5, sort = { "nome" }) Pageable paginacao) {
		Page page = repository.findAll(paginacao).map(DadosListagemCliente::new);
		return repository.findAll(paginacao).map(DadosListagemCliente::new);
	}
}
