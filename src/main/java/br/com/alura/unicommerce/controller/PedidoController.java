package br.com.alura.unicommerce.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.ClienteDao;
import br.com.alura.unicommerce.dao.PedidoDao;
import br.com.alura.unicommerce.dao.ProdutoDao;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.ItemPedido;
import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.modelo.TIPO_DESCONTO;
import br.com.alura.unicommerce.modelo.TIPO_DESCONTO_ITEM_PEDIDO;
import br.com.alura.unicommerce.util.JPAUtil;
import br.com.alura.unicommerce.vo.RelatorioDeVendasVo;

public class PedidoController {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDado = new ClienteDao(em);

		Produto produto = produtoDao.buscarPorId(1l);
		Cliente cliente = clienteDado.buscarPorId(1l);

		em.getTransaction().begin();

		//Pedido pedido = new Pedido(cliente);
		Pedido pedido = new Pedido(new BigDecimal(0.00), TIPO_DESCONTO.NENHUM, cliente);
		
		pedido.adicionarItem(new ItemPedido(TIPO_DESCONTO_ITEM_PEDIDO.NENHUM, 10, new BigDecimal(0.00),
				pedido, produto));
		
		 
		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastrar(pedido);

		em.getTransaction().commit();
		
		
		BigDecimal totalVendido = pedidoDao.valorTotalVendido();
		System.out.println("VALOR TOTAL: " +totalVendido);
		
		List<RelatorioDeVendasVo> relatorio = pedidoDao.relatorioDeVendas();
		relatorio.forEach(System.out::println);

	}

}
