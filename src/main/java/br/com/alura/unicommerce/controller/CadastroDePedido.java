package br.com.alura.unicommerce.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;

import br.com.alura.unicommerce.Dao.ClienteDao;
import br.com.alura.unicommerce.Dao.PedidoDao;
import br.com.alura.unicommerce.Dao.ProdutoDao;
import br.com.alura.unicommerce.Util.Factory;
import br.com.alura.unicommerce.VO.RelatorioClientesFieisVO;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.Descontos;
import br.com.alura.unicommerce.modelo.Endereco;
import br.com.alura.unicommerce.modelo.ItemPedido;
import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.modelo.Produto;
import jakarta.persistence.EntityManager;

//service
public class CadastroDePedido {

	public static void main(String[] args) {
		 
		EntityManager em = Factory.getEntityManager();
		ProdutoDao produto = new ProdutoDao(em); 
		ClienteDao ClienteDao = new ClienteDao(em);  
		PedidoDao pedidoDao = new PedidoDao(em);
  
		
		
		
		Endereco endereco = new Endereco("rua x", 100L, "casa", "centro",
				"São paulo ", "SAO PAULO");
		Cliente cliente = new Cliente(null, "Ana Beatriz ", 1254686588L, 99043201L, endereco);
		 
		Pedido pedido = new Pedido(null, new Timestamp(System.currentTimeMillis()), new BigDecimal("00"),
				Descontos.NENHUM, cliente,BigDecimal.ZERO);

	Produto buscaProID = 	produto.buscaProID(1L); 
	
		pedido.adicionarItem(new ItemPedido(null, new BigDecimal("10"), 2L, pedido, buscaProID , new BigDecimal("00"),
				Descontos.NENHUM));

		
		//Cadastra(cliente, pedido, em, ClienteDao, pedidoDao);

		
		
		// Editar(cliente, pedido, em, ClienteDao, pedidoDao);

		// Deletar(cliente, pedido, em, ClienteDao, pedidoDao);
	
		RelatotioClientesFieis(pedidoDao);
	}
	
	
	private static void RelatotioClientesFieis(PedidoDao pedidoDao) {
		List<RelatorioClientesFieisVO> relatorio = pedidoDao.relatorioClientesFiesVOs();
		relatorio.forEach(System.out::println);
		
	}
	
	

	private static void Deletar(Cliente cliente, Pedido pedido, EntityManager em, ClienteDao ClienteDao,
			PedidoDao pedidoDao) {
		// DELETE

		em.getTransaction().begin();// inicio

		ClienteDao.cadastra(cliente);
		pedidoDao.cadastra(pedido);

		em.remove(pedido);
		em.remove(cliente);// porque invertendo a odem dos REMOVE ele aparece um update

		em.flush();// ou .commit
	}

	private static void Editar(Cliente cliente, Pedido pedido, EntityManager em, ClienteDao ClienteDao,
			PedidoDao pedidoDao) {
		// +++ EDITAR++++
		em.getTransaction().begin(); // inicio

		ClienteDao.cadastra(cliente);
		pedidoDao.cadastra(pedido);

		pedido.setDesconto(new BigDecimal("80.0"));
		pedido.setTipoDesconto(Descontos.NENHUM);;

		// em.flush();// para sincronizar ao BD sem fazer o comitt

		em.getTransaction().commit();
		em.close(); // termino
	}

	private static void Cadastra(Cliente cliente, Pedido pedido, EntityManager em, ClienteDao ClienteDao,
			PedidoDao pedidoDao) {
		// +++ CADASTRA +++
		em.getTransaction().begin();
		ClienteDao.cadastra(cliente);
		pedidoDao.cadastra(pedido);
		em.getTransaction().commit();
		em.close();
	}

}
