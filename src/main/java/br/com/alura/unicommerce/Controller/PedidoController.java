package br.com.alura.unicommerce.Controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.unicommerce.DTO.DadosCadastraPedido;
import br.com.alura.unicommerce.Domain.Pedido.Pedido;
import br.com.alura.unicommerce.service.ClienteService;
import br.com.alura.unicommerce.service.PedidoService;
import br.com.alura.unicommerce.service.ProdutoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService service;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	@Transactional
	public ResponseEntity<Object> cadastraPedido(@RequestBody @Valid DadosCadastraPedido dadosDePedido,
			UriComponentsBuilder uriBuilder, BindingResult result) {
		
		try {
			if (result.hasErrors())
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

			Pedido novoPedido = dadosDePedido.converter(clienteService, produtoService);
			service.insert(novoPedido);

			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dadosDePedido)
					.toUri();
			return ResponseEntity.created(uri).body(dadosDePedido);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu uma falha no cadastro do pedido");
		}
	}
}