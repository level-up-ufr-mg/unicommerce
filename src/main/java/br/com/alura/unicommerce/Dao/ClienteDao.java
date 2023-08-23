package br.com.alura.unicommerce.Dao;

import java.util.List;

import br.com.alura.unicommerce.modelo.Cliente;
import jakarta.persistence.EntityManager;

public class ClienteDao {

	
	
	 private EntityManager  em;
 
	public ClienteDao(EntityManager manager) {
		this.em = manager;
	}
	 
	public void cadastra (Cliente cliente) {
		this.em.persist(cliente);
	} 
	

	public void Atualizr(Cliente Cliente) {
		this.em.merge(Cliente);
	}

	public void remover(Cliente cliente) {
		cliente = this.em.merge(cliente);
		this.em.remove(cliente);
	}  
	
	public Cliente buscaProID(Long ID ) {
		return em.find(Cliente.class, ID);
	}
	
	public List<Cliente> BuscarTodos(){
	String jpql = "SELECT c FROM Cliente c ";
		return em.createQuery(jpql , Cliente.class).getResultList();
	}
	
	public List< Cliente>listaPorNomesClientes(){
		String jpql = " SELECT c FROM Cliente c ORDER BY c.NOME ASC";
		return em.createQuery(jpql,Cliente.class).getResultList();
		
	}
	
	
	
	
}
