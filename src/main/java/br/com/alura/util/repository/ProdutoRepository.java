package br.com.alura.util.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.util.domain.produto.Produto;

public interface ProdutoRepository  extends JpaRepository<Produto, Long>{

	boolean existsByNome(String nomedoProduto);

	
	
	
	
	
	
	
	
//	private EntityManager em;
//
//	public ProdutoDao(EntityManager manager) {
//		this.em = manager;
//	}
//
//	public void cadastra(Produto produto) {
//		this.em.persist(produto);
//	}
//
//	public void Atualizr(Produto produto) {
//		this.em.merge(produto);
//	}
//
//	public void remover(Produto produto) {
//		produto = this.em.merge(produto);
//		this.em.remove(produto);
//
//	}
//
//	public Produto buscaProID(Long ID) {
//		return em.find(Produto.class, ID);
//	}
//
//	public List<Produto> BuscarTodos() {
//		String jpql = "SELECT p FROM Produto p ";
//		return em.createQuery(jpql, Produto.class).getResultList();
//	}
//
//	public List<Produto> BuscaIndisponives(String status) {
//	    String jpql = "SELECT p FROM Produto p INNER JOIN p.categoria c WHERE c.STATUS = :STATUS";
//	    return em.createQuery(jpql, Produto.class)
//	             .setParameter("STATUS", status)
//	             .getResultList();
//	}
//
//	
//	
//	
	
	
	
	
	
	
	
	
	
	
	
}
