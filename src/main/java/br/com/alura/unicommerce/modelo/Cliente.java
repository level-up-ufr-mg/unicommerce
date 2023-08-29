package br.com.alura.unicommerce.modelo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "unicommerce", name = "cliente")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long CLIENTE_ID;
	@Column(nullable = false)
	private String NOME;
	@Column(nullable = false)
	private Long CPF;
	@Column(nullable = false)
	private Long TELEFONE;
	@Embedded
	private Endereco endereco;

	public Cliente() {
	}

	public Cliente(Long cLIENTE_ID, String nOME, Long cPF, Long tELEFONE, Endereco endereco) {
		super();
		CLIENTE_ID = cLIENTE_ID;
		NOME = nOME;
		CPF = cPF;
		TELEFONE = tELEFONE;
		this.endereco = endereco;
	}

	public Long getCLIENTE_ID() {
		return CLIENTE_ID;
	}

	public String getNOME() {
		return NOME;
	}

	public Long getCPF() {
		return CPF;
	}

	public Long getTELEFONE() {
		return TELEFONE;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setCLIENTE_ID(Long cLIENTE_ID) {
		CLIENTE_ID = cLIENTE_ID;
	}

	public void setNOME(String nOME) {
		NOME = nOME;
	}

	public void setCPF(Long cPF) {
		CPF = cPF;
	}

	public void setTELEFONE(Long tELEFONE) {
		TELEFONE = tELEFONE;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Cliente [CLIENTE_ID=" + CLIENTE_ID + ", NOME=" + NOME + ", CPF=" + CPF + ", TELEFONE=" + TELEFONE
				+ ", endereco=" + endereco + "]";
	}

}
