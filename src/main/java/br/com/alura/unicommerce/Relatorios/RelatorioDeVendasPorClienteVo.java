package br.com.alura.unicommerce.Relatorios;

import java.math.BigDecimal;

public class RelatorioDeVendasPorClienteVo {
	private String clienteString;
	private Long numeroDePedidosInteger;
	private BigDecimal montante;

	public RelatorioDeVendasPorClienteVo() {
	}

	public RelatorioDeVendasPorClienteVo(String clienteString, Long numeroDePedidosInteger, BigDecimal montante) {
		this.setClienteString(clienteString);
		this.setNumeroDePedidosInteger(numeroDePedidosInteger);
		this.setMontante(montante);
	}

	public String getClienteString() {
		return clienteString;
	}

	public void setClienteString(String clienteString) {
		this.clienteString = clienteString;
	}

	public Long getNumeroDePedidosInteger() {
		return numeroDePedidosInteger;
	}

	public void setNumeroDePedidosInteger(Long numeroDePedidosInteger) {
		this.numeroDePedidosInteger = numeroDePedidosInteger;
	}

	public BigDecimal getMontante() {
		return montante;
	}

	public void setMontante(BigDecimal montante) {
		this.montante = montante;
	}

	@Override
	public String toString() {
		return "Cliente = " + clienteString + ", Numero de Pedidos = " + numeroDePedidosInteger + ", montante = "
				+ montante + "]";
	}

}
