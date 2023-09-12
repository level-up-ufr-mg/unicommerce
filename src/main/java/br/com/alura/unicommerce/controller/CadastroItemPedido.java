package br.com.alura.unicommerce.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import br.com.alura.unicommerce.Dao.CategoriaDao;
import br.com.alura.unicommerce.Dao.ClienteDao;
import br.com.alura.unicommerce.Dao.ItemPedidoDao;
import br.com.alura.unicommerce.Dao.PedidoDao;
import br.com.alura.unicommerce.Dao.ProdutoDao;
import br.com.alura.unicommerce.Util.Factory;
import br.com.alura.unicommerce.VO.RelatorideVendasPorCategoriaVO;
import br.com.alura.unicommerce.VO.RelatorioDeItensMaisVendidosVO;
import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.Descontos;
import br.com.alura.unicommerce.modelo.Endereco;
import br.com.alura.unicommerce.modelo.ItemPedido;
import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.modelo.Produto;
import jakarta.persistence.EntityManager;

//service
public class CadastroItemPedido {

	public static void main(String[] args) {
		
		Endereco endereco = new Endereco("rua x", 100L, "casa", "centro",
				"São paulo ", "SAO PAULO");
		Cliente cliente = new Cliente(null, "unifor", 123456789012L, 99000101L,endereco);
		Pedido pedido = new Pedido(null, new Timestamp(System.currentTimeMillis()), new BigDecimal("00"),
				Descontos.NENHUM ,cliente, BigDecimal.ZERO);
		Categoria categoria = new Categoria(null, "alimentos", "ativa");
		Produto produto = new Produto(null,"banana ", "banana prata", 8L,new BigDecimal("75.00") ,categoria);
	
		ItemPedido item_Pedido = new ItemPedido(null, new BigDecimal("10"), 75L, pedido, produto, new BigDecimal("00"),
				Descontos.NENHUM);

		EntityManager em = Factory.getEntityManager();

		ItemPedidoDao item_PedidoDao = new ItemPedidoDao(em); 
		PedidoDao pedidoDao = new PedidoDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

//		Cadastro(cliente, pedido, categoria, produto, item_Pedido, em, item_PedidoDao, pedidoDao, produtoDao,
//				clienteDao, categoriaDao);
//
//		Editar(cliente, pedido, categoria, produto, item_Pedido, em, item_PedidoDao, pedidoDao, produtoDao, clienteDao,
//				categoriaDao);
//
//		Delete(cliente, pedido, categoria, produto, item_Pedido, em, item_PedidoDao, pedidoDao, produtoDao, clienteDao,
//				categoriaDao);

		 
		RelatorideVendasPorCategoria(item_PedidoDao);
		
		 RelatorioDeItensMaisVendidos(item_PedidoDao);			
	}



	private static void RelatorideVendasPorCategoria(ItemPedidoDao item_PedidoDao) {
		List<RelatorideVendasPorCategoriaVO> relatorio = item_PedidoDao.relatorideVendasPorCategoriaVO();
		relatorio.forEach(System.out::println);
	}

	
	private static void RelatorioDeItensMaisVendidos(ItemPedidoDao itemPedidoDao) {
		List<RelatorioDeItensMaisVendidosVO> relatorio = itemPedidoDao.relatorioDeItensMaisVendidosVOs();
		relatorio.forEach(System.out::println);
		
	}
	
	
	private static void Cadastro(Cliente cliente, Pedido pedido, Categoria categoria, Produto produto,
			ItemPedido item_Pedido, EntityManager em, ItemPedidoDao item_PedidoDao, PedidoDao pedidoDao,
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
			ItemPedido item_Pedido, EntityManager em, ItemPedidoDao item_PedidoDao, PedidoDao pedidoDao,
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

		item_Pedido.setQuantidade(100L);

		em.getTransaction().commit();
		em.close();// termino
	}

	private static void Delete(Cliente cliente, Pedido pedido, Categoria categoria, Produto produto,
			ItemPedido item_Pedido, EntityManager em, ItemPedidoDao item_PedidoDao, PedidoDao pedidoDao,
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
