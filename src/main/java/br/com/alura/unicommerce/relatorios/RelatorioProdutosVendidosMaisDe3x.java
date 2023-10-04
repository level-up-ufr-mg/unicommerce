package br.com.alura.unicommerce.relatorios;

public class RelatorioProdutosVendidosMaisDe3x {
	
	private String nomeProduto;
	private Long qtdDeVezesVendido;
	
	public RelatorioProdutosVendidosMaisDe3x(String nomeProduto, Long qtdDeVezesVendido) {
		this.nomeProduto = nomeProduto;
		this.qtdDeVezesVendido = qtdDeVezesVendido;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public Long getQtdDeVezesVendido() {
		return qtdDeVezesVendido;
	}

	@Override
	public String toString() {
		return "RelatorioProdutosVendidosMaisDe3x [nomeProduto=" + nomeProduto + ", qtdDeVezesVendido="
				+ qtdDeVezesVendido + "]";
	}
	
}
