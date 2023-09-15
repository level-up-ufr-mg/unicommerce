package br.com.alura.unicommerce.modelo;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Cliente cliente;
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	@Column(name = "itens")
	private List<ItemPedido> itens = new ArrayList<>();
	@Column(nullable = false, name = "data")
	private LocalDateTime data;
	@Column(nullable = false, name = "desconto")
	private BigInteger desconto;
	@Enumerated(EnumType.STRING)
	private tipoDesconto tipoDesconto;

	// Constructor

	public Pedido() {
	}	

	public Pedido(Cliente cliente) {
		super();
		this.cliente = cliente;
	}



	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void adicionarItem(ItemPedido item) {
		item.setPedido(this);
		this.itens.add(item);
	}

	public BigInteger getDesconto() {
		return desconto;
	}

	public void setDesconto(BigInteger desconto) {
		this.desconto = desconto;
	}

	public tipoDesconto getTipoDesconto() {
		return tipoDesconto;
	}

	public void setTipoDesconto(tipoDesconto tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}
}
