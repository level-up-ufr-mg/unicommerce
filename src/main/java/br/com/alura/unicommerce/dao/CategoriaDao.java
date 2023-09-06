package br.com.alura.unicommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Cliente;

public class CategoriaDao {
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}

	public Categoria buscaPorId(Long id) {
		return em.find(Categoria.class, id);
	}
	
<<<<<<< HEAD
	public Cliente buscarPorId(Long id) {
		return em.find(Cliente.class, id);
	}
	
	public void cadastra(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void listaTodas(Categoria categoria) {
		this.em.persist(categoria);
=======
	public void cadastra(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public List<Categoria> listaTodos() {
		String jpql = "SELECT c FROM Categoria c";
		return em.createQuery(jpql, Categoria.class).getResultList();
>>>>>>> ab5d880 (Adicionando funções)
	}
	
}
