package br.com.alura.util.domain.endereco;

import java.math.BigDecimal;

public enum Descontos {

	NENHUM(BigDecimal.ZERO), 
	FIDELIDADE(new BigDecimal("0.05")),
	QUANTIDADE(new BigDecimal("0.10"));
	
	
	
	 
	
	
	
	Descontos(BigDecimal percentualDesconto) {
		this.desconto = percentualDesconto;
	}

	private BigDecimal desconto;
	
	public BigDecimal getDesconto() { 
		return this.desconto;
	}
	
	BigDecimal getTotalDeDesconto(BigDecimal total) {
		return total.multiply(getDesconto());
	}
	
//	public static void main(String[] args) {
//		System.out.println(TipoDescontoPedido.FIDELIDADE
//				.getTotalDeDesconto(new BigDecimal("1000")));
//	}
	
	
	
	
	
	
	
}
 