package br.com.alura.unicommerce.Domain.Pedido;

import java.math.BigDecimal;

public enum TipoDeDescontoPedido {
	FIDELIDADE,
	NENHUM;

	BigDecimal aplicaDescontoSobre(BigDecimal valorTotal) {
		return valorTotal.multiply(valorTotal);
	}
}
