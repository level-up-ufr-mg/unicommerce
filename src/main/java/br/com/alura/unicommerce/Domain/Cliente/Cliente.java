package br.com.alura.unicommerce.Domain.Cliente;

import br.com.alura.unicommerce.DTO.DadosCadastroCliente;
import br.com.alura.unicommerce.Domain.Endereco.Endereco;
import br.com.alura.unicommerce.Domain.Usuario.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cpf;
	@Column(nullable = false)
	private String telefone;
	@Embedded
	private Endereco endereco;
	@OneToOne
	@NotNull
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	public Cliente() {
	}

	public Cliente(DadosCadastroCliente dados, Usuario dadosIdUsuario) {
		this.nome = dados.nome();
		this.cpf = dados.cpf();
		this.telefone = dados.telefone();
		this.endereco = new Endereco(dados.endereco());
    	this.usuario = dados.usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

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