package br.com.alura.unicommerce.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;



@Entity 
@Table(name = "pedido")
public class Pedido implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate data = LocalDate.now(); //pega a data atual
	
	@ManyToOne(fetch = FetchType.LAZY)//todo carregamento ToOne é do tipo Eager ou seja ele gera consultas desnecessáras no banco, nas tabelas que tem o ligação ManyToOne ou OneToOne então é usado o parametro fetch para controlar o carregamento, é feito o controle de quando for Eage ele trocar pra Lazy
	@JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemDePedido> itens = new ArrayList<>(); //sempre vai começar com uma colção vazia
	
	@Column(nullable = false)
	private BigDecimal desconto;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoDescontoPedido tipo_desconto;
	
	@Column(name = "valor_total")
	private BigDecimal valorTotal = BigDecimal.ZERO;

	@Transient
	private Integer quantidadeDeItens;
	
	@Transient
	private BigDecimal descontoDeItens;
	
	@Transient
	private BigDecimal total;
	
	
	
	public void adicionarItem(ItemDePedido item) {
		item.setPedido(this);
		this.itens.add(item);
		this.valorTotal = this.valorTotal.add(item.getValor());
	}
	
	public Pedido( Cliente cliente, List<ItemDePedido> itens, BigDecimal desconto,
			TipoDescontoPedido tipo_desconto) {
		this.cliente = cliente;
		adicionaItens(itens);
		this.desconto = desconto;
		this.tipo_desconto = tipo_desconto;
	}

	private void adicionaItens(List<ItemDePedido> itens2) {
		itens.forEach(item -> adicionaItem(item));
		
	}

	private void adicionaItem(ItemDePedido item) {
	    this.total = this.total.add(item.getValor());
	    this.quantidadeDeItens = this.quantidadeDeItens + item.getQuantidade();
	    this.descontoDeItens = this.descontoDeItens.add(item.getDesconto());
        item.setPedido(this);
	    itens.add(item);		
	}

	public Pedido(Cliente cliente, BigDecimal desconto, TipoDescontoPedido tipo_desconto) {
		this.cliente = cliente;
		this.desconto = desconto;
		this.tipo_desconto = tipo_desconto;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Integer getQuantidadeDeItens() {
		return quantidadeDeItens;
	}

	public void setQuantidadeDeItens(Integer quantidadeDeItens) {
		this.quantidadeDeItens = quantidadeDeItens;
	}

	public BigDecimal getDescontoDeItens() {
		return descontoDeItens;
	}

	public void setDescontoDeItens(BigDecimal descontoDeItens) {
		this.descontoDeItens = descontoDeItens;
	}

	public List<ItemDePedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemDePedido> itens) {
		this.itens = itens;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public TipoDescontoPedido getTipo_desconto() {
		return tipo_desconto;
	}

	public void setTipo_desconto(TipoDescontoPedido tipo_desconto) {
		this.tipo_desconto = tipo_desconto;
	}
	
	

}