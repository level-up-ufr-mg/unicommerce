package br.com.alura.unicommerce.vo;

import java.math.BigDecimal;

public class RelatorioDeVendasPorCategoriaVo {
	private String nomeCategoria;
	private long quantidadeVendida;
	private BigDecimal montante;

	public RelatorioDeVendasPorCategoriaVo() {
	}

	public RelatorioDeVendasPorCategoriaVo(String nomeProduto, long quantidadeVendida, BigDecimal montante) {
		this.nomeCategoria = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
		this.montante = montante;
	}

	public String getNomeProduto() {
		return nomeCategoria;
	}

	public long getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public BigDecimal getMontante() {
		return montante;
	}

	@Override
	public String toString() {
		return "Relatorio De Vendas [Nome da Categoria = " + nomeCategoria + ", quantidade Vendida = " + quantidadeVendida
				+ ", montante = " + montante + "]";
	}	
}
