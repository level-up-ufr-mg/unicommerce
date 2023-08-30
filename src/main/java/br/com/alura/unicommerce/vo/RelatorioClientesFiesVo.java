package br.com.alura.unicommerce.vo;

import java.math.BigDecimal;

public class RelatorioClientesFiesVo {

	private String nomeCliente;
	private Long quantidadePedidos;
	private BigDecimal totalGasto;
	
	public RelatorioClientesFiesVo(String nomeCliente, Long quantidadePedidos, BigDecimal totalGasto) {
		this.nomeCliente = nomeCliente;
		this.quantidadePedidos = quantidadePedidos;
		this.totalGasto = totalGasto;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public Long getQuantidadePedidos() {
		return quantidadePedidos;
	}
	
	public BigDecimal getMontante() {
		return totalGasto;
	}

	@Override
	public String toString() {
		return "RelatorioClientesFiesVo [nomeCliente=" + nomeCliente + ", quantidadePedidos=" + quantidadePedidos
				+ ", totalGasto=" + totalGasto + "]";
	}
	
	
}
