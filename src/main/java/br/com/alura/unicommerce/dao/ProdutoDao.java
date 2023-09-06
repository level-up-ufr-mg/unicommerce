package br.com.alura.unicommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Produto;

public class ProdutoDao {
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public Produto buscaPorId(Long id) {
		return em.find(Produto.class, id);
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}

	public List<Produto> listaTodos() {
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}

	
	//Busca pela quantidade em estoque igual a 0
	public List<Produto> listaIndisponiveis(Integer quantidade_estoque) {
		String jpql = "SELECT p FROM Produto p WHERE p.quantidade_estoque = :quantidade_estoque"; //Utilizando :par
		return em.createQuery(jpql, Produto.class)
				.setParameter("quantidade_estoque", quantidade_estoque)
				.getResultList();
	}
	
	public List<Produto> listaIndisponiveis02(Integer quantidade_estoque) {
		String jpql = "SELECT p FROM Produto p WHERE p.quantidade_estoque = ?1"; //Utilizando ?1
		return em.createQuery(jpql, Produto.class)
				.setParameter("?1", quantidade_estoque)
				.getResultList();
	}
	
	
	public List<Produto> buscaPorNomeDaCategoria(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = ?1"; //Utilizando ?1
		return em.createQuery(jpql, Produto.class)
				.setParameter("?1", quantidade_estoque)
				.getResultList();
	}
}
