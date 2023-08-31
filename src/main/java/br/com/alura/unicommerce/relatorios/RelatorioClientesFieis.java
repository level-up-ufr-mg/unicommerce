package br.com.alura.unicommerce.relatorios;

import java.math.BigDecimal;

//Classe que representa o Relatório
//Cada coluna do relatório será um atributo na classe
public class RelatorioClientesFieis {
	
	private String nomeCliente;
	private Long qtdPedidosCliente;
	private BigDecimal totalGasto;
	
	public RelatorioClientesFieis(String nomeCliente, Long qtdPedidosCliente, BigDecimal totalGasto) {
		this.nomeCliente = nomeCliente;
		this.qtdPedidosCliente = qtdPedidosCliente;
		this.totalGasto = totalGasto;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public Long getQtdPedidosCliente() {
		return qtdPedidosCliente;
	}

	public BigDecimal getTotalGasto() {
		return totalGasto;
	}

	@Override
	public String toString() {
		return "RelatorioClientesFieis [nomeCliente=" + nomeCliente + ", qtdPedidosCliente=" + qtdPedidosCliente
				+ ", totalGasto=" + totalGasto + "]";
	}

}
