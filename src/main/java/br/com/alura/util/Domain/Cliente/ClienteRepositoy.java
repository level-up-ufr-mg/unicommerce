package br.com.alura.util.Domain.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositoy extends JpaRepository<Cliente, Long> {

	 boolean existsByCpf(Long novoCPF);

 



	 

	
	
	
	
	
	
	
//	
//	
//	 private EntityManager  em;
// 
//	public ClienteDao(EntityManager manager) {
//		this.em = manager;
//	}
//	 
//	public void cadastra (ClienteEntity cliente) {
//		this.em.persist(cliente);
//	} 
//	 
//
//	public void Atualizr(ClienteEntity Cliente) {
//		this.em.merge(Cliente);
//	}
//
//	public void remover(ClienteEntity cliente) {
//		cliente = this.em.merge(cliente);
//		this.em.remove(cliente);
//	}  
//	
//	public ClienteEntity buscaProID(Long ID ) {
//		return em.find(ClienteEntity.class, ID);
//	}
//	
//	public List<ClienteEntity> BuscarTodos(){
//	String jpql = "SELECT c FROM Cliente c ";
//		return em.createQuery(jpql , ClienteEntity.class).getResultList();
//	}
//	
//	public List< ClienteEntity>listaPorNomesClientes(){
//		String jpql = " SELECT c FROM Cliente c ORDER BY c.NOME ASC";
//		return em.createQuery(jpql,ClienteEntity.class).getResultList();
//		
//	}
//	
//	
	
	
}
