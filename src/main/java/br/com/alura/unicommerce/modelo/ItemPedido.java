package br.com.alura.unicommerce.modelo;

import java.math.BigDecimal;

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
@Table(name = "itens_pedido")
public class ItemPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Produto produto;
	@ManyToOne
	private Pedido pedido;
	@Column(name = "preco_unitario")
	private BigDecimal precoUnitario;
	@Column(name = "quantidade")
	private Integer quantidade;
	@Column(name = "desconto")
	private Double desconto;
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_desconto")
	private TipoDesconto tipoDesconto;

	// Construtores, getters e setters

	// Enum para o tipo de desconto
	public enum TipoDesconto {
		QUANTIDADE, PROMOCAO, NENHUM
	}

//	Contructors

	public ItemPedido() {
	}

	public ItemPedido(Produto produto, Pedido pedido, Integer quantidade, Double desconto, TipoDesconto tipoDesconto) {
		super();
		this.produto = produto;
		this.precoUnitario = produto.getPreco();
		this.pedido = pedido;
		this.quantidade = quantidade;
		this.desconto = desconto;
		this.tipoDesconto = tipoDesconto;
	}

//	Getters e Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public TipoDesconto getTipoDesconto() {
		return tipoDesconto;
	}

	public void setTipoDesconto(TipoDesconto tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}	
}
