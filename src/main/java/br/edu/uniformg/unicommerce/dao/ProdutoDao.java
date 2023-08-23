package br.edu.uniformg.unicommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.uniformg.unicommerce.modelo.Produto;

/*
buscaPorId(id)
cadastra(Produto)
listaTodos()
listaIndisponiveis()
*/

public class ProdutoDao {
	
	private EntityManager em;
	
	public ProdutoDao(EntityManager em) {
		
	}

	
	public Produto buscaProdutoPorId(Long id) {
		return em.find(Produto.class, id);
	}
	
	public void cadastrarProduto(Produto p) {
		em.persist(p);
	}
	
	public List<Produto> listaProdutos(){
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}
	
	public List<Produto> listaProdutosIndisponivies(){
		String jpql = "SLECET p FROM Produto p WHERE p.quantidadeEstoque = 0 ";
		return em.createQuery(jpql, Produto.class).getResultList();
	}
}
