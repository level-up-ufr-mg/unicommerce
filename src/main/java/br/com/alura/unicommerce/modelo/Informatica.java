package br.com.alura.unicommerce.modelo;

import javax.persistence.Entity;

@Entity
public class Informatica extends Produto {
	private String marca;
	private Integer modelo;

	// Construtores

	public Informatica() {
	}

	public Informatica(String marca, Integer modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}

	// Getters e Setters

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getModelo() {
		return modelo;
	}

	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}
}
