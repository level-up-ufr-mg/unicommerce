package br.com.alura.unicommerce.Controller;



import java.math.BigDecimal;
import java.sql.Timestamp;

import br.com.alura.unicommerce.Dao.ClienteDao;
import br.com.alura.unicommerce.Dao.PedidoDao;
import br.com.alura.unicommerce.Factory.Factory;
import br.com.alura.unicommerce.entidades.Cliente;
import br.com.alura.unicommerce.entidades.Pedido;
import jakarta.persistence.EntityManager;

//service
public class PedidoController {
	
	public static void main(String[] args) {
	
		Cliente cliente = new Cliente( null, "Luiz", 123456789012L , 99000101L, "rua x", 100L, "casa",
				"centro", "São paulo ", "SAO PAULO");
		Pedido pedido = new Pedido(null, new Timestamp(System.currentTimeMillis()), cliente, new BigDecimal("00"), "nenhum");
		
	EntityManager em = Factory.getEntityManager();
	ClienteDao ClienteDao = new ClienteDao(em );
	PedidoDao pedidoDao = new PedidoDao(em );
	Cadastra(cliente, pedido, em, ClienteDao, pedidoDao);
	
	  Editar(cliente, pedido, em, ClienteDao, pedidoDao);
	
	Deletar(cliente, pedido, em, ClienteDao, pedidoDao);
	 
	}

	private static void Deletar(Cliente cliente, Pedido pedido, EntityManager em, ClienteDao ClienteDao,
			PedidoDao pedidoDao) {
		// DELETE
		
		em.getTransaction().begin();// inicio
		
		ClienteDao.cadastra(cliente);
		pedidoDao.cadastra(pedido);
		
		em.remove(pedido);
		em.remove(cliente);// porque invertendo a odem dos  REMOVE   ele aparece um update
		
		
		
		em.flush();// ou .commit
	}

	private static void Editar(Cliente cliente, Pedido pedido, EntityManager em, ClienteDao ClienteDao,
			PedidoDao pedidoDao) {
		//+++ EDITAR++++
		em.getTransaction().begin(); //inicio
		
		ClienteDao.cadastra(cliente);
		pedidoDao.cadastra(pedido);
		
		pedido.setDESCONTO(new BigDecimal("80.0"));
		pedido.setTIPO_DESCONTO("black friday");
		
		//em.flush();// para sincronizar ao BD  sem fazer o comitt
		
		em.getTransaction().commit();
		em.close(); // termino 
	}

	private static void Cadastra(Cliente cliente, Pedido pedido, EntityManager em, ClienteDao ClienteDao,
			PedidoDao pedidoDao) {
		// +++ CADASTRA +++ 
		em .getTransaction().begin(); 
		ClienteDao.cadastra(cliente);
		pedidoDao.cadastra(pedido);
		
		em .getTransaction().commit();
		em .close();
	}
			
			
}
