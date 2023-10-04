package br.com.alura.unicommerce.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@Column(name = "ID", nullable = false)
	private Long id;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Cliente cliente;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST)
	private List<ItemDePedido> itens = new ArrayList<>();
	
	@Column(nullable = false, name = "Tipo_de_Desconto")
	@Enumerated(EnumType.STRING)
	private TipoDeDescontoPedido tipoDeDescontoPedido;
	
	@Column(nullable = false, name = "Data")
	private LocalDate data;
	
	@Column(nullable = false, name = "Desconto", precision = 5, scale = 2)
	private BigDecimal desconto;
	
	@Transient
	private BigDecimal valorTotal;
	
	@Transient
	private BigDecimal descontosDeItens;
	
	@Transient
	private Long quantidadeDeItensLong;

	
	/************************************************
	*                                              *
	*     	 	 		Enum	              	   *
	*                                              *
	************************************************/
	
	/************************************************
	*                                              *
	*      	 		Constructor              		*
	*                                              *
	************************************************/

	public Pedido() {
	}
	
	public Pedido(Cliente cliente, BigDecimal desconto,
			TipoDeDescontoPedido tipoDeDescontoPedido, BigDecimal valorTotal) {
		this.cliente = cliente;
		this.data = LocalDate.now();
		this.desconto = desconto;
		this.tipoDeDescontoPedido = tipoDeDescontoPedido;
		this.valorTotal = valorTotal;
	}

	/************************************************
	*                                              *
	*      			Getters and Setters        		*
	*                                              *
	************************************************/

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

	public List<ItemDePedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemDePedido> itens) {
		this.itens = itens;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getValorTotal() {
		return this.tipoDeDescontoPedido.aplicaDescontoSobre(this.valorTotal);
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void adicionarItem(ItemDePedido item) {
		item.setPedido(this);
		this.itens.add(item);
		this.valorTotal = this.valorTotal.add(item.getValor());
	}
}
