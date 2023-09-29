package br.com.alura.unicommerce.vo;

public class RelatorioDeVendasPorProdutoVendidoVo {
	private String nome;
	private Long quantidadeLong;

	public RelatorioDeVendasPorProdutoVendidoVo() {
	}

	public RelatorioDeVendasPorProdutoVendidoVo(String nome, Long quantidadeLong) {
		this.nome = nome;
		this.quantidadeLong = quantidadeLong;
	}

	public String getNome() {
		return nome;
	}

	public Long getQuantidadeLong() {
		return quantidadeLong;
	}

	@Override
	public String toString() {
		return "RelatorioDeVendasPorProdutoVendidoVo [nome=" + nome + ", quantidadeLong=" + quantidadeLong + "]";
	}

}
