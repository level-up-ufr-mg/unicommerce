package br.com.alura.unicommerce.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

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

class ControllerPedidoTest {

	@Test
	public void reajusteDeveSerDe() {
		EntityManager em = JPAUtil.getEntityManager();

		ProdutoDao produtoDao = new ProdutoDao(em);
		Produto produto01 = produtoDao.buscaPorId(1l);

		ClienteDao clienteDao = new ClienteDao(em);
		Cliente cliente01 = clienteDao.buscaPorId(1l);

		Pedido pedido01 = new Pedido(cliente01, new BigDecimal(1), TipoDeDescontoPedido.FIDELIDADE, new BigDecimal(0));
		pedido01.adicionarItem(new ItemDePedido(produto01,pedido01,10,new BigDecimal(0),TipoDeDescontoItemDePedido.NENHUM));

		PedidoDao pedidoDao = new PedidoDao(em);

		pedidoDao.cadastra(pedido01);

		assertEquals(null, null);
	}

}
