package br.com.alura.unicommerce.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.vo.RelatorioProdutosMaisVendidosVo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
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
    	String jpql = " SELECT c FROM Produto p "; 
        return  em.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> listaIndisponiveis() {
    	String jpql = " SELECT p FROM Produto p WHERE p.quantidade_estoque = 0 ";
    	return  em.createQuery(jpql, Produto.class).getResultList();
    }
    
    public List<RelatorioProdutosMaisVendidosVo> relatorioProdutosMaisVendidos() {
    
		String jpql = " SELECT new br.com.alura.unicommerce.vo.RelatorioProdutosMaisVendidosVo( "
					+ " item.produto.nome ) "
				    + " FROM Pedido pedido "
   			        + " JOIN pedido.itens item "
   			        + " JOIN item.produto produto "
				  	+ " GROUP BY produto.id "
					+ " HAVING COUNT(item) > 3";
		
		return  em.createQuery(jpql, RelatorioProdutosMaisVendidosVo.class).getResultList();

    }
    
    
    //CURSO
    
    //Aqui chama aquela consulta jpql que está sendo feita na entidade Produto 
    public List<Produto> buscaProdutosPorCategoria(String nome) {
    	return  em.createNamedQuery("Produto.produtosPorCategoria", Produto.class)
    			.setParameter("nome", nome)
    			.getResultList();
    }
    
    //fazendo com que os paramentros não sejam obrigatorios
    public List<Produto> buscarPoParametros(String nome, BigDecimal preco){
    	String jpql = " SELECT p FROM Produto p WHERE 1=1 ";
    	if (nome != null && !nome.trim().isEmpty()) {
    		jpql = " AND p.nome = :nome ";
    	}
    	if (preco != null) {
    		jpql = " AND p.preco = :preco ";
    	}
    	TypedQuery<Produto> query = em.createQuery(jpql, Produto.class);
    	if (nome != null && !nome.trim().isEmpty()) {
    		query.setParameter("nome", nome);
    	}
    	if (preco != null) {
    		query.setParameter("preco", preco);
    	}
    	return query.getResultList();
    }
//    //agora vamos fazer a mesma consulta acima do metodo buscarPorParametros só que com o Criteria 
//    public List<Produto> buscarPoParametrosComCriteria(String nome, BigDecimal preco){
//    	CriteriaBuilder builder = em.getCriteriaBuilder();
//    	CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
//    	query.from(Produto.class);
//    	Root<Produto> from = query.from(Produto.class);
//    	
//    	Predicate filtros = builder.and();
//    	if (nome != null && !nome.trim().isEmpty()) {
//    		builder.and(filtros, builder.equal(from.get("nome"), nome));
//    	}
//    	if (preco != null) {
//    		builder.and(filtros, builder.equal(from.get("preco"), preco));
//    	}
//    	query.where(filtros);
//    	return em.createQuery(query).getResultList();
//    }
    
    
    
}
