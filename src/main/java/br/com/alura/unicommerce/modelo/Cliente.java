package br.com.alura.unicommerce.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
	
	@Embedded
	private Endereco endereco;
	
	
	@OneToMany(mappedBy = "cliente", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	 private  List<Pedido> pedidos = new ArrayList<>();
	
	public Cliente() {
		
	}

	public Cliente(String nome, String cpf, String telefone, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	/*
	 * public Cliente(String nome, String cpf, String telefone) { this.nome = nome;
	 * this.cpf = cpf; this.telefone = telefone; }
	 * 
	 * public Cliente(ClienteDTO dados) { this.id = dados.getId(); this.nome =
	 * dados.getNome(); this.cpf = dados.getCpf(); this.telefone =
	 * dados.getTelefone(); this.endereco = new Endereco(dados.getEndereco()); }
	 */

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

	public Endereco getEndereco() {
		return endereco;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf, endereco, id, nome, pedidos, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(endereco, other.endereco)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(pedidos, other.pedidos) && Objects.equals(telefone, other.telefone);
	}


	
}
