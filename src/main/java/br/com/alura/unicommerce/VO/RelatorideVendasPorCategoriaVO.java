package br.com.alura.unicommerce.VO;

import java.math.BigDecimal;

public class RelatorideVendasPorCategoriaVO {

	private String Nome;
	private Long QUANTIDADE;
	private BigDecimal TOTAL;

	public RelatorideVendasPorCategoriaVO() {

	} 

	public RelatorideVendasPorCategoriaVO(String nome, Long qUANTIDADE, BigDecimal tOTAL) {
		Nome = nome;
		QUANTIDADE = qUANTIDADE;
		TOTAL = tOTAL;

	} 

	public String getNome() {
		return Nome;
	}

	public Long getQUANTIDADE() {
		return QUANTIDADE;
	}
 
	public BigDecimal getTOTAL() {
		return TOTAL;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public void setQUANTIDADE(Long qUANTIDADE) {
		QUANTIDADE = qUANTIDADE;
	}

	public void setTOTAL(BigDecimal tOTAL) {
		TOTAL = tOTAL;
	}

	@Override
	public String toString() {
		return "RelatorideVendasPorCategoriaVO [Nome= " + Nome + ", QUANTIDADE= " + QUANTIDADE + ", TOTAL= " + TOTAL;
	}

}
 