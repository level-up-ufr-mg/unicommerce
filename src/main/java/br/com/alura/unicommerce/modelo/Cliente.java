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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID",nullable = false)
	private Long clienteId;
	
	@Column(name ="nome",nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private Long cpf;
	
	@Column(nullable = false)
	private Long telefone;
	
	@Embedded
	private Endereco tipoDesconto;

	public Cliente() {
	} 

	public Cliente(Long cLIENTE_ID, String nOME, Long cPF, Long tELEFONE, Endereco endereco) {
		super();
		clienteId = cLIENTE_ID;
		nome = nOME;
		cpf = cPF;
		telefone = tELEFONE;
		this.tipoDesconto = endereco;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public String getNome() {
		return nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public Long getTelefone() {
		return telefone;
	}

	public Endereco getTipoDesconto() {
		return tipoDesconto;
	}

	public void setClienteId(Long cLIENTE_ID) {
		clienteId = cLIENTE_ID;
	}

	public void setNome(String nOME) {
		nome = nOME;
	}

	public void setCpf(Long cPF) {
		cpf = cPF;
	}

	public void setTelefone(Long tELEFONE) {
		telefone = tELEFONE;
	}

	public void setTipoDesconto(Endereco endereco) {
		this.tipoDesconto = endereco;
	}

	@Override
	public String toString() {
		return "Cliente [ClienteId=" + clienteId + ", Nome=" + nome + ", Cpf=" + cpf + ", Telefone=" + telefone
				+ ", TipoDesconto=" + tipoDesconto + "]";
	}

	
}
