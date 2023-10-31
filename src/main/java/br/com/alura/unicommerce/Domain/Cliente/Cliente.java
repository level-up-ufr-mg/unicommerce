package br.com.alura.unicommerce.Domain.Cliente;

import br.com.alura.unicommerce.DTO.DadosCadastraCliente;
import br.com.alura.unicommerce.Domain.Endereco;
import br.com.alura.unicommerce.Domain.Usuario.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Usuario usuario;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cpf;
	@Column(nullable = false)
	private String telefone;
	@Embedded
	private Endereco endereco;
//	@OneToOne
//	@NotNull
//	@JoinColumn(name = "usuario_id", nullable = false)
//	private Usuario usuario;

	public Cliente() {
	}

	public Cliente(String nome, String cpf, String telefone, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
//		this.usuario = usuario;
	}

	public Cliente(DadosCadastraCliente dados) {
		this.nome = dados.nome();
		this.cpf = dados.cpf();
		this.telefone = dados.telefone();
		this.endereco = new Endereco(dados.endereco());
	}

//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}

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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}