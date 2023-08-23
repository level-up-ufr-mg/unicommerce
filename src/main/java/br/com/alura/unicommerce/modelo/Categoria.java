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
	private Long CATEGORIA_ID;
	private String NOME;
	private String STATUS;

	public Categoria() {
	}

	public Categoria(Long iD, String nOME, String sTATUS) {
		CATEGORIA_ID = iD;
		NOME = nOME;
		STATUS = sTATUS;
	}

	public Long getID() {
		return CATEGORIA_ID; 
	}

	public String getNOME() {
		return NOME;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setID(Long iD) {
		CATEGORIA_ID = iD;
	}

	public void setNOME(String nOME) {
		NOME = nOME;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	
	
 

	@Override
	public String toString() {
		return "CATEGORIA ID = " + CATEGORIA_ID + "\n- NOME da categoria = " + NOME + "\n- STATUS = " + STATUS + " ";
	}

	
	 
	
}
