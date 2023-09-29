package br.com.alura.unicommerce.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente{
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Embedded
	private DadosPessoais dadosPessoais;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST)
	private List<Pedido> pedido = new ArrayList<>();

	@Embedded
	private Endereco endereco;

	// Construtor

	public Cliente() {
	}

	public Cliente(String nome, String cpf, String telefone, Endereco endereco) {
		this.dadosPessoais = new DadosPessoais(nome, cpf, telefone);
		this.endereco = endereco;
	}

	// Getters e Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.dadosPessoais.getNome();
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", dadosPessoais=" + dadosPessoais + ", pedido=" + pedido + ", endereco="
				+ endereco + "]";
	}
}
