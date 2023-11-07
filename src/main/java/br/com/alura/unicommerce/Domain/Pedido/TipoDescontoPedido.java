package br.com.alura.unicommerce.Domain.Pedido;

import java.math.BigDecimal;

public enum TipoDescontoPedido {

	NENHUM(BigDecimal.ZERO), 
	FIDELIDADE(new BigDecimal("0.05")),
	QUANTIDADE(new BigDecimal("0.10"));

	TipoDescontoPedido(BigDecimal percentualDesconto){
		this.desconto = percentualDesconto;
	}
	
	BigDecimal desconto;
	
	public BigDecimal getDesconto() {
		return this.desconto;
	}

	BigDecimal aplicaDesconto(BigDecimal total) {
		return total.multiply(getDesconto());

	}
	
	BigDecimal getTotalDesconto(BigDecimal total) {
			return total.multiply(getDesconto());
	}
	
}