package br.com.alura.util.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.util.domain.cliente.Cliente;

public interface ClienteRepositoy extends JpaRepository<Cliente, Long> {

	 boolean existsByCpf(Long novoCPF);

 



	 

	
	
//		public List<RelatorioClientesFieisVO> getRelatorioClientesFieis(List<Pedido> listaComUmPedido) {
//		List<RelatorioClientesFieisVO> relatorioClientesFieisVOs = new ArrayList();
//		
//		listaComUmPedido.forEach(pedido ->	
//		{relatorioClientesFieisVOs.add( new RelatorioClientesFieisVO(pedido.getCliente().getNome(),1L, pedido.getValorTotal())); 
//		
//		});
//		return relatorioClientesFieisVOs;
//	}
	
	
	
	
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
