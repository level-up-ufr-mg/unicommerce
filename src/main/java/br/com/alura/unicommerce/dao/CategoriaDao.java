package br.com.alura.unicommerce.dao;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Cliente;

public class CategoriaDao {
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public Cliente buscarPorId(Long id) {
		return em.find(Cliente.class, id);
	}
	
	public void cadastra(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void listaTodas(Categoria categoria) {
		this.em.persist(categoria);
	}
	
}
