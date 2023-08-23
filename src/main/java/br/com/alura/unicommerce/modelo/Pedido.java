package br.com.alura.unicommerce.modelo;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "unicommerce", name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	private Timestamp DATA;
	private BigDecimal DESCONTO;
	private String TIPO_DESCONTO;
	// ==================== Variaveis de Relacionamento================
	@ManyToOne
	@JoinColumn(name = "CLIENTE_ID")
	private Cliente CLIENTE_ID;
	
	@ManyToOne
	@JoinColumn(name = "")
	private Item_Pedido item_Pedido_ID;
	// ==================== Variaveis de Relacionamento================

	public Pedido() {
	}

	public Pedido(Long iD, Timestamp dATA, Cliente cLIENTE_ID, BigDecimal dESCONTO, String tIPO_DESCONTO) {
		ID = iD;
		DATA = dATA;
		CLIENTE_ID = cLIENTE_ID;
		DESCONTO = dESCONTO;
		TIPO_DESCONTO = tIPO_DESCONTO;
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

	public String getTIPO_DESCONTO() {
		return TIPO_DESCONTO;
	}

	public void setTIPO_DESCONTO(String tIPO_DESCONTO) {
		TIPO_DESCONTO = tIPO_DESCONTO;
	}

}
