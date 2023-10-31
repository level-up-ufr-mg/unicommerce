//package br.com.alura.unicommerce.dao;
//
//import java.util.List;
//
//import br.com.alura.unicommerce.Relatorios.RelatorioDeVendasPorCategoriaVo;
//import br.com.alura.unicommerce.modelo.Categoria;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.TypedQuery;
//
//public class CategoriaDao {
//	private EntityManager em;
//
//	public CategoriaDao(EntityManager em) {
//		this.em = em;
//	}
//
//	public Categoria buscaPorId(Long id) {
//		Categoria encontrada = em.find(Categoria.class, id);
//		return encontrada;
//	}
//
//	public void cadastra(Categoria categoria) {
//		em.persist(categoria);
//	}
//
//	public void atualiza(Categoria categoria) {
//		em.merge(categoria);
//	}
//
//	public void remove(Categoria categoria) {
//		em.remove(categoria);
//	}
//
//	public String buscaNomePorNome(String nome) {
//	    String jpql = "SELECT c.nome FROM Categoria c WHERE c.nome = :nome";
//	    TypedQuery<String> query = em.createQuery(jpql, String.class);
//	    query.setParameter("nome", nome);
//        return query.getSingleResult();
//	}
//
//
//	public List<Categoria> listaTodas() {
//		String jpql = "SELECT c FROM Categoria c";
//		return em.createQuery(jpql, Categoria.class).getResultList();
//	}
//
//	public List<RelatorioDeVendasPorCategoriaVo> relatorioDeVendasPorCategoriaVo() {
//		String jpql = "SELECT new br.com.alura.unicommerce.vo.RelatorioDeVendasPorCategoriaVo(" + "categoria.nome, "
//				+ "SUM(item.quantidade), " + "SUM(item.quantidade * (item.precoUnitario - item.desconto)) as montante) "
//				+ "FROM Pedido pedido " + "JOIN pedido.itens item " + "JOIN item.produto produto "
//				+ "JOIN produto.categoria categoria " + "GROUP BY categoria.nome, item.quantidade "
//				+ "ORDER BY categoria.nome ";
//		return em.createQuery(jpql, RelatorioDeVendasPorCategoriaVo.class).getResultList();
//	}
//
//}
