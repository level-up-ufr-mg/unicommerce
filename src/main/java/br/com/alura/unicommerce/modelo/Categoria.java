package br.com.alura.unicommerce.modelo;

import br.com.alura.unicommerce.dto.DadosCadastraCategoria;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Boolean status = true;

	public Categoria() {
	}

	public Categoria(String nome) throws IllegalArgumentException {
		this.setNome(nome);

	}

	public Categoria(String nome, Boolean status) {
		this.nome = nome;
		this.status = status;
	}

	public Categoria(DadosCadastraCategoria dados) {
		this.nome = dados.nome();
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
		if (nome == null) {
			throw new IllegalArgumentException("Nome inválido, o nome da categoria não pode ser nula.");
		}

		if (nome.isEmpty()) {
			throw new IllegalArgumentException("Nome inválido, o nome da categoria não pode ser vazio.");
		}

		this.nome = nome;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Categoria [nome=" + nome + ", status=" + status + "]";
	}
}
