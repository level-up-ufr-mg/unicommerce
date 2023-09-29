package br.com.alura.unicommerce.modelo;

import java.math.BigDecimal;

public enum TipoDeDescontoPedido {
	FIDELIDADE {
		@Override
		public BigDecimal ajustePercentual() {
			return new BigDecimal("0.05");
		}
	},

	NENHUM {
		@Override
		public BigDecimal ajustePercentual() {
			return new BigDecimal("0,00");
		}
	};

	public abstract BigDecimal ajustePercentual();
}
