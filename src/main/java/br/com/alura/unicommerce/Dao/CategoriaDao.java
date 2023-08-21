package br.com.alura.unicommerce.Dao;

import java.util.List;

import br.com.alura.unicommerce.entidades.Categoria;
import jakarta.persistence.EntityManager;

public class CategoriaDao {

	
	
	 private EntityManager  em;

	public CategoriaDao(EntityManager manager) {
		this.em = manager;
	}
	 
	public void cadastra (Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void Atualizr(Categoria categoria) {
		this.em.merge(categoria); 
	}
 
	public void remover(Categoria celulares) {
		celulares =  this.em.merge(celulares);
		this.em.remove(celulares);
		
	}
	
	
	public Categoria buscaProID(Long ID ) {
		return em.find(Categoria.class, ID);
	}
	
	public List<Categoria> BuscarTodos(){
	String jpql = "SELECT c FROM Categoria c ";
		return em.createQuery(jpql , Categoria.class).getResultList();
	}
	
	public List< Categoria>listaPorNomesClientes(){
		String jpql = " SELECT c FROM Categoria c ORDER BY c.NOME ASC";
		return em.createQuery(jpql,Categoria.class).getResultList();
		
	}
}
