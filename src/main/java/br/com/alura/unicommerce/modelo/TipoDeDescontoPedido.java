package br.com.alura.unicommerce.modelo;

import java.math.BigDecimal;

public enum TipoDeDescontoPedido {
	FIDELIDADE,
	NENHUM;

	BigDecimal aplicaDescontoSobre(BigDecimal valorTotal) {
		return valorTotal.multiply(valorTotal);
	}
}
