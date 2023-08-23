package br.com.alura.unicommerce.dao;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Categoria;

public class CategoriaDao {
	
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrarCategoria(Categoria categoria) {
		this.em.persist(categoria);
	}

	public List<Categoria> buscarTodasCategorias() {
		String jpql = "SELECT c FROM Categoria c";
		return em.createQuery(jpql, Categoria.class).getResultList();
	}
	
	public Categoria buscarPorId(Long id) {
		return em.find(Categoria.class, id);
	}




}






