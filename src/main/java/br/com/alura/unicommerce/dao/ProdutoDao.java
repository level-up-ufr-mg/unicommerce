package br.com.alura.unicommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Produto;

public class ProdutoDao {
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public Produto buscaPorId(Long id) {
		return em.find(Produto.class, id);
	}
	
	public void cadastra(Produto produto) {
		this.em.persist(produto);
	}

	public List<Produto> listaTodos() {
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}

<<<<<<< HEAD
<<<<<<< HEAD
	
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
=======
	public List<Produto> listaIndisponiveis(Categoria categoria) {
		String jpql = "SELECT c FROM Categoria c WHERE c.categoria = :categoria";
		return em.createQuery(jpql, Produto.class)
				.setParameter("categoria", categoria)
>>>>>>> ab5d880 (Adicionando funções)
=======
	public List<Produto> listaIndisponiveis(Integer quantidade_estoque, String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.quantidade_estoque = :quantidade_estoque, p.nome = :nome";
		return em.createQuery(jpql, Produto.class)
				.setParameter("quantidade_estoque", quantidade_estoque)
	             .setParameter("nome", nome)
>>>>>>> 241f2c3 (Alterando funcções)
				.getResultList();
	}
	
	/*public listaIndisponiveis(EntityManager em, Categoria categoria) {
	    String jpql = "SELECT p FROM Produto p WHERE p.categoria = :categoria AND p.quantidadeEmEstoque = 0";
	    List<Produto> produtosIndisponiveis = em.createQuery(jpql, Produto.class)
	            .setParameter("categoria", categoria)
	            .getResultList();
	    }*/
}
