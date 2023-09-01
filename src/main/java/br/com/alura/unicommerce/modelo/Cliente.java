package br.com.alura.unicommerce.modelo;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(length = 20) // Definindo o tamanho máximo para o campo ID
	private Long id;

	@Embedded
	private Endereco endereco;

	@Column(length = 50) // Definindo o tamanho máximo para o campo nome
	private String nome;

	@Column(length = 14) // Definindo o tamanho máximo para o campo cpf
	private String cpf;

	@Column(length = 15) // Definindo o tamanho máximo para o campo telefone
	private String telefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Cliente() {
		super();
	}
	
	
	
}
