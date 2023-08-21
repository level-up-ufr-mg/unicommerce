package br.com.alura.unicommerce.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "unicommerce", name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long CLIENTE_ID;
	private String NOME;
	private Long CPF;
	private Long TELEFONE;
	private String RUA;
	private Long NUMERO;
	private String COMPLEMENTO;
	private String BAIRRO;
	private String CIDADE;
	private String ESTADO;

	public Cliente() {
	}

	public Cliente(Long iD, String nOME, Long cPF, Long tELEFONE, String rUA, Long nUMERO, String cOMPLEMENTO,
			String bAIRRO, String cIDADE, String eSTADO) {
		CLIENTE_ID = iD;
		NOME = nOME;
		CPF = cPF;
		TELEFONE = tELEFONE;
		RUA = rUA;
		NUMERO = nUMERO;
		COMPLEMENTO = cOMPLEMENTO;
		BAIRRO = bAIRRO;
		CIDADE = cIDADE;
		ESTADO = eSTADO;
	}

	public Long getID() {
		return CLIENTE_ID;
	}

	public void setID(Long iD) {
		CLIENTE_ID = iD;
	}

	public String getNOME() {
		return NOME;
	}

	public void setNOME(String nOME) {
		NOME = nOME;
	}

	public Long getCPF() {
		return CPF;
	}

	public void setCPF(Long cPF) {
		CPF = cPF;
	}

	public Long getTELEFONE() {
		return TELEFONE;
	}

	public void setTELEFONE(Long tELEFONE) {
		TELEFONE = tELEFONE;
	}

	public String getRUA() {
		return RUA;
	}

	public void setRUA(String rUA) {
		RUA = rUA;
	}

	public Long getNUMERO() {
		return NUMERO;
	}

	public void setNUMERO(Long nUMERO) {
		NUMERO = nUMERO;
	}

	public String getCOMPLEMENTO() {
		return COMPLEMENTO;
	}

	public void setCOMPLEMENTO(String cOMPLEMENTO) {
		COMPLEMENTO = cOMPLEMENTO;
	}

	public String getBAIRRO() {
		return BAIRRO;
	}

	public void setBAIRRO(String bAIRRO) {
		BAIRRO = bAIRRO;
	}

	public String getCIDADE() {
		return CIDADE;
	}

	public void setCIDADE(String cIDADE) {
		CIDADE = cIDADE;
	}

	public String getESTADO() {
		return ESTADO;
	}

	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}

}
