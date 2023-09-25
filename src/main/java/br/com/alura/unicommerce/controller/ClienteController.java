package br.com.alura.unicommerce.controller;

import java.net.URI;
import java.security.cert.URICertStoreParameters;
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

import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.modelo.Usuario;
import br.com.alura.unicommerce.dto.DadosAtualizaCliente;
import br.com.alura.unicommerce.dto.DadosCadastraCliente;
import br.com.alura.unicommerce.dto.DadosDetalhamentoCliente;
import br.com.alura.unicommerce.dto.DadosListagemCliente;
import br.com.alura.unicommerce.repository.ClienteRepository;
import br.com.alura.unicommerce.repository.UsuarioRepository;
import br.com.alura.unicommerce.service.ClienteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ClienteService service;
	
	@Autowired
	private ClienteRepository repository;
	
	
	@PostMapping
	@Transactional
    public ResponseEntity<Object> cadastrar(@RequestBody @Valid DadosCadastraCliente dados, BindingResult result, UriComponentsBuilder uriBuilder) {		
	
		if (result.hasErrors()) ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		
		Usuario usuarioId = dados.usuario();
		
		Long idUsuario = usuarioId.getId();
		
		Usuario dadosIdUsuario = usuarioRepository.getReferenceById(idUsuario);
		
		Optional<Usuario> obj = usuarioRepository.findById(idUsuario);
		
		if (!obj.isEmpty()){	
			
			Cliente cliente = new Cliente(dados, dadosIdUsuario);
			
			service.cadastra(cliente);
			
			URI uri = uriBuilder.path("/api/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
			
			return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));
		}
		return null;
		
		
	
	}
	
	@GetMapping
	//@Secured("ROLE_ADMIN") No exemplo de código anterior o método foi anotado com @Secured("ROLE_ADMIN"), para que apenas usuários com o perfil ADMIN possam disparar requisições para listar clientes para funcionar essa parte precisa ser adicionado a anotação  @EnableMethodSecurity(securedEnabled = true)  na classe Securityconfigurations
	public ResponseEntity<Page<DadosListagemCliente>> listar(@PageableDefault(size = 5, sort = {"nome"})Pageable paginacao){

		 Page page = repository.findAll(paginacao).map(DadosListagemCliente::new);
		return  ResponseEntity.ok(page);
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity excluir (@PathVariable Long id) {
		
		Cliente cliente = repository.getReferenceById(id);
		//metodo para excluir
		
		return ResponseEntity.noContent().build();
		
	}
	
	@PutExchange
	@Transactional
	public ResponseEntity atualizar (@RequestBody @Valid DadosAtualizaCliente dados) {
		
		Cliente cliente = repository.getReferenceById(dados.id());
		//metodo que atualiza
		
		return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
		
	}
	
	
	
}
