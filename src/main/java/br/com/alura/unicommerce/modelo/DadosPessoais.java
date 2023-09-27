package br.com.alura.unicommerce.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DadosPessoais {
	@Column(name = "Nome", length = 100, nullable = false) // Definindo o tamanho máximo para o campo nome
	private String nome;
	
	@Column(name = "CPF", length = 14, nullable = false) // Definindo o tamanho máximo para o campo cpf
	private String cpf;
	
	@Column(name = "Telefone", length = 15, nullable = false) // Definindo o tamanho máximo para o campo telefone
	private String telefone;

	//Construtores
	
	public DadosPessoais() {
	}

	public DadosPessoais(String nome, String cpf, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}
	
	//Getters and Setters
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
