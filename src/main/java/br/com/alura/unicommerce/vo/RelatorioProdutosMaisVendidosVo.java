package br.com.alura.unicommerce.vo;

public class RelatorioProdutosMaisVendidosVo {

	private String nomeProduto;

	public RelatorioProdutosMaisVendidosVo(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	@Override
	public String toString() {
		return "RelatorioProdutosMaisVendidosVo [nomeProduto=" + nomeProduto + "]";
	}

	
	
}
