package br.com.alura.unicommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.unicommerce.modelo.DadosCadastraPedido;
import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.repository.PedidoRepository;
import br.com.alura.unicommerce.service.ClienteService;
import br.com.alura.unicommerce.service.PedidoService;
import br.com.alura.unicommerce.service.ProdutoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
	
	
	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private PedidoService service;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	@Transactional
    public  ResponseEntity<Object> cadastrar(@RequestBody @Valid DadosCadastraPedido dados, BindingResult result) {
		
		if (result.hasErrors()) ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		
		Pedido novoPedido = dados.converter(clienteService, produtoService);
		
		service.cadastra(novoPedido);
		
		//repository.save(novoPedido);
	
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	

}
