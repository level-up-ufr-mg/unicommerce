package br.com.alura.unicommerce.relatorios;

import java.time.LocalDate;

/* 	Classe que representa o relatório
 	o nome da categoria;
	a quantidade de produtos dela que foram vendidos;
	o montante vendido.
*/

public class RelatorioVendas {
	
	//Informações necessárias para o relatório
	private String nomeProduto;
	private Long quantidadeVendida;
	private LocalDate dataUltimaVenda;
	
	public RelatorioVendas(String nomeProduto, Long quantidadeVendida, LocalDate dataUltimaVenda) {
		this.nomeProduto = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
		this.dataUltimaVenda = dataUltimaVenda;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public Long getQuantidadeVendida() {
		return quantidadeVendida;
	}
	public LocalDate getDataUltimaVenda() {
		return dataUltimaVenda;
	}

	@Override
	public String toString() {
		return "RelatorioVendas [nomeProduto=" + nomeProduto + ", quantidadeVendida=" + quantidadeVendida
				+ ", dataUltimaVenda=" + dataUltimaVenda + "]";
	}
	
}

