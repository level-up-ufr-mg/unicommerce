package br.com.alura.unicommerce.modelo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@OneToMany(mappedBy = "ItemPedido")
	@JoinColumn(name = "id")
	private Long id;

	@Column(name = "data")
	private LocalDateTime data;

	@Column(name = "cliente_id")
	private Long clienteId;

	@Column(name = "desconto")
	private BigInteger desconto;

	@Enumerated(EnumType.STRING)
	private tipoDesconto tipoDesconto;

	public Pedido() {
	}

	public Pedido(LocalDateTime data, Long clienteId, BigInteger desconto,
			br.com.alura.unicommerce.modelo.tipoDesconto tipoDesconto) {
		this.data = data;
		this.clienteId = clienteId;
		this.desconto = desconto;
		this.tipoDesconto = tipoDesconto;
	}

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

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
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

	public BigDecimal getPreco() {
		// TODO Auto-generated method stub
		return null;
	}

}
