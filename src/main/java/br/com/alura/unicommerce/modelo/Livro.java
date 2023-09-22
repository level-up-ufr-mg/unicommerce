package br.com.alura.unicommerce.modelo;

import javax.persistence.Entity;

@Entity
public class Livro extends Produto {
	private String autor;
	private Integer numeroDePaginasInteger;
	
	//	Construtor
	
	public Livro() {
	}

	public Livro(String autor, Integer numeroDePaginasInteger) {
		this.autor = autor;
		this.numeroDePaginasInteger = numeroDePaginasInteger;
	}

	//Getters e Setters
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Integer getNumeroDePaginasInteger() {
		return numeroDePaginasInteger;
	}
	public void setNumeroDePaginasInteger(Integer numeroDePaginasInteger) {
		this.numeroDePaginasInteger = numeroDePaginasInteger;
	}
	
	
}
