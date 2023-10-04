package br.com.alura.unicommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.record.DadosCadastroPedido;
import br.com.alura.unicommerce.service.ClienteService;
import br.com.alura.unicommerce.service.PedidoService;
import br.com.alura.unicommerce.service.ProdutoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;


@RestController
@RequestMapping("pedido")
@SecurityRequirement(name = "bearer-key") //configuração OpenApi
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService produtoService;
	

	@PostMapping
	ResponseEntity<Object> cadastrar(@RequestBody @Valid DadosCadastroPedido dados, BindingResult result) {
		
		System.out.println(dados);
		
		if(result.hasErrors())
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		
		Pedido novoPedido = dados.converter(clienteService, produtoService); //convert as recordsp
		service.cadastra(novoPedido);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
