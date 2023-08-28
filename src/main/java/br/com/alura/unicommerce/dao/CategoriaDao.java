package br.com.alura.unicommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.vo.RelatorioDeVendasCategoriaVo;

public class CategoriaDao {

	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void atualizar(Categoria categoria) {
		this.em.merge(categoria);
	}
	
	public void remover(Categoria categoria) {
		categoria = em.merge(categoria);
		this.em.remove(categoria);
	}
	
	public Categoria buscarPorId(Long id) {
		return em.find(Categoria.class, id);
	}
	
	public List<Categoria> buscarTodos() {
		String jpql = "SELECT p FROM Categoria p";
		return em.createQuery(jpql, Categoria.class).getResultList();
	}
	
	public List<Categoria> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Categoria p WHERE P.nome = :nome";
		return em.createQuery(jpql, Categoria.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	 public List<RelatorioDeVendasCategoriaVo> relatorioDeVendas() {
		 String jpql = "SELECT new br.com.alura.unicommercevo.RelatorioDeVendasCategoriaVo("
		 		+ "categoria.nome, "
		 		+ "SUM(item.quantidade), "
		 		+ "MAX(pedido.data)) "
		 		+ "FROM Pedido pedido "
		 		+ "JOIN pedido.itens item "
		 		+ "JOIN item.produto produto "
		 		+ "GROUP BY produto.nome "
		 		+ "ORDER BY item.quantidade DESC ";
		 return em.createQuery(jpql, RelatorioDeVendasCategoriaVo.class)
				 .getResultList();
	 }
	
	
}
