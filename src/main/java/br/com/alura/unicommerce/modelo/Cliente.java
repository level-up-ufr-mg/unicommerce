package br.com.alura.unicommerce.modelo;

import java.util.ArrayList;
import java.util.List;

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
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 120)
	private String nome;
	
	//columnDefinition = "CHAR(11)"
	@Column(name = "cpf",  length = 14, unique = true, nullable = false)
	private String cpf;
	
	@Column(name = "telefone",  length = 14)
	private String telefone;
	
	//@OneToOne(fetch = FetchType.LAZY)
	@Embedded
	private Endereco endereco;
	
	
	 @OneToMany(mappedBy = "cliente") 
	 private  List<Pedido> pedidos = new ArrayList<>();
	
	public Cliente() {
		
	}

	public Cliente(String nome, String cpf, String telefone, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	public Cliente(String nome, String cpf, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", endereco="
				+ "]";
	}
}
