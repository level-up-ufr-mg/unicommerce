package br.edu.uniformg.unicommerce.modelo;

import javax.persistence.Embedded;
import javax.persistence.OneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {


    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    //FK
    private Endereco endereco_id;
    
    public Cliente() {
    	
    }
    
	public Cliente(String nome, String cpf, String telefone, Endereco endereco_id) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco_id = endereco_id;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@Embedded
	public Endereco getEndereco_id() {
		return endereco_id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", endereco_id="
				+ endereco_id + "]";
	}

}
