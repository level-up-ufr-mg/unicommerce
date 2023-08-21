package br.com.alura.unicommerce.Controller;

import java.util.List;

import br.com.alura.unicommerce.Dao.ClienteDao;
import br.com.alura.unicommerce.Factory.Factory;
import br.com.alura.unicommerce.entidades.Cliente;
import jakarta.persistence.EntityManager;

//service
public class ClienteController {

	public static void main(String[] args) {

		Cliente cliente = new Cliente(null, "Rosa", 2156248571524L, 99000101L, "rua x", 100L, "casa", "centro",
				"São paulo ", "SAO PAULO");

		EntityManager em = Factory.getEntityManager();
		ClienteDao ClienteDao = new ClienteDao(em);

//		Cadastro(cliente, em, ClienteDao);
//
//		Editar(cliente, em);
//	
//		Deletar(cliente, em);
//	

		BuscaPorID(ClienteDao);

		BuscaTodos(ClienteDao); 

		ListaPorNome(ClienteDao);

	}

	private static void BuscaPorID(ClienteDao ClienteDao) {
		Cliente c = ClienteDao.buscaProID(1L);
		System.out.print(c.getID() + " - " + c.getNOME() + " - " + c.getCPF() + " - " + c.getCOMPLEMENTO() + " - "
				+ c.getBAIRRO() + " - " + c.getCIDADE() + " - " + c.getESTADO() + " - " + c.getNUMERO() + " - "
				+ c.getRUA() + " - " + c.getNUMERO());
	}

	private static void BuscaTodos(ClienteDao ClienteDao) {
		List<Cliente> buscarTodos = ClienteDao.BuscarTodos();
		buscarTodos.forEach(c -> System.out.print(c.getID() + " - " + c.getNOME() + " - " + c.getCPF() + " - "
				+ c.getCOMPLEMENTO() + " - " + c.getBAIRRO() + " - " + c.getCIDADE() + " - " + c.getESTADO() + " - "
				+ c.getNUMERO() + " - " + c.getRUA() + " - " + c.getNUMERO() + "\n \n"));
	}

	private static void ListaPorNome(ClienteDao clienteDao) {
		
		List<Cliente> listaPorNomesClientes = clienteDao.listaPorNomesClientes();
		listaPorNomesClientes.forEach(c -> System.out.print(c.getID() + " - " + c.getNOME() +"\n \n" ) );
		

	
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

		cliente.setNOME("teste");

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
