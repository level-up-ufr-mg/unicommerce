package br.com.alura.unicommerce.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate data = LocalDate.now();
	private BigDecimal desconto;
	
	@Column(name = "tipo_desconto")
	private TipoDesconto tipoDesconto; 

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST)
	private List<ItemDePedido> itens = new ArrayList<>();
	
	@Transient
	private BigDecimal valorTotal = BigDecimal.ZERO;
	
	public List<ItemDePedido> getItens() {
		return itens;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public BigDecimal getDescontosDeItens() {
		return descontosDeItens;
	}

	@Transient
	private BigDecimal descontosDeItens;
	
	public Pedido() {
	}

	public Pedido(BigDecimal desconto, TipoDesconto tipoDesconto, Cliente cliente) {
		this.desconto = desconto;
		this.tipoDesconto = tipoDesconto;
		this.cliente = cliente;
	}

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public TipoDesconto getTipoDesconto() {
		return tipoDesconto;
	}

	public void setTipoDesconto(TipoDesconto tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void adicionarItem(ItemDePedido item) {
	     item.setPedido(this);
	     this.itens.add(item);
	     this.valorTotal = this.valorTotal.add(item.getValor());
	}

	/*
	 * public BigDecimal getPreco() { return preco; }
	 * 
	 * 
	 * public void setPreco(BigDecimal preco) { this.preco = preco; }
	 */

	/*
	 * public int getQuantidade() { return quantidade; }
	 * 
	 * 
	 * public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
	 */
	
}
