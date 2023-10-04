package br.com.alura.unicommerce.relatorios.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;

/*Gerar relatório com uma lista com um único pedido;
Gerar relatório com uma lista sem pedidos.
Gerar relatório com todos os dados
Validar todas as regras de cálculo*/

import org.junit.jupiter.api.Test;

import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.ItemDePedido;
import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.modelo.TipoDescontoItemPedido;
import br.com.alura.unicommerce.modelo.TipoDescontoPedido;
import br.com.alura.unicommerce.relatorios.RelatorioClientesFieis;
import br.com.alura.unicommerce.service.ClienteService;
import org.junit.jupiter.api.Assertions;

class RelatorioClientesFieisTest {
		
		static List<Pedido> listaComUmPedido = new ArrayList<>();
		static List<Pedido> listaCompleta = new ArrayList<>();
		static List<Pedido> listaSemPedidos = new ArrayList<>();
		
		
		@BeforeAll
		static void preparaOsDados() {
			Categoria eletronicos = new Categoria("Eletrônicos", true);
			Produto mouseGamer = new Produto ("Mouse", "Mouse Gamer", 3, eletronicos, new BigDecimal("90"));
			Produto tecladoGamer = new Produto ("Teclado", "Teclado Gamer", 5, eletronicos, new BigDecimal("160"));
			Produto foneGamer = new Produto ("Fone", "Fone Gamer", 10, eletronicos, new BigDecimal("230"));
			
			Pedido pedidoUm = new Pedido(new Cliente("Evandro", "444.444.444-66", "(11)99999-9999"), BigDecimal.ZERO, TipoDescontoPedido.NENHUM);
			ItemDePedido pedidoUmItemDoPedido = new ItemDePedido(1, pedidoUm, mouseGamer, BigDecimal.ZERO, TipoDescontoItemPedido.NENHUM);
			pedidoUm.adicionarItem(pedidoUmItemDoPedido);
			
			listaComUmPedido.add(pedidoUm);
			listaCompleta.add(pedidoUm);
			
			Pedido pedidoDois = new Pedido(new Cliente("Marcos", "555.444.444-66", "(11)99999-9999"), BigDecimal.ZERO, TipoDescontoPedido.NENHUM);
			ItemDePedido pedidoDoisItemDoPedido = new ItemDePedido(1, pedidoDois, mouseGamer, BigDecimal.ZERO, TipoDescontoItemPedido.NENHUM);
			ItemDePedido pedidoDoisItemDoPedido2 = new ItemDePedido(1, pedidoDois, tecladoGamer, BigDecimal.ZERO, TipoDescontoItemPedido.NENHUM);
			pedidoDois.adicionarItem(pedidoDoisItemDoPedido);
			pedidoDois.adicionarItem(pedidoDoisItemDoPedido2);
			listaCompleta.add(pedidoDois);
			
			Pedido pedidoTres = new Pedido(new Cliente("Dayane", "666.444.444-66", "(11)99999-9999"), BigDecimal.ZERO, TipoDescontoPedido.NENHUM);
			ItemDePedido pedidoTresItemDoPedido = new ItemDePedido(1, pedidoTres, mouseGamer, BigDecimal.ZERO, TipoDescontoItemPedido.NENHUM);
			ItemDePedido pedidoTresItemDoPedido2 = new ItemDePedido(1, pedidoTres, tecladoGamer, BigDecimal.ZERO, TipoDescontoItemPedido.NENHUM);
			ItemDePedido pedidoTresItemDoPedido3 = new ItemDePedido(1, pedidoTres, foneGamer, BigDecimal.ZERO, TipoDescontoItemPedido.NENHUM);
			pedidoTres.adicionarItem(pedidoTresItemDoPedido);
			pedidoTres.adicionarItem(pedidoTresItemDoPedido2);
			pedidoTres.adicionarItem(pedidoTresItemDoPedido3);
			listaCompleta.add(pedidoTres);
			System.out.println("Inicializou os dados");
		}
		
		@Test
		void deveGerarORelatorioComApenasUmUnicoPedido() {
			
			List<RelatorioClientesFieis> relatorioClientesFieis = new ClienteService().getRelatorioClientesFieis(listaComUmPedido);
		
			Assertions.assertNotNull(relatorioClientesFieis);
			Assertions.assertEquals(new BigDecimal("90"), relatorioClientesFieis.get(0).getTotalGasto());
		}
		
		@Test
		void deveGarantirASomaDosTotaisDosPedido() {
			
			List<RelatorioClientesFieis> relatorioClientesFieis = new ClienteService().getRelatorioClientesFieis(listaCompleta);
			
			BigDecimal total = BigDecimal.ZERO;
			for (RelatorioClientesFieis pedido : relatorioClientesFieis) {
				total = total.add(pedido.getTotalGasto());
			}
			
			Assertions.assertNotNull(relatorioClientesFieis);
			Assertions.assertEquals(new BigDecimal("820"), total);
		}
		
		@Test
		void deveGerarORelatorioSeNaoHouverPedidos() {
			
			int qtdPedidos = 0;
			List<RelatorioClientesFieis> relatorioClientesFieis = new ClienteService().getRelatorioClientesFieis(listaSemPedidos);
			
			for (int i=0; i <= relatorioClientesFieis.size(); i++) {
				qtdPedidos = i;				
			}		
			Assertions.assertEquals(0, qtdPedidos);
		}
}


		
		

		/*
		Categoria categoria = new Categoria("Eletrônicos", true);
		Produto produto = new Produto(1l, "Mouse", "Mouse Gamer", 3, categoria, new BigDecimal("90"));
		Endereco endereco = new Endereco("Avenida Arnaldo Sena", "328", "Prédio", "Água Vermelha", "Formiga", "MG");
		Cliente cliente = new Cliente(1l, "Fulano de Tal", "12345678911", "3799995566", endereco);

		// Pedido pedido = new Pedido(cliente, new BigDecimal("5"),
		// TipoDescontoPedido.NENHUM);

		EntityManager em = JPAUtil.getEntityManager(); // Para acesso o Banco

		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);

		PedidoDao pedidoDao = new PedidoDao(em);

		em.getTransaction().begin();

		categoriaDao.cadastra(categoria);
		produtoDao.cadastra(produto);
		clienteDao.cadastra(cliente);

		// pedido.adicionarItem(new ItemDePedido(5, pedido, produto, new
		// BigDecimal("30") , TipoDescontoItemPedido.PROMOCAO));

		em.getTransaction().commit();
		// em.close();

		EntityManager em1 = JPAUtil.getEntityManager();

		// Busac o produto para inserir no pedido
		ProdutoDao produtoDao1 = new ProdutoDao(em1);
		produto = produtoDao1.buscaPorId(1l);

		// Busca um cliente para inserir no pedido
		ClienteDao clienteDao1 = new ClienteDao(em1);
		cliente = clienteDao1.buscaPorId(1l);
		
		//Inicia o cadastro de pedidos
		Pedido pedido = new Pedido(cliente, new BigDecimal("5"), TipoDescontoPedido.NENHUM);
		pedido.adicionarItem(new ItemDePedido(5, pedido, produto, new BigDecimal("30") , TipoDescontoItemPedido.PROMOCAO));
		
		PedidoDao pedidoDao1 = new PedidoDao(em1);
		pedidoDao1.cadastra(pedido);
		
		em.getTransaction().commit();
		
		System.out.println("I´m here");

		List<RelatorioClientesFieis> relatorioClientesFieis = pedidoDao.relatorioClientesFieis();
		relatorioClientesFieis.forEach(System.out::println);

		assertNotNull(relatorioClientesFieis);
		assertEquals(1, relatorioClientesFieis.size());
		// assertTrue(relatorioClientesFieis.size() == 1);
		 * */



