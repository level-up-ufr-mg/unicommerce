package br.com.alura.unicommerce.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "item_pedido")
public class ItemDePedido implements Serializable {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "preco_unitario", precision = 10, scale = 2, nullable = false)
	    private BigDecimal precoUnitario = BigDecimal.ZERO;;

	    @Column(nullable = false)
	    private Integer quantidade;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "pedido_id", nullable = false)
	    private Pedido pedido;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "produto_id", nullable = false)
	    private Produto produto;

	    @Column(precision = 10, scale = 2)
	    private BigDecimal desconto = BigDecimal.ZERO;;

	    @Column(name = "tipo_desconto", length = 20, nullable = false)
	    @Enumerated(EnumType.STRING)
	    private TipoDescontoItemPedido tipoDesconto = TipoDescontoItemPedido.NENHUM;
	    
	    @Transient
		private BigDecimal total = BigDecimal.ZERO;
	    
	    
		public ItemDePedido() {
			
		}
	    
	    public ItemDePedido(Integer quantidade, Produto produto) {
			this.quantidade = quantidade;
			this.produto = produto;
		}

	    public ItemDePedido(Integer quantidade, Pedido pedido, Produto produto,
				BigDecimal desconto, TipoDescontoItemPedido tipoDesconto) {
			this.quantidade = quantidade;
			this.pedido = pedido;
			this.produto = produto;
			this.desconto = desconto;
			this.tipoDesconto = tipoDesconto;
			this.precoUnitario = produto.getPreco();
		}

		
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		public Pedido getPedido() {
			return pedido;
		}

		public void setPedido(Pedido pedido) {
			this.pedido = pedido;
		}

		public Produto getProduto() {
			return produto;
		}

		public void setProduto(Produto produto) {
			this.produto = produto;
		}

		public BigDecimal getDesconto() {
			return desconto;
		}

		public void setDesconto(BigDecimal desconto) {
			this.desconto = desconto;
		}

		public TipoDescontoItemPedido getTipoDesconto() {
			return tipoDesconto;
		}

		
		public BigDecimal getTotal() {
			return total;
		}


		public void setTotal(BigDecimal total) {
			this.total = total;
		}

    
		public BigDecimal getValor() {
	    	return precoUnitario.multiply(new BigDecimal(quantidade));
			//return this.tipoDesconto.aplicaDesconto(precoUnitario.multiply(new BigDecimal(quantidade)));
		}
	    
}
