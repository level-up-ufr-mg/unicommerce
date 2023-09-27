package br.com.alura.unicommerce.modelo;

import java.math.BigDecimal;

public enum TipoDescontoPedido {

	FIDELIDADE(new BigDecimal("5")), 
	NENHUM(BigDecimal.ZERO),
	QUANTIDADE(new BigDecimal("10"));
	
	private BigDecimal desconto;

	TipoDescontoPedido(BigDecimal percentualDesconto) {
		this.desconto = percentualDesconto;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}
	
	
}
