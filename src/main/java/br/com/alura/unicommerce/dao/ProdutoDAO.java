package br.com.alura.unicommerce.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Produto;

public class ProdutoDao {

	private EntityManager em;

	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id);
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}	
	
	public List<Produto> buscarTodos() {
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}
	
	public BigDecimal buscarProdutoIndisponivel() {
		String jpql = "SELECT p.preco FROM Produto p WHERE p.preço = 0 ";
		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
			
	}
	
	//teste commit

}
