package br.com.alura.util.Categoria;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(schema = "unicommerce", name = "categoria")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "categoriaId" })
@Getter
@Setter
@ToString
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long categoriaId;
	@Column(name = "NOME")
	private String nome;
	@Column(name = "STATUS_ID")
	private Boolean status;

	public Categoria(@Valid DadosCadastroCategoriaDTO dados) {
		this.setNomes(dados.nome());
		this.status = true;
	}

	public Categoria(Categoria categoria) {
		this.setNome(categoria.nome);
	}

	public void AtualizarInformacoes(@Valid AtualizarDadosCategoriaDTO dados) {

		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.status() != null) {
			setStatus(dados.status());

		}
	}

	public void setNomes(String nome) {
		if (nome == null) {

			throw new IllegalArgumentException("Nome inválido, o nome da categoria não pode ser nula");
		} else if (nome.isEmpty()) {
			throw new IllegalArgumentException("Nome inválido, o nome da categoria não pode ser nula");
		}
		this.nome = nome;
	}


}
