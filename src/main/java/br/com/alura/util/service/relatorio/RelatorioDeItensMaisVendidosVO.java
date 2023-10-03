package br.com.alura.util.service.relatorio;

public class RelatorioDeItensMaisVendidosVO {

	private String NOMEPRODUTO;
	private Long Quantidade;

	public RelatorioDeItensMaisVendidosVO() {

	}

	public RelatorioDeItensMaisVendidosVO(String nOMEPRODUTO, Long quantidade) {
		NOMEPRODUTO = nOMEPRODUTO;
		Quantidade = quantidade;
	}

	public String getNOMEPRODUTO() {
		return NOMEPRODUTO;
	}

	public Long getQuantidade() {
		return Quantidade;
	}

	public void setNOMEPRODUTO(String nOMEPRODUTO) {
		NOMEPRODUTO = nOMEPRODUTO;
	}

	public void setQuantidade(Long quantidade) {
		Quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "RelatorioDeItensMaisVendidosVO [NOMEPRODUTO=" + NOMEPRODUTO + ", Quantidade=" + Quantidade + "]";
	}

}
