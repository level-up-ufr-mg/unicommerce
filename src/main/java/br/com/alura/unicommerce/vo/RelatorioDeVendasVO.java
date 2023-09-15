package br.com.alura.unicommerce.vo;

import java.time.LocalDate;

public class RelatorioDeVendasVO {
	 private String nomeProduto;
	 private long quantidadeVendida;
	 private LocalDate dataUltimaVenda;
	 
	public RelatorioDeVendasVO(String nomeProduto, long quantidadeVendida, LocalDate dataUltimaVenda) {
		this.nomeProduto = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
		this.dataUltimaVenda = dataUltimaVenda;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public long getQuantidadeVendida() {
		return quantidadeVendida;
	}
	public LocalDate getDataUltimaVenda() {
		return dataUltimaVenda;
	}
}
