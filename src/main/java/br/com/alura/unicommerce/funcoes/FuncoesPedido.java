package br.com.alura.unicommerce.funcoes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.CategoriaDao;
import br.com.alura.unicommerce.dao.ClienteDao;
import br.com.alura.unicommerce.dao.PedidoDao;
import br.com.alura.unicommerce.dao.ProdutoDao;
import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.Endereco;
import br.com.alura.unicommerce.modelo.ItemDePedido;
import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.modelo.TipoDeDescontoItemDePedido;
import br.com.alura.unicommerce.modelo.TipoDeDescontoPedido;
import br.com.alura.unicommerce.util.JPAUtil;
import br.com.alura.unicommerce.vo.RelatorioDeVendasVo;

public class FuncoesPedido {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
//		popularBancoDeDados(em);
		cadastraPedido(em);
//		buscarPedidoComCliente(em);
	}

	private static void buscarPedidoComCliente(EntityManager em) {
		PedidoDao pedidoDao = new PedidoDao(em);
		Pedido pedido = pedidoDao.buscarPedidoComCliente(8l);
		em.close();
		System.out.println(pedido.getCliente().getNome());
	}

	private static void cadastraPedido(EntityManager em) {
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);

		Produto produto = produtoDao.buscaPorId(1l);
		Cliente cliente = clienteDao.buscaPorId(1l);

		em.getTransaction().begin();

		Pedido pedido = new Pedido(cliente, LocalDate.now(), new BigDecimal(0), TipoDeDescontoPedido.NENHUM, 
				new BigDecimal(0));
		pedido.adicionarItem(new ItemDePedido(produto, pedido, 10, new BigDecimal(0), 
				TipoDeDescontoItemDePedido.NENHUM));

		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastra(pedido);

		em.getTransaction().commit();

		BigDecimal totalVendidoBigDecimal = pedidoDao.valorTotalVendido();
		System.out.println("Valor total vendido: " + totalVendidoBigDecimal);

		List<RelatorioDeVendasVo> relatorio = pedidoDao.relatorioDeVendas();
		relatorio.forEach(System.out::println);

		em.close();
	}

	private static void popularBancoDeDados(EntityManager em) {
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		Categoria categoria = categoriaDao.buscaPorId(1l);
		Categoria categoria2 = categoriaDao.buscaPorId(2l);
		Categoria categoria3 = categoriaDao.buscaPorId(3l);
		
		Produto produto2 = new Produto("Samsung Galaxy S21", new BigDecimal("999.99"), "Smartphone", 10, categoria);
		Produto produto3 = new Produto("Camiseta Polo", new BigDecimal("29.99"), "Vestuário", 50, categoria2);
		Produto produto4 = new Produto("Tênis de Corrida", new BigDecimal("89.99"), "Calçados", 20, categoria3);


		Endereco endereco = new Endereco("Rua da Praia", 789, "Casa 2", "Bairro Praiano", "Cidade Litorânea", "SC");
		Cliente cliente = new Cliente("Marcelo", "111.111.111-11", "(37) 89795-8575", null, endereco);

		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);

		em.getTransaction().begin();

		categoriaDao.cadastra(categoria);
		produtoDao.cadastra(produto4);
		produtoDao.cadastra(produto2);
		produtoDao.cadastra(produto3);
		clienteDao.cadastra(cliente);

		em.getTransaction().commit();
	}
}
