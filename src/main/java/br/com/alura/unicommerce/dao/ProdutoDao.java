package br.com.alura.unicommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.alura.unicommerce.modelo.Produto;

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
}
