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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_pedido")
public class ItemDePedido {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "preco_unitario", precision = 10, scale = 2, nullable = false)
	    private BigDecimal precoUnitario;

	    @Column(nullable = false)
	    private Integer quantidade;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "pedido_id", nullable = false)
	    private Pedido pedido;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "produto_id", nullable = false)
	    private Produto produto;

	    @Column(precision = 10, scale = 2)
	    private BigDecimal desconto;

	    @Column(name = "tipo_desconto", length = 20, nullable = false)
	    @Enumerated(EnumType.STRING)
	    private TipoDescontoItemPedido tipoDesconto;
	    
	    public BigDecimal getValor() {
			return precoUnitario.multiply(new BigDecimal(quantidade));
		}


		public ItemDePedido() {
			
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

		public void setTipoDesconto(TipoDescontoItemPedido tipoDesconto) {
			this.tipoDesconto = tipoDesconto;
		}	    
	    
	    
}
