package br.com.alura.unicommerce.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itens_pedido")
public class ItemDePedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Produto produto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;
	
	@Column(name = "preco_unitario")
	private BigDecimal precoUnitario;
	
	@Column(name = "quantidade")
	private Integer quantidade;
	
	@Column(name = "desconto")
	private BigDecimal desconto;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_desconto")
	private TipoDeDescontoItemDePedido tipoDeDescontoItemDePedido;

	/************************************************
	*                                              *
	*       	    		ENUM              		*
	*                                              *
	************************************************/
		
//	private enum TipoDeDesconto {
//		QUANTIDADE,
//		PROMOCAO,
//		NENHUM
//	}

	/************************************************
	*                                              *
	*           		Construtor              	*
	*                                              *
	************************************************/


	public ItemDePedido() {
	}

	public ItemDePedido(Produto produto, Pedido pedido, Integer quantidade, BigDecimal desconto,
			TipoDeDescontoItemDePedido tipoDeDescontoItemDePedido) {
		this.produto = produto;
		this.precoUnitario = produto.getPreco();
		this.pedido = pedido;
		this.quantidade = quantidade;
		this.desconto = desconto;
		this.tipoDeDescontoItemDePedido = tipoDeDescontoItemDePedido;
	}

	/************************************************
	*                                              *
	*        		Getters e Setters              	*
	*                                              *
	************************************************/

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

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public TipoDeDescontoItemDePedido getTipoDesconto() {
		return tipoDeDescontoItemDePedido;
	}

	public void setTipoDesconto(TipoDeDescontoItemDePedido tipoDesconto) {
		this.tipoDeDescontoItemDePedido = tipoDesconto;
	}

	public BigDecimal getValor() {
		return precoUnitario.multiply(new BigDecimal(quantidade));
	}
}
