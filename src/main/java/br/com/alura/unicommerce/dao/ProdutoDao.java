package br.com.alura.unicommerce.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.alura.unicommerce.Relatorios.RelatorioDeVendasPorProdutoVendidoVo;
import br.com.alura.unicommerce.modelo.Produto;

public class ProdutoDao {
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public Produto buscaPorId(Long id) {
		if (id == null)
			throw new IllegalArgumentException();
		Produto encontrado = em.find(Produto.class, id);
		return encontrado;
	}

	public void cadastra(Produto produto) {
		em.persist(produto);
	}

	public void atualiza(Produto produto) {
		em.merge(produto);
	}

	public void remove(Produto produto) {
		em.remove(produto);
	}

	public List<Produto> listaTodos() {
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}

	// Busca pela quantidade em estoque igual a 0
	public List<Produto> listaIndisponiveis(Integer quantidade_estoque) {
		String jpql = "SELECT p FROM Produto p WHERE p.quantidade_estoque = :quantidade_estoque"; // Utilizando
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

	public List<Produto> buscarPorParametrosComCriteria(String nome, BigDecimal preco, LocalDate dataCadastro) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
		Root<Produto> from = query.from(Produto.class);

		Predicate filtros = builder.and();
		if (nome != null && !nome.trim().isEmpty()) {
			filtros = builder.and(filtros, builder.equal(from.get("nome"), nome));
		}
		if (preco != null) {
			filtros = builder.and(filtros, builder.equal(from.get("preco"), preco));
		}
		if (dataCadastro != null) {
			filtros = builder.and(filtros, builder.equal(from.get("dataCadastro"), dataCadastro));
		}
		query.where(filtros);
		return em.createQuery(query).getResultList();
	}

	public List<RelatorioDeVendasPorProdutoVendidoVo> relatorioDeVendasPorProdutoVendidoVo() {
		String jpql = "SELECT new br.com.alura.unicommerce.vo.RelatorioDeVendasPorProdutoVendidoVo(" + "prod.nome, "
				+ "COUNT(it.quantidade)) " + "FROM Produto prod " + "JOIN prod.itens it " + "JOIN it.pedido ped "
				+ "GROUP BY prod.nome " + "HAVING count(it.quantidade) > 3";
		return em.createQuery(jpql, RelatorioDeVendasPorProdutoVendidoVo.class).getResultList();
	}
}
