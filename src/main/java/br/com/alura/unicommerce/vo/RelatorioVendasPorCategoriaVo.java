package br.com.alura.unicommerce.vo;

import java.math.BigDecimal;

public class RelatorioVendasPorCategoriaVo {
	
	private String nomeCategoria;
	private Long quantidadeVendida;
	private BigDecimal totalVendido;
	

	public RelatorioVendasPorCategoriaVo(String nomeCategoria, Long quantidadeVendida, BigDecimal totalVendido) {
		this.nomeCategoria = nomeCategoria;
		this.quantidadeVendida = quantidadeVendida;
		this.totalVendido = totalVendido;
	}
	
	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public Long getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public BigDecimal getTotalVendido() {
		return totalVendido;
	}

	@Override
	public String toString() {
		return "RelatorioVendasPorCategoriaVo [nomeCategoria=" + nomeCategoria + ", quantidadeVendida="
				+ quantidadeVendida + ", totalVendido=" + totalVendido + "]";
	}


	
	
}
