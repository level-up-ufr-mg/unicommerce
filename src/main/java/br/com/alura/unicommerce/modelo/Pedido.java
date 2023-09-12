package br.com.alura.unicommerce.modelo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "unicommerce", name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pedidoId;

	@Column(nullable = false)
	private Timestamp data;

	@Column(nullable = false,precision = 10,scale = 2)
	private BigDecimal desconto;

	@Enumerated(EnumType.STRING)
	private Descontos tipoDesconto;

	private BigDecimal valorTotal = BigDecimal.ZERO;

	// ==================== Variaveis de Relacionamento================
	@ManyToOne
	@JoinColumn(name = "clienteId")
	private Cliente cliente;

	@OneToMany(mappedBy = "pedidoId", cascade = CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<>();
	// ==================== Variaveis de Relacionamento================

	public Pedido() {
	}

	public Pedido(Long iD, Timestamp dATA, BigDecimal dESCONTO, Descontos tIPO_DESCONTO, Cliente cLIENTE_ID,
			BigDecimal valorTotal) {
		pedidoId = iD;
		data = dATA;
		desconto = dESCONTO;
		tipoDesconto = tIPO_DESCONTO;
		cliente = cLIENTE_ID;
		valorTotal = valorTotal;
	}

	public void adicionarItem(ItemPedido itemPedido) {
		itemPedido.setPedidoId(this);
		this.itens.add(itemPedido);
		this.valorTotal= this.valorTotal.add(itemPedido.getPrecoUnitario());
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long iD) {
		pedidoId = iD;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp dATA) {
		data = dATA;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cLIENTE_ID) {
		cliente = cLIENTE_ID;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal dESCONTO) {
		desconto = dESCONTO;
	}

	public Descontos getTipoDesconto() {
		return this.tipoDesconto;
	}

	public void setTipoDesconto(Descontos tIPO_DESCONTO) {
		tipoDesconto = tIPO_DESCONTO;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		valorTotal = valorTotal;
	}

}
