package br.com.alura.unicommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.util.JPAUtil;
import br.com.alura.unicommerce.vo.RelatorioVendasPorCategoriaVo;


public class CategoriaDao {
	
	private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
   }

//	private EntityManager em = new JPAUtil().getEntityManager();
	
    public Categoria buscaPorId(Integer id) {
        return em.find(Categoria.class, id);
    }
    
    public void cadastra(Categoria categoria) {
        this.em.persist(categoria);
    }
    
    public List<Categoria> listaTodos() {
    	String jpql = " SELECT c FROM Categoria c "; 
        return  em.createQuery(jpql, Categoria.class).getResultList();
    }
    
    public List<RelatorioVendasPorCategoriaVo> relatorioVendasPorCategoria() {
        String jpql = " SELECT new br.com.alura.unicommerce.vo.RelatorioVendasPorCategoriaVo( "
	        		+ " c.nome, SUM(item.quantidade), "
	        		+ " SUM(item.quantidade * item.produto.preco)) "
	        		+ " FROM Pedido pedido "
	        		+ " JOIN pedido.itens item "
	        		+ " JOIN item.produto p "
	        		+ " JOIN p.categoria c "
	        		+ " GROUP BY c.nome ";
        
        return em.createQuery(jpql, RelatorioVendasPorCategoriaVo.class).getResultList();
    }

    

}
