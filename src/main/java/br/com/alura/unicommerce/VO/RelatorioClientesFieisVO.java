package br.com.alura.unicommerce.VO;

import java.math.BigDecimal;

public class RelatorioClientesFieisVO {

    private String nomeCliente;
    private Long quantidade;
    private BigDecimal totalGasto;



    public RelatorioClientesFieisVO(String nomeCliente, Long quantidade, BigDecimal totalGasto) {
		super();
		this.nomeCliente = nomeCliente;
		this.quantidade = quantidade;
		this.totalGasto = totalGasto;
	}
    
	public String getNomeCliente() {
		return nomeCliente;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public BigDecimal getTotalGasto() {
		return totalGasto;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public void setTotalGasto(BigDecimal totalGasto) {
		this.totalGasto = totalGasto;
	}

	@Override
	public String toString() {
		return "RelatorioClientesFieisVO [nomeCliente=" + nomeCliente + ", quantidade=" + quantidade + "]";
	}
    
    
    
}
 