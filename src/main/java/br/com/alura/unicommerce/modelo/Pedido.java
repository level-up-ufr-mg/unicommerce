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

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	@Column(name = "Itens")
	private List<ItemPedido> itens = new ArrayList<>();
	
	@Column(nullable = false, name = "data")
	private LocalDate data;
	
	@Column(nullable = false, name = "Desconto", precision = 10, scale = 2)
	private BigDecimal desconto;
	
	@Column(nullable = false, name = "Tipo_de_Desconto")
	private TipoDeDesconto tipoDeDesconto;
	
	@Column(nullable = false, name = "valor_total")
	private BigDecimal valorTotal = BigDecimal.ZERO;

	// Constructor ----------------------------------------------------

	public Pedido() {
	}

	public Pedido(Cliente cliente, List<ItemPedido> itens, LocalDate data, BigDecimal desconto,
			TipoDeDesconto tipoDeDesconto, BigDecimal valorTotal) {
		this.cliente = cliente;
		this.data = data;
		this.desconto = desconto;
		this.tipoDeDesconto = tipoDeDesconto;
	}

	// Getters and Setters ----------------------------------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void adicionarItem(ItemPedido item) {
		item.setPedido(this);
		this.itens.add(item);
		this.valorTotal = this.valorTotal.add(item.getValor());
	}
}
