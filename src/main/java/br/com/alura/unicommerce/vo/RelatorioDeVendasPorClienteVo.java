package br.com.alura.unicommerce.vo;

import java.math.BigDecimal;

public class RelatorioDeVendasPorClienteVo {
	private String clienteString;
	private Long numeroDePedidosInteger;
	private BigDecimal montante;

	public RelatorioDeVendasPorClienteVo() {
	}

	public RelatorioDeVendasPorClienteVo(String clienteString, Long numeroDePedidosInteger, BigDecimal montante) {
		this.clienteString = clienteString;
		this.numeroDePedidosInteger = numeroDePedidosInteger;
		this.montante = montante;
	}

	public String getClienteString() {
		return clienteString;
	}

	public Long getNumeroDePedidosInteger() {
		return numeroDePedidosInteger;
	}

	public BigDecimal getMontante() {
		return montante;
	}

	@Override
	public String toString() {
		return "Cliente = " + clienteString + ", Número de Pedidos = "
				+ numeroDePedidosInteger + ", montante = " + montante + "]";
	}

}
