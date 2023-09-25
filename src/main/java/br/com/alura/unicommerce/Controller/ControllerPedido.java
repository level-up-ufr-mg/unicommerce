package br.com.alura.unicommerce.Controller;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.ClienteDao;
import br.com.alura.unicommerce.dao.PedidoDao;
import br.com.alura.unicommerce.dao.ProdutoDao;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.ItemDePedido;
import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.modelo.TipoDeDescontoItemDePedido;
import br.com.alura.unicommerce.modelo.TipoDeDescontoPedido;
import br.com.alura.unicommerce.util.JPAUtil;
import br.com.alura.unicommerce.vo.RelatorioDeVendasVo;

public class ControllerPedido {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		cadastraPedido(em);
//		buscarPedidoComCliente(em);
//		relatorioDeVendas(em);
	}

	private static void relatorioDeVendas(EntityManager em) {
		PedidoDao pedidoDao = new PedidoDao(em);
//		BigDecimal totalVendidoBigDecimal = pedidoDao.valorTotalVendido();
//		System.out.println("Valor total vendido: " + totalVendidoBigDecimal);

		List<RelatorioDeVendasVo> relatorio = pedidoDao.relatorioDeVendas();
		relatorio.forEach(System.out::println);
	}

	private static void buscarPedidoComCliente(EntityManager em) {
		PedidoDao pedidoDao = new PedidoDao(em);
		Pedido pedido = pedidoDao.buscarPedidoComCliente(8l);
		em.close();
		System.out.println(pedido.getCliente().getNome());
	}

	private static void cadastraPedido(EntityManager em) {
		ProdutoDao produtoDao = new ProdutoDao(em);

		Produto produto01 = produtoDao.buscaPorId(1l);
		Produto produto02 = produtoDao.buscaPorId(2l);
		Produto produto03 = produtoDao.buscaPorId(3l);
		Produto produto04 = produtoDao.buscaPorId(4l);
		Produto produto05 = produtoDao.buscaPorId(5l);

		ClienteDao clienteDao = new ClienteDao(em);

		Cliente cliente01 = clienteDao.buscaPorId(1l);
		Cliente cliente02 = clienteDao.buscaPorId(2l);
		Cliente cliente03 = clienteDao.buscaPorId(3l);
		Cliente cliente04 = clienteDao.buscaPorId(4l);
		Cliente cliente05 = clienteDao.buscaPorId(5l);

		em.getTransaction().begin();

		Pedido pedido01 = new Pedido(cliente01, new BigDecimal(1), TipoDeDescontoPedido.NENHUM, new BigDecimal(0));
		pedido01.adicionarItem(
				new ItemDePedido(produto01, pedido01, 10, new BigDecimal(0), TipoDeDescontoItemDePedido.NENHUM));

		Pedido pedido02 = new Pedido(cliente02, new BigDecimal(2), TipoDeDescontoPedido.FIDELIDADE, new BigDecimal(15));
		pedido02.adicionarItem(
				new ItemDePedido(produto02, pedido02, 3, new BigDecimal(0), TipoDeDescontoItemDePedido.NENHUM));

		Pedido pedido03 = new Pedido(cliente03, new BigDecimal(1), TipoDeDescontoPedido.NENHUM, new BigDecimal(0));
		pedido03.adicionarItem(
				new ItemDePedido(produto03, pedido03, 10, new BigDecimal(20), TipoDeDescontoItemDePedido.PROMOCAO));

		Pedido pedido04 = new Pedido(cliente04, new BigDecimal(3), TipoDeDescontoPedido.NENHUM, new BigDecimal(0));
		pedido04.adicionarItem(
				new ItemDePedido(produto04, pedido04, 8, new BigDecimal(30), TipoDeDescontoItemDePedido.QUANTIDADE));

		Pedido pedido05 = new Pedido(cliente05, new BigDecimal(1), TipoDeDescontoPedido.FIDELIDADE, new BigDecimal(15));
		pedido05.adicionarItem(
				new ItemDePedido(produto05, pedido05, 2, new BigDecimal(20), TipoDeDescontoItemDePedido.PROMOCAO));

		PedidoDao pedidoDao = new PedidoDao(em);

		pedidoDao.cadastra(pedido01);
		pedidoDao.cadastra(pedido02);
		pedidoDao.cadastra(pedido03);
		pedidoDao.cadastra(pedido04);
		pedidoDao.cadastra(pedido05);

		em.getTransaction().commit();

		em.close();
	}
}
