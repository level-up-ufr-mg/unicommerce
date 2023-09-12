package br.com.alura.unicommerce.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "unicommerce", name = "item_pedido")
public class ItemPedido {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemPedidoId;
	@Column(nullable = false)
	private BigDecimal precoUnitario;
	@Column(nullable = false)
	private Long quantidade;
	
	private Descontos tipoDesconto;
	@Column(nullable = false)
	private BigDecimal descontoId;
	// ==================== Variaveis de Relacionamento================
	
	@ManyToOne // fetch = FetchType.LAZY
	@JoinColumn(name = "pedidoId")
	private Pedido pedidoId;
	
	
	@ManyToOne // fetch = FetchType.LAZY
	@JoinColumn(name = "produtoId")
	private Produto produtoId;
	
	
	
	// ==================== Variaveis de Relacionamento================
	public ItemPedido() {
	} 

	public ItemPedido(Long iD, BigDecimal pRECO_UNITARIO, Long qUANTIDADE, Pedido pEDIDO_ID, Produto pRODUTO_ID,
			BigDecimal dESCONTO_ID, Descontos tIPO_DESCONTO) {
		this.itemPedidoId = iD;
		precoUnitario = pRECO_UNITARIO;
		quantidade = qUANTIDADE; 
		pedidoId = pEDIDO_ID;
		produtoId = pRODUTO_ID;
		descontoId = dESCONTO_ID;
		tipoDesconto = tIPO_DESCONTO;
	}

	public Long getItemPedidoId() {
		return itemPedidoId;
	}

	public void setItemPedidoId(Long iD) {
		this.itemPedidoId = iD;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal pRECO_UNITARIO) {
		precoUnitario = pRECO_UNITARIO;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long qUANTIDADE) {
		quantidade = qUANTIDADE;
	}

	public Pedido getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Pedido pEDIDO_ID) {
		pedidoId = pEDIDO_ID;
	}

	public Produto getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Produto pRODUTO_ID) {
		produtoId = pRODUTO_ID;
	}

	public BigDecimal getDescontoId() {
		return descontoId;
	}

	public void setDescontoId(BigDecimal dESCONTO_ID) {
		descontoId = dESCONTO_ID;
	}

	public Descontos getTipoDesconto() {
		return tipoDesconto;
	}

	public void setTipoDesconto(Descontos tIPO_DESCONTO) {
		tipoDesconto = tIPO_DESCONTO;
	}

	@Override
	public String toString() {
		return "Item_Pedido [iD=" + itemPedidoId + ", PRECO_UNITARIO=" + precoUnitario + ", QUANTIDADE=" + quantidade
				+ ", TIPO_DESCONTO=" + tipoDesconto + ", DESCONTO_ID=" + descontoId + ", PEDIDO_ID=" + pedidoId
				+ ", PRODUTO_ID=" + produtoId + "]";
	}

	
	
}
