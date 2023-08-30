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
import javax.persistence.JoinColumn;
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
	
	public void adicionarItem(ItemDePedido item) {
		item.setPedido(this);
		this.itens.add(item);
		this.valorTotal = this.valorTotal.add(item.getValor());
	}

	//@Transient anotação que cria campos provisorios ou seja não tem esse campo na tabela
	
	public Pedido() {
		
	}

	public Pedido(Cliente cliente, BigDecimal desconto, TipoDescontoPedido tipo_desconto) {
		this.cliente = cliente;
		this.desconto = desconto;
		this.tipo_desconto = tipo_desconto;
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