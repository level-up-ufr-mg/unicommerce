package br.com.alura.util.Domain.Endereco;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco implements Serializable {
	
	@Column(nullable = false)
	private String rua;
	@Column(nullable = false)
	private Long numero;
	@Column(nullable = false)
	private String complemento;
	@Column(nullable = false)
	private String bairro;
	@Column(nullable = false)
	private String cidade;
	@Column(nullable = false)
	private String estado;
	

    public String getLocal() {
        return cidade + " / " + estado;
    }
	public Endereco() {

	}

	public Endereco(String rUA, Long nUMERO, String cOMPLEMENTO, String bAIRRO, String cIDADE, String eSTADO) {
		rua = rUA;
		numero = nUMERO;
		complemento = cOMPLEMENTO;
		bairro = bAIRRO;
		cidade = cIDADE;
		estado = eSTADO;
	}

	public Endereco(Endereco endereco) {
		this.bairro = endereco.bairro;
		this.rua = endereco.rua;
		this.numero = endereco.numero;
		this.complemento = endereco.complemento;
		this.cidade = endereco.cidade ;
		this.estado = endereco.estado;
	}

	public String getRua() {
		return rua;
	}

	public Long getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setRua(String rUA) {
		rua = rUA;
	}

	public void setNumero(Long nUMERO) {
		numero = nUMERO;
	}

	public void setComplemento(String cOMPLEMENTO) {
		complemento = cOMPLEMENTO;
	}

	public void setBairro(String bAIRRO) {
		bairro = bAIRRO;
	}

	public void setCidade(String cIDADE) {
		cidade = cIDADE;
	}

	public void setEstado(String eSTADO) {
		estado = eSTADO;
	}

	@Override
	public String toString() {
		return "Endereco [RUA=" + rua + ", NUMERO=" + numero + ", COMPLEMENTO=" + complemento + ", BAIRRO=" + bairro
				+ ", CIDADE=" + cidade + ", ESTADO=" + estado + "]";
	}
	
	

}
