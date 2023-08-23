package br.edu.uniformg.unicommerce.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {

    private Long id;
    private LocalDate data;
    private BigDecimal desconto;
    private TipoDesconto tipoDesconto; 
    private BigDecimal valorTotal;
    private List<ItemPedido> itens = new ArrayList<>(); //sempre vai começar com uma colção vazia
    //FK
    private Cliente clienteId;
    
    public Pedido() {
    	
    }
    
	public Pedido(BigDecimal desconto, TipoDesconto tipoDesconto, Cliente clienteId) {
		this.desconto = desconto;
		this.tipoDesconto = tipoDesconto;
		this.clienteId = clienteId;
	}
	
	public void adicionarItem(ItemPedido itemPedido) {
		itemPedido.setPedidoId(this);
		this.itens.add(itemPedido);
		this.valorTotal = this.valorTotal.add(itemPedido.getValor());

	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
		return id;
	}

	public LocalDate getData() {
		return data;
	}

    @ManyToOne
    @JoinColumn(name = "cliente_id")
	public Cliente getCliente() {
		return clienteId;
	}

    public BigDecimal getDesconto() {
		return desconto;
	}

	@Enumerated(EnumType.STRING)
	public TipoDesconto getTipoDesconto() {
		return tipoDesconto;
	}
	

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getClienteId() {
		return clienteId;
	}



	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public void setTipoDesconto(TipoDesconto tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}
	
	
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", data=" + data + ", desconto=" + desconto + ", cliente=" + clienteId + "]";
	}
}

