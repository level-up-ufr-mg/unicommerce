package br.com.alura.unicommerce.dao;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Categoria;

public class CategoriaDao {
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void buscarPorId(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void listaTodas(Categoria categoria) {
		this.em.persist(categoria);
	}
	
}
