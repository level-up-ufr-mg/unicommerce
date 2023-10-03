package br.com.alura.util.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.util.domain.categoria.Categoria;
import br.com.alura.util.service.relatorio.RelatorideVendasPorCategoriaVO;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

 
	 boolean existsByNome(String nome);
	 
	 
	   @Query("SELECT NEW br.com.alura.util.service.relatorio.RelatorideVendasPorCategoriaVO("
	   		+ "c.nome, SUM(ip.quantidade), "
	   		+ "SUM(ip.precoUnitario * ip.quantidade - ip.desconto)) " +
	           "FROM Produto p " +
	            "INNER JOIN ItemPedido ip ON p.produtoId = ip.produtoId " +
	            "INNER JOIN Categoria c ON p.categoriaId.categoriaId = c.categoriaId " +
	            "GROUP BY c.nome")
	    Page<RelatorideVendasPorCategoriaVO> getRelatorioVendasPorCategoria(Pageable pageable);




	
//	
//	 private EntityManager  em;
//
//	public CategoriaDao(EntityManager manager) {
//		this.em = manager;
//	}
//	 
//	public void cadastra (Categoria categoria) {
//		this.em.persist(categoria);
//	}
//	
//	public void Atualizr(Categoria categoria) {
//		this.em.merge(categoria); 
//	}
// 
//	public void remover(Categoria celulares) {
//		celulares =  this.em.merge(celulares);
//		this.em.remove(celulares);
//		
//	}
//	
//	
//	public Categoria buscaProID(Long ID ) {
//		return em.find(Categoria.class, ID);
//	}
//	
//	public List<Categoria> BuscarTodos(){
//	String jpql = "SELECT c FROM Categoria c ";
//		return em.createQuery(jpql , Categoria.class).getResultList();
//	}
//	
//	public List< Categoria>listaPorNomesClientes(){
//		String jpql = " SELECT c FROM Categoria c ORDER BY c.NOME ASC";
//		return em.createQuery(jpql,Categoria.class).getResultList();
//		
//	}
}
