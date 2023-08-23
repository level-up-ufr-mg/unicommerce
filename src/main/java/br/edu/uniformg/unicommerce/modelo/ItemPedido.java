package br.edu.uniformg.unicommerce.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    private Long id;
    private BigDecimal precoUnitario;
    private Integer quantidade;
    private BigDecimal desconto;   
    private TipoDesconto tipoDesconto;    
    //FKs
    private Pedido pedidoId;
    private Produto produtoId;
    
    
    public ItemPedido() {
    	
    }

    public ItemPedido(Integer quantidade, BigDecimal desconto, TipoDesconto tipoDesconto, Pedido pedidoId,
			Produto produtoId) {
		this.precoUnitario = produtoId.getPreco();
		this.quantidade = quantidade;
		this.desconto = desconto;
		this.tipoDesconto = tipoDesconto;
		this.pedidoId = pedidoId;
		this.produtoId = produtoId;
	}

    
    public BigDecimal getValor() {
    	 return precoUnitario.multiply(new BigDecimal(quantidade));
    }

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}
	
	@Enumerated(EnumType.STRING)
	public TipoDesconto getTipoDesconto() {
		return tipoDesconto;
	}

	@ManyToOne
    @JoinColumn(name = "pedido_id")
	public Pedido getPedido() {
		return pedidoId;
	}
	
	@ManyToOne
    @JoinColumn(name = "produto_id")
	public Produto getProduto() {
		return produtoId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public void setTipoDesconto(TipoDesconto tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}

	public void setPedidoId(Pedido pedidoId) {
		this.pedidoId = pedidoId;
	}

	public void setProdutoId(Produto produtoId) {
		this.produtoId = produtoId;
	}

	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", precoUnitario=" + precoUnitario + ", quantidade=" + quantidade
				+ ", desconto=" + desconto + ", pedido=" + pedidoId + ", produto=" + produtoId + "]";
	}    
}

