package br.com.alura.unicommerce.modelo;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private Long id;
	@Column(name = "data")
	private LocalDateTime data;
	@ManyToOne
	private Cliente cliente;
	@Column(name = "desconto")
	private BigInteger desconto;
	@Enumerated(EnumType.STRING)
	private tipoDesconto tipoDesconto;
	
//	Constructor
	public Pedido() {
	}

	public Pedido(LocalDateTime data, Cliente cliente, BigInteger desconto,
			br.com.alura.unicommerce.modelo.tipoDesconto tipoDesconto) {
		super();
		this.data = data;
		this.cliente = cliente;
		this.desconto = desconto;
		this.tipoDesconto = tipoDesconto;
	}

//	Getters and Setters
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
