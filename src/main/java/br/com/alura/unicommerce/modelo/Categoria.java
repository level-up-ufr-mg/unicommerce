package br.com.alura.unicommerce.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "unicommerce", name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long categoriaId;
	private String nome;
	private String status;

	public Categoria() {
	}


	public Categoria(String nome) throws IllegalArgumentException{
		 this.setNomes(nome);
	}
	
	 
	public void setNomes(String nome) {
		if (nome== null) {

			throw new IllegalArgumentException("Nome inválido, o nome da categoria não pode ser nula");
		}else if (nome.isEmpty()) {
			throw new IllegalArgumentException("Nome inválido, o nome da categoria não pode ser nula");
		}
		this.nome = nome;
	}


	public Categoria(Long iD, String nOME, String sTATUS) {
		categoriaId = iD;
		nome = nOME;
		status = sTATUS;
	}

	public Long getID() {
		return categoriaId;
	}

	public String getNome() {
		return nome;
	}

	public String getStatus() {
		return status;
	}

	public void setID(Long iD) {
		categoriaId = iD;
	}

	public void setNome(String nOME) {
		nome = nOME;
	}

	public void setStatus(String sTATUS) {
		status = sTATUS;
	}

	@Override
	public String toString() {
		return "CATEGORIA ID = " + categoriaId + "\n- NOME da categoria = " + nome + "\n- STATUS = " + status + " ";
	}

}
