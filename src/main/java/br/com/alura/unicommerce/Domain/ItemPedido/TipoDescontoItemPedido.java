package br.com.alura.unicommerce.Domain.ItemPedido;

import java.math.BigDecimal;

public enum TipoDescontoItemPedido {
	QUANTIDADE(new BigDecimal("0.9")),
	PROMOCAO(new BigDecimal("0.85")),
	NENHUM(BigDecimal.ZERO);
	
	private BigDecimal percentualDeDescontoBigDecimal;

	private TipoDescontoItemPedido(BigDecimal percentualDeDescontoBigDecimal) {
		this.percentualDeDescontoBigDecimal = percentualDeDescontoBigDecimal;
	}

	BigDecimal aplicaDescontoSobre(BigDecimal totalDoItem) {
		return totalDoItem.multiply(percentualDeDescontoBigDecimal);
	}
	 
}
