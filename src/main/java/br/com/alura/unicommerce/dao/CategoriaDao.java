package br.com.alura.unicommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.vo.RelatorioDeVendasPorCategoriaVo;

public class CategoriaDao {
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}

	public Categoria buscaPorId(Long id) {
		if (id == null)
			throw new IllegalArgumentException();
		Categoria encontrada = em.find(Categoria.class, id);
		return encontrada;
	}

	public void cadastra(Categoria categoria) {
		em.persist(categoria);
	}

	public void atualiza(Categoria categoria) {
		em.merge(categoria);
	}

	public void remove(Categoria categoria) {
		em.remove(categoria);
	}

	public List<Categoria> listaTodas() {
		String jpql = "SELECT c FROM Categoria c";
		return em.createQuery(jpql, Categoria.class).getResultList();
	}

	public List<RelatorioDeVendasPorCategoriaVo> relatorioDeVendasPorCategoriaVo() {
		String jpql = "SELECT new br.com.alura.unicommerce.vo.RelatorioDeVendasVo(" + "categoria.nome, "
				+ "SUM(item.quantidade), " + "SUM(item.quantidade * (item.precoUnitario - item.desconto)) as montante) "
				+ "FROM Pedido pedido " + "RIGHT JOIN pedido.itens item " + "JOIN item.produto produto "
				+ "JOIN produto.categoria categoria " + "GROUP BY categoria.nome, item.quantidade "
				+ "ORDER BY categoria.nome ";
		return em.createQuery(jpql, RelatorioDeVendasPorCategoriaVo.class).getResultList();
	}

}
