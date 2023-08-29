package br.com.alura.unicommerce.modelo;

import java.math.BigDecimal;
import java.sql.Timestamp;
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

@Entity
@Table(schema = "unicommerce", name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column(nullable = false)
	private Timestamp DATA;
	
	@Column(nullable = false)
	private BigDecimal DESCONTO;
	
	@Enumerated(EnumType.STRING)
	private Descontos TIPO_DESCONTO;
	// ==================== Variaveis de Relacionamento================
	@ManyToOne
	@JoinColumn(name = "CLIENTE_ID")
	private Cliente CLIENTE_ID;
	
	
	@OneToMany(mappedBy = "PEDIDO_ID", cascade = CascadeType.ALL)
	private List<ItemPedido> listaDeItens = new ArrayList<>();
	// ==================== Variaveis de Relacionamento================

	
	
	public Pedido() {
	}

	





	public Pedido(Long iD, Timestamp dATA, BigDecimal dESCONTO, Descontos tIPO_DESCONTO, Cliente cLIENTE_ID) {
//			List<Item_Pedido> listaDeItens) {
		ID = iD;
		DATA = dATA;
		DESCONTO = dESCONTO;
		TIPO_DESCONTO = tIPO_DESCONTO;
		CLIENTE_ID = cLIENTE_ID;
		//this.listaDeItens = listaDeItens;
	}


	public void adicionarItem(ItemPedido itemPedido) {
		itemPedido.setPEDIDO_ID(this);
		this.listaDeItens.add(itemPedido);
		}




	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Timestamp getDATA() {
		return DATA;
	}

	public void setDATA(Timestamp dATA) {
		DATA = dATA;
	}

	public Cliente getCLIENTE_ID() {
		return CLIENTE_ID;
	}

	public void setCLIENTE_ID(Cliente cLIENTE_ID) {
		CLIENTE_ID = cLIENTE_ID;
	}

	public BigDecimal getDESCONTO() {
		return DESCONTO;
	}

	public void setDESCONTO(BigDecimal dESCONTO) {
		DESCONTO = dESCONTO;
	}

	public Descontos getTIPO_DESCONTO() {
		return this.TIPO_DESCONTO;
	}

	public void setTIPO_DESCONTO(Descontos tIPO_DESCONTO) {
		TIPO_DESCONTO = tIPO_DESCONTO;
	}

}
