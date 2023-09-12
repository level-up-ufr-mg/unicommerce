package br.com.alura.unicommerce.controller;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.ClienteDao;
import br.com.alura.unicommerce.dao.PedidoDao;
import br.com.alura.unicommerce.dao.ProdutoDao;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.ItemDePedido;
import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.modelo.TipoDesconto;
import br.com.alura.unicommerce.modelo.TipoDescontoItemPedido;
import br.com.alura.unicommerce.util.JPAUtil;

public class PedidoController {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDado = new ClienteDao(em);

		Cliente clienteAna = clienteDado.buscarPorId(6l);
		Cliente clienteEli = clienteDado.buscarPorId(7l);
		Cliente clienteDani = clienteDado.buscarPorId(8l);
		Cliente clienteBia = clienteDado.buscarPorId(9l);
		Cliente clienteCaio = clienteDado.buscarPorId(10l);
		Cliente clienteGabi = clienteDado.buscarPorId(11l);

		Produto produtoNotebook = produtoDao.buscarPorId(1l);
		Produto produtoSofa3Lugares = produtoDao.buscarPorId(2l);
		Produto produtoCleanArchitecture = produtoDao.buscarPorId(3l);
		Produto produtoMesadeJantar6Lugares = produtoDao.buscarPorId(4l);

		Produto produtoIPhone13Pro = produtoDao.buscarPorId(5l);

		Produto produtoMonitorDell27 = produtoDao.buscarPorId(6l);
		Produto produtoImplementingDomainDrivenDesign = produtoDao.buscarPorId(7l);
		Produto produtoJogoDePneus = produtoDao.buscarPorId(8l);
		Produto produtoCleanCode = produtoDao.buscarPorId(9l);
		Produto produtoGalaxyS22Ultra = produtoDao.buscarPorId(10l);
		Produto produtoMacbookPro16 = produtoDao.buscarPorId(11l);
		Produto produtoRefactoringImprovingTheDesign = produtoDao.buscarPorId(12l);
		Produto produtoCamaQueenSize = produtoDao.buscarPorId(13l);
		Produto produtoCentralMultimidia = produtoDao.buscarPorId(14l);
		Produto produtoBuildingMicroservices = produtoDao.buscarPorId(15l);
		Produto produtoGalaxyTabS8 = produtoDao.buscarPorId(16l);

		em.getTransaction().begin();

		Pedido pedidoAna1 = new Pedido(new BigDecimal(0.00), TipoDesconto.NENHUM, clienteAna);

		pedidoAna1.adicionarItem(
				new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1, new BigDecimal(0.00), pedidoAna1, produtoNotebook));

		Pedido pedidoAna2 = new Pedido(new BigDecimal(0.00), TipoDesconto.NENHUM, clienteAna);

		pedidoAna2.adicionarItem(new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1, new BigDecimal(0.00), pedidoAna2,
				produtoSofa3Lugares));

		Pedido pedidoAna3 = new Pedido(new BigDecimal(0.00), TipoDesconto.NENHUM, clienteAna);

		pedidoAna3.adicionarItem(new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1, new BigDecimal(0.00), pedidoAna3,
				produtoCleanArchitecture));

		Pedido pedidoELI1 = new Pedido(new BigDecimal(0.00), TipoDesconto.NENHUM, clienteEli);

		pedidoELI1.adicionarItem(new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1, new BigDecimal(0.00), pedidoELI1,
				produtoMesadeJantar6Lugares));

		Pedido pedidoAna4 = new Pedido(new BigDecimal(0.00), TipoDesconto.NENHUM, clienteAna);

		pedidoAna4.adicionarItem(new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1, new BigDecimal(0.00), pedidoAna4,
				produtoIPhone13Pro));

		Pedido pedidoDani1 = new Pedido(new BigDecimal(0.00), TipoDesconto.NENHUM, clienteDani);

		pedidoDani1.adicionarItem(new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1, new BigDecimal(0.00), pedidoDani1,
				produtoMonitorDell27));

		Pedido pedidoGabi1 = new Pedido(new BigDecimal(0.00), TipoDesconto.NENHUM, clienteGabi);

		pedidoGabi1.adicionarItem(new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1, new BigDecimal(0.00), pedidoGabi1,
				produtoImplementingDomainDrivenDesign));

		Pedido pedidoBia1 = new Pedido(new BigDecimal(0.00), TipoDesconto.NENHUM, clienteBia);

		pedidoBia1.adicionarItem(new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1, new BigDecimal(0.00), pedidoBia1,
				produtoJogoDePneus));

		Pedido pedidoBia2 = new Pedido(new BigDecimal(0.00), TipoDesconto.NENHUM, clienteBia);

		pedidoBia2.adicionarItem(new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1, new BigDecimal(0.00), pedidoBia2,
				produtoCleanCode));

		Pedido pedidoDani2 = new Pedido(new BigDecimal(0.00), TipoDesconto.NENHUM, clienteDani);

		pedidoDani2.adicionarItem(new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1, new BigDecimal(0.00), pedidoDani2,
				produtoGalaxyS22Ultra));

		Pedido pedidoCaio1 = new Pedido(new BigDecimal(0.00), TipoDesconto.NENHUM, clienteCaio);

		pedidoCaio1.adicionarItem(new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1, new BigDecimal(0.00), pedidoCaio1,
				produtoMacbookPro16));

		Pedido pedidoDani3 = new Pedido(new BigDecimal(0.00), TipoDesconto.NENHUM, clienteDani);

		pedidoDani3.adicionarItem(new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1, new BigDecimal(0.00), pedidoDani3,
				produtoRefactoringImprovingTheDesign));

		Pedido pedidoDani4 = new Pedido(new BigDecimal(0.00), TipoDesconto.NENHUM, clienteDani);

		pedidoDani4.adicionarItem(new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1, new BigDecimal(0.00), pedidoDani4,
				produtoCamaQueenSize));

		Pedido pedidoCaio2 = new Pedido(new BigDecimal(0.00), TipoDesconto.NENHUM, clienteCaio);

		pedidoCaio2.adicionarItem(new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1, new BigDecimal(0.00), pedidoCaio2,
				produtoCentralMultimidia));

		Pedido pedidoCaio3 = new Pedido(new BigDecimal(0.00), TipoDesconto.NENHUM, clienteCaio);

		pedidoCaio3.adicionarItem(new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1, new BigDecimal(0.00), pedidoCaio3,
				produtoBuildingMicroservices));

		Pedido pedidoBia3 = new Pedido(new BigDecimal(0.00), TipoDesconto.NENHUM, clienteBia);

		pedidoBia3.adicionarItem(new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1, new BigDecimal(0.00), pedidoBia3,
				produtoGalaxyTabS8));

		PedidoDao pedidoDao = new PedidoDao(em);

		pedidoDao.cadastrar(pedidoAna1);
		pedidoDao.cadastrar(pedidoAna2);
		pedidoDao.cadastrar(pedidoAna3);
		pedidoDao.cadastrar(pedidoAna4);
		pedidoDao.cadastrar(pedidoELI1);
		pedidoDao.cadastrar(pedidoDani1);
		pedidoDao.cadastrar(pedidoDani2);
		pedidoDao.cadastrar(pedidoDani3);
		pedidoDao.cadastrar(pedidoDani4);
		pedidoDao.cadastrar(pedidoBia1);
		pedidoDao.cadastrar(pedidoBia2);
		pedidoDao.cadastrar(pedidoBia3);
		pedidoDao.cadastrar(pedidoGabi1);
		pedidoDao.cadastrar(pedidoCaio1);
		pedidoDao.cadastrar(pedidoCaio2);
		pedidoDao.cadastrar(pedidoCaio3);

		em.getTransaction().commit();

	}

}
