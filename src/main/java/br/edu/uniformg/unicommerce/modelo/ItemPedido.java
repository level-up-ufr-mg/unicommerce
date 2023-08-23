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

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    private Long id;
    private Double precoUnitario;
    private Integer quantidade;
    private Double desconto;   
    private String tipoDesconto;    
    //FKs
    private Long pedidoId;
    private Long produtoId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Double getDesconto() {
		return desconto;
	}
	
	@Enumerated(EnumType.STRING)
	public String getTipoDesconto() {
		return tipoDesconto;
	}

	@ManyToOne
    @JoinColumn(name = "pedido_id")
	public Long getPedido() {
		return pedidoId;
	}
	
	@ManyToOne
    @JoinColumn(name = "produto_id")
	public Long getProduto() {
		return produtoId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public void setTipoDesconto(String tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", precoUnitario=" + precoUnitario + ", quantidade=" + quantidade
				+ ", desconto=" + desconto + ", pedido=" + pedidoId + ", produto=" + produtoId + "]";
	}    
}

