package br.com.alura.unicommerce.modelo;

import java.math.BigDecimal;

public enum TipoDeDescontoItemDePedido {
	QUANTIDADE(new BigDecimal("0.9")),
	PROMOCAO(new BigDecimal("0.85")),
	NENHUM(BigDecimal.ZERO);
	
	private BigDecimal percentualDeDescontoBigDecimal;

	private TipoDeDescontoItemDePedido(BigDecimal percentualDeDescontoBigDecimal) {
		this.percentualDeDescontoBigDecimal = percentualDeDescontoBigDecimal;
	}

	BigDecimal aplicaDescontoSobre(BigDecimal totalDoItem) {
		return totalDoItem.multiply(percentualDeDescontoBigDecimal);
	}
	 
}
