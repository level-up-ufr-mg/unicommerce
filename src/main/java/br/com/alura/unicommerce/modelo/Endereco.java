package br.com.alura.unicommerce.modelo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco implements Serializable {
	
	@Column(nullable = false)
	private String RUA;
	@Column(nullable = false)
	private Long NUMERO;
	@Column(nullable = false)
	private String COMPLEMENTO;
	@Column(nullable = false)
	private String BAIRRO;
	@Column(nullable = false)
	private String CIDADE;
	@Column(nullable = false)
	private String ESTADO;
	

	public Endereco() {

	}

	public Endereco(String rUA, Long nUMERO, String cOMPLEMENTO, String bAIRRO, String cIDADE, String eSTADO) {
		RUA = rUA;
		NUMERO = nUMERO;
		COMPLEMENTO = cOMPLEMENTO;
		BAIRRO = bAIRRO;
		CIDADE = cIDADE;
		ESTADO = eSTADO;
	}

	public String getRUA() {
		return RUA;
	}

	public Long getNUMERO() {
		return NUMERO;
	}

	public String getCOMPLEMENTO() {
		return COMPLEMENTO;
	}

	public String getBAIRRO() {
		return BAIRRO;
	}

	public String getCIDADE() {
		return CIDADE;
	}

	public String getESTADO() {
		return ESTADO;
	}

	public void setRUA(String rUA) {
		RUA = rUA;
	}

	public void setNUMERO(Long nUMERO) {
		NUMERO = nUMERO;
	}

	public void setCOMPLEMENTO(String cOMPLEMENTO) {
		COMPLEMENTO = cOMPLEMENTO;
	}

	public void setBAIRRO(String bAIRRO) {
		BAIRRO = bAIRRO;
	}

	public void setCIDADE(String cIDADE) {
		CIDADE = cIDADE;
	}

	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}

	@Override
	public String toString() {
		return "Endereco [RUA=" + RUA + ", NUMERO=" + NUMERO + ", COMPLEMENTO=" + COMPLEMENTO + ", BAIRRO=" + BAIRRO
				+ ", CIDADE=" + CIDADE + ", ESTADO=" + ESTADO + "]";
	}
	
	

}
