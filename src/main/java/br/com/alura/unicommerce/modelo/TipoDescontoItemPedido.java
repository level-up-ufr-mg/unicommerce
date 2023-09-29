package br.com.alura.unicommerce.modelo;

import java.math.BigDecimal;

public enum TipoDescontoItemPedido {
	
	NENHUM,
	PROMOCAO,
	QUANTIDADE
	
	
//	NENHUM( BigDecimal.ZERO),
//	PROMOCAO(new BigDecimal("0.1")),
//	QUANTIDADE(new BigDecimal("0.15"));
//	
//	private BigDecimal percentualDesconto;
//	
//	private TipoDescontoItemPedido(BigDecimal percentualDesconto) {
//		this.percentualDesconto = percentualDesconto;
//	}
//	
//	BigDecimal aplicaDesconto (BigDecimal totalDoItem) {
//		return totalDoItem.multiply(percentualDesconto);
//	}
	

}