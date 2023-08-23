package br.com.alura.unicommerce.teste;

import java.math.BigDecimal;
import java.sql.Timestamp;

import br.com.alura.unicommerce.Dao.CategoriaDao;
import br.com.alura.unicommerce.Dao.ClienteDao;
import br.com.alura.unicommerce.Dao.Item_PedidoDao;
import br.com.alura.unicommerce.Dao.PedidoDao;
import br.com.alura.unicommerce.Dao.ProdutoDao;
import br.com.alura.unicommerce.Util.Factory;
import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.Item_Pedido;
import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.modelo.Produto;
import jakarta.persistence.EntityManager;

//service
public class Item_PedidoController {

	public static void main(String[] args) {
		Cliente cliente = new Cliente(null, "FRANCISCO", 123456789012L, 99000101L, "rua x", 100L, "casa", "centro",
				"São paulo ", "SAO PAULO");
		Pedido pedido = new Pedido(null, new Timestamp(System.currentTimeMillis()), cliente, new BigDecimal("00"),
				"nenhum");
		Categoria categoria = new Categoria(null, "alimentos", "ativa");
		Produto produto = new Produto(null, "macarrao", "macarrao japones", 8L, categoria);

		Item_Pedido item_Pedido = new Item_Pedido(null, new BigDecimal("00"), 5L, pedido, produto, new BigDecimal("00"),
				"nenhum");

		EntityManager em = Factory.getEntityManager();

		Item_PedidoDao item_PedidoDao = new Item_PedidoDao(em);
		PedidoDao pedidoDao = new PedidoDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		Cadastro(cliente, pedido, categoria, produto, item_Pedido, em, item_PedidoDao, pedidoDao, produtoDao,
				clienteDao, categoriaDao);

		Editar(cliente, pedido, categoria, produto, item_Pedido, em, item_PedidoDao, pedidoDao, produtoDao, clienteDao,
				categoriaDao);

		Delete(cliente, pedido, categoria, produto, item_Pedido, em, item_PedidoDao, pedidoDao, produtoDao, clienteDao,
				categoriaDao);

	}

	private static void Cadastro(Cliente cliente, Pedido pedido, Categoria categoria, Produto produto,
			Item_Pedido item_Pedido, EntityManager em, Item_PedidoDao item_PedidoDao, PedidoDao pedidoDao,
			ProdutoDao produtoDao, ClienteDao clienteDao, CategoriaDao categoriaDao) {
		em.getTransaction().begin();
		clienteDao.cadastra(cliente);
		pedidoDao.cadastra(pedido);
		categoriaDao.cadastra(categoria);
		produtoDao.cadastra(produto);
		item_PedidoDao.cadastra(item_Pedido);
		em.getTransaction().commit();
		em.close();
	}

	private static void Editar(Cliente cliente, Pedido pedido, Categoria categoria, Produto produto,
			Item_Pedido item_Pedido, EntityManager em, Item_PedidoDao item_PedidoDao, PedidoDao pedidoDao,
			ProdutoDao produtoDao, ClienteDao clienteDao, CategoriaDao categoriaDao) {
		// +++ EDITAR +++
		em.getTransaction().begin();

		clienteDao.cadastra(cliente);
		pedidoDao.cadastra(pedido);
		categoriaDao.cadastra(categoria);
		produtoDao.cadastra(produto);
		item_PedidoDao.cadastra(item_Pedido);
		// ou ao inves de usaar as classes DAO voce pode simplesmente chamar "
		// em.persist(nome da entidade ) " chamado todas as entidades

		item_Pedido.setQUANTIDADE(100L);

		em.getTransaction().commit();
		em.close();// termino
	}

	private static void Delete(Cliente cliente, Pedido pedido, Categoria categoria, Produto produto,
			Item_Pedido item_Pedido, EntityManager em, Item_PedidoDao item_PedidoDao, PedidoDao pedidoDao,
			ProdutoDao produtoDao, ClienteDao clienteDao, CategoriaDao categoriaDao) {
		// +++ DELETE
		em.getTransaction().begin();

		clienteDao.cadastra(cliente);
		pedidoDao.cadastra(pedido);
		categoriaDao.cadastra(categoria);
		produtoDao.cadastra(produto);
		item_PedidoDao.cadastra(item_Pedido);

//		em.remove(pedido);
//		em.remove(cliente);
//		em.remove(categoria); // porque invertendo a odem dos REMOVE ele aparece um update
//		em.remove(produto);
//		em.remove(item_Pedido);
		//
		 //se eu altera a ordem do 1 pelo 2 da um update.
		 //SE a ordem for assim
		 em.remove(cliente); 
		 em.remove(pedido); 
		 em.remove(categoria);
		 em.remove(produto);

		// ou

		// pedidoDao.remover(pedido);
		// clienteDao.remover(cliente);
		// categoriaDao.remover(categoria);
		// produtoDao.remover(produto);
//		

		em.flush();
	}

}
