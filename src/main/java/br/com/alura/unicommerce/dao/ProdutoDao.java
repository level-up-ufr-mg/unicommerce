package br.com.alura.unicommerce.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

	// Busca pela quantidade em estoque igual a 0
	public List<Produto> listaIndisponiveis(Integer quantidade_estoque) {
		String jpql = "SELECT p FROM Produto p WHERE p.quantidade_estoque = :quantidade_estoque"; // Utilizando
																									// :parâmetro
		return em.createQuery(jpql, Produto.class).setParameter("quantidade_estoque", quantidade_estoque)
				.getResultList();
	}

	public List<Produto> listaIndisponiveis02(Integer quantidade_estoque) {
		String jpql = "SELECT p FROM Produto p WHERE p.quantidade_estoque = ?1"; // Utilizando ?1
		return em.createQuery(jpql, Produto.class).setParameter("?1", quantidade_estoque).getResultList();
	}

	public List<Produto> produtosPorCategoria(String nome) {
		return em.createNamedQuery("Produto.produtosPorCategoria", Produto.class).setParameter("nome", nome)
				.getResultList();
	}

	public List<Produto> buscaPorParametros(String nome, BigDecimal preco, LocalDate dataCadastro) {
		String jpql = "SELECT p FROM Produto p where 1 = 1 ";
		if (nome != null && !nome.trim().isEmpty()) {
			jpql = " AND p.nome = :nome ";
		}

		if (preco != null) {
			jpql = " AND p.preco = :preco ";
		}

		if (dataCadastro != null) {
			jpql = " AND p.dataCadastro = :dataCadastro ";
		}
		TypedQuery<Produto> query = em.createQuery(jpql, Produto.class);
		if (nome != null && !nome.trim().isEmpty()) {
			query.setParameter("nome", nome);
		}

		if (preco != null) {
			query.setParameter("preco", preco);
		}

		if (dataCadastro != null) {
			query.setParameter("dataCadastro", dataCadastro);
		}
		return query.getResultList();
	}
}
