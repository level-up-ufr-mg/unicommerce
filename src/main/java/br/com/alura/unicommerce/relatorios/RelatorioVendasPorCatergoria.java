package br.com.alura.unicommerce.relatorios;

import java.math.BigDecimal;

public class RelatorioVendasPorCatergoria {
	
	private String nomeCategoria;
	private Long produtosCategoriaVendidos;
	private BigDecimal totalVendaCategoria;
	
	public RelatorioVendasPorCatergoria(String nomeCategoria, Long produtosCategoriaVendidos,
			BigDecimal totalVendaCategoria) {
		this.nomeCategoria = nomeCategoria;
		this.produtosCategoriaVendidos = produtosCategoriaVendidos;
		this.totalVendaCategoria = totalVendaCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public Long getProdutosCategoriaVendidos() {
		return produtosCategoriaVendidos;
	}

	public BigDecimal getTotalVendaCategoria() {
		return totalVendaCategoria;
	}
	
	
	
	


}

