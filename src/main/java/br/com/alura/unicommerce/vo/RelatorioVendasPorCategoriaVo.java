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
	
	

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public void setQuantidadeVendida(Long quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}

	public void setTotalVendido(BigDecimal totalVendido) {
		this.totalVendido = totalVendido;
	}

	@Override
	public String toString() {
		return "RelatorioVendasPorCategoriaVo [nomeCategoria=" + nomeCategoria + ", quantidadeVendida="
				+ quantidadeVendida + ", totalVendido=" + totalVendido + "]";
	}


	
	
}
