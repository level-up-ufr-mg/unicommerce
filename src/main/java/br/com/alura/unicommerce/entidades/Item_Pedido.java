package br.com.alura.unicommerce.entidades;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "unicommerce", name = "item_pedido")
public class Item_Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iD;
	private BigDecimal PRECO_UNITARIO;
	private Long QUANTIDADE;
	private String TIPO_DESCONTO;
	private BigDecimal DESCONTO_ID;
	// ==================== Variaveis de Relacionamento================
	@ManyToOne
	@JoinColumn(name = "PEDIDO_ID")
	private Pedido PEDIDO_ID;
	@ManyToOne
	@JoinColumn(name = "PRODUTO_ID")
	private Produto PRODUTO_ID;
	// ==================== Variaveis de Relacionamento================
	public Item_Pedido() {
	}

	public Item_Pedido(Long iD, BigDecimal pRECO_UNITARIO, Long qUANTIDADE, Pedido pEDIDO_ID, Produto pRODUTO_ID,
			BigDecimal dESCONTO_ID, String tIPO_DESCONTO) {
		this.iD = iD;
		PRECO_UNITARIO = pRECO_UNITARIO;
		QUANTIDADE = qUANTIDADE;
		PEDIDO_ID = pEDIDO_ID;
		PRODUTO_ID = pRODUTO_ID;
		DESCONTO_ID = dESCONTO_ID;
		TIPO_DESCONTO = tIPO_DESCONTO;
	}

	public Long getiD() {
		return iD;
	}

	public void setiD(Long iD) {
		this.iD = iD;
	}

	public BigDecimal getPRECO_UNITARIO() {
		return PRECO_UNITARIO;
	}

	public void setPRECO_UNITARIO(BigDecimal pRECO_UNITARIO) {
		PRECO_UNITARIO = pRECO_UNITARIO;
	}

	public Long getQUANTIDADE() {
		return QUANTIDADE;
	}

	public void setQUANTIDADE(Long qUANTIDADE) {
		QUANTIDADE = qUANTIDADE;
	}

	public Pedido getPEDIDO_ID() {
		return PEDIDO_ID;
	}

	public void setPEDIDO_ID(Pedido pEDIDO_ID) {
		PEDIDO_ID = pEDIDO_ID;
	}

	public Produto getPRODUTO_ID() {
		return PRODUTO_ID;
	}

	public void setPRODUTO_ID(Produto pRODUTO_ID) {
		PRODUTO_ID = pRODUTO_ID;
	}

	public BigDecimal getDESCONTO_ID() {
		return DESCONTO_ID;
	}

	public void setDESCONTO_ID(BigDecimal dESCONTO_ID) {
		DESCONTO_ID = dESCONTO_ID;
	}

	public String getTIPO_DESCONTO() {
		return TIPO_DESCONTO;
	}

	public void setTIPO_DESCONTO(String tIPO_DESCONTO) {
		TIPO_DESCONTO = tIPO_DESCONTO;
	}

}
