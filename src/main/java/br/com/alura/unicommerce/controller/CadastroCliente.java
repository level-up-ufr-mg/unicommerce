package br.com.alura.unicommerce.controller;

import java.util.List;

import br.com.alura.unicommerce.Dao.ClienteDao;
import br.com.alura.unicommerce.Util.Factory;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.Endereco;
import jakarta.persistence.EntityManager;

//service
public class CadastroCliente  { 

	public static void main(String[] args) {

		Endereco endereco = new Endereco("rua x", 100L, "casa", "centro",
				"São paulo ", "SAO PAULO");
		
		Cliente cliente = new Cliente(null, "Rosa", 2156248571524L, 99000101L, endereco);

		EntityManager em = Factory.getEntityManager();
		ClienteDao ClienteDao = new ClienteDao(em);

		
		Cadastro(cliente, em, ClienteDao);
// 
//		Editar(cliente, em);
//	
//		Deletar(cliente, em);
//	

	//	BuscaPorID(ClienteDao);

	//	BuscaTodos(ClienteDao); 

	//	ListaPorNome(ClienteDao);

	}

	private static void BuscaPorID(ClienteDao ClienteDao) {
		Cliente c = ClienteDao.buscaProID(1L);
		System.out.print(c.getClienteId() + " - " + c.getNome() + " - " + c.getCpf() + " - " + c.getTipoDesconto());
	}

	private static void BuscaTodos(ClienteDao ClienteDao) {
		List<Cliente> buscarTodos = ClienteDao.BuscarTodos();
		buscarTodos.forEach(c -> System.out.print(c.getClienteId() + " - " + c.getNome() + " - " + c.getCpf() + " - " + c.getTipoDesconto() + "\n \n"));
	}

	private static void ListaPorNome(ClienteDao clienteDao) {
		
		List<Cliente> listaPorNomesClientes = clienteDao.listaPorNomesClientes();
		listaPorNomesClientes.forEach(c -> System.out.print(c.getClienteId() + " - " + c.getNome() +"\n \n" ) );
		

	
	}

	private static void Deletar(Cliente cliente, EntityManager em) {
		// +++ DELETE +++
		em.getTransaction().begin();

		em.persist(cliente);// persist

		em.remove(cliente);
		// ou
		// ClienteDao.remover(cliente);

		em.flush();// ou .commit
	}

	private static void Editar(Cliente cliente, EntityManager em) {
		// +++ EDITAR +++
		em.getTransaction().begin();// inicio

		em.persist(cliente);// percist

		cliente.setNome("teste");

		em.getTransaction().commit();// para sincronizar ao BD sem fazer o comitt

		em.close(); // termino
	}

	private static void Cadastro(Cliente cliente, EntityManager em, ClienteDao ClienteDao) {
		// +++ CADASTRAR +++
		em.getTransaction().begin();// inicio

		ClienteDao.cadastra(cliente);

		em.getTransaction().commit();
		em.close();
	}

}
