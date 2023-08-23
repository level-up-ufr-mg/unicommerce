package br.com.alura.unicommerce.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate data = LocalDate.now();
	private BigDecimal desconto;
	
	@Column(name = "tipo_desconto")
	private TIPO_DESCONTO tipoDesconto; 
	//private BigDecimal preco;
    //private int quantidade;

	@ManyToOne
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<>();
	
	public Pedido() {
	}

	public Pedido(LocalDate data, BigDecimal desconto, TIPO_DESCONTO tipoDesconto, Cliente cliente) {
		this.data = data;
		this.desconto = desconto;
		this.tipoDesconto = tipoDesconto;
		//this.setPreco(preco);
		//this.quantidade = quantidade;
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

	public TIPO_DESCONTO getTipoDesconto() {
		return tipoDesconto;
	}

	public void setTipoDesconto(TIPO_DESCONTO tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void adicionarItem(ItemPedido item) {
	     item.setPedido(this);
	     this.itens.add(item);
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
