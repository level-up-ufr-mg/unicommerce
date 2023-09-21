package br.com.alura.unicommerce.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.alura.unicommerce.modelo.Pedido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class PedidoDTO{
		
	private Long id;
	
	private LocalDate data;
	
	private BigDecimal valor;
	
    @NotNull @Valid 
    private ClienteDTO cliente;
    
    private Long clienteId;
    
    private String nomeCliente;
    
    
    @NotNull @Valid 
    private ProdutoDTO produto;

	public PedidoDTO(Pedido obj) {
		this.id = obj.getId();
		this.data = obj.getData();
		this.cliente = new ClienteDTO(obj.getCliente());
		this.clienteId = new ClienteDTO(obj.getCliente()).getId();
		this.nomeCliente = new ClienteDTO(obj.getCliente()).getNome();
		//this.produto = new ProdutoDTO(obj.getProduto());
	}

	public Long getId() {
		return id;
	}

	public LocalDate getData() {
		return data;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	
}
