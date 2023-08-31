package br.com.alura.unicommerce.controller;

import java.math.BigDecimal;
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
import br.com.alura.unicommerce.modelo.TipoDescontoItemPedido;
import br.com.alura.unicommerce.modelo.TipoDescontoPedido;
import br.com.alura.unicommerce.relatorios.RelatorioClientesFieis;
import br.com.alura.unicommerce.relatorios.RelatorioVendas;
import br.com.alura.unicommerce.util.JPAUtil;


public class CadastraPedido {
	
	
	public static void main(String[] args) {
	        
		//popularBancoDeDados();  
		
		EntityManager em = JPAUtil.getEntityManager();
		
		// Busac o produto para inserir no pedido
		ProdutoDao produtoDao = new ProdutoDao(em);
		Produto produto = produtoDao.buscaPorId(1l);
		Produto produto1 = produtoDao.buscaPorId(2l);
		Produto produto2 = produtoDao.buscaPorId(3l);
		
		//Busca um cliente para inserir no pedido
		ClienteDao clienteDao = new ClienteDao(em);
		Cliente cliente = clienteDao.buscaPorId(1l);
		Cliente cliente1 = clienteDao.buscaPorId(2l);
		Cliente cliente2 = clienteDao.buscaPorId(3l);

		//Inicia o cadastro de pedidos
		em.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente, new BigDecimal("5"), TipoDescontoPedido.NENHUM);
		pedido.adicionarItem(new ItemDePedido(5, pedido, produto, new BigDecimal("30") , TipoDescontoItemPedido.PROMOCAO));
		pedido.adicionarItem(new ItemDePedido(1, pedido, produto2, new BigDecimal("0") , TipoDescontoItemPedido.NENHUM));
		
		Pedido pedido1 = new Pedido(cliente1, new BigDecimal("10"), TipoDescontoPedido.NENHUM);
		pedido1.adicionarItem(new ItemDePedido(20, pedido1, produto, new BigDecimal("30") , TipoDescontoItemPedido.QUANTIDADE));
		pedido1.adicionarItem(new ItemDePedido(1, pedido1, produto1, new BigDecimal("10") , TipoDescontoItemPedido.NENHUM));
		
		Pedido pedido2 = new Pedido(cliente2, new BigDecimal("15"), TipoDescontoPedido.NENHUM);
		pedido2.adicionarItem(new ItemDePedido(1, pedido2, produto2, new BigDecimal("10") , TipoDescontoItemPedido.NENHUM));	
		
		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastra(pedido);
		pedidoDao.cadastra(pedido1);
		pedidoDao.cadastra(pedido2);
	         
		em.getTransaction().commit();
		
		//Testa o somatório
		BigDecimal totalVendido = pedidoDao.valorTotalVendido();
		System.out.println("Valor Total: " + totalVendido);
		
		//Roda a consulta para o relatório de vendas
		List<RelatorioVendas> relatorioVendas = pedidoDao.relatorioDeVendas();
		relatorioVendas.forEach(System.out::println); //Percorre cada elemento e dá o System.out
		
		List<RelatorioClientesFieis> relatorioClientesFieis = pedidoDao.relatorioClientesFieis();
		relatorioClientesFieis.forEach(System.out::println);


//		//Roda a consulta para o relatório de vendas
//		List<Object[]> relatorio = pedidoDao.relatorioDeVendas();
//		for (Object[] obj : relatorio) {
//			System.out.println(obj[0]);
//			System.out.println(obj[1]);
//			System.out.println(obj[2]);
//		}
//

}
	
	private static void popularBancoDeDados() {
		
		Categoria categoria = new Categoria("Eletrônicos", true);
		Categoria categoria1 = new Categoria("Eletrodomésticos", true);
		Categoria categoria2 = new Categoria("Brinquedos", true);
		
		Produto produto = new Produto ("Mouse", "Mouse Gamer", 3, categoria, new BigDecimal("90"));
		Produto produto1 = new Produto ("Geladeira", "Brastemp", 3, categoria1, new BigDecimal("2500"));
		Produto produto2 = new Produto ("Comandos em Ação", "Boneco", 3, categoria2, new BigDecimal("49"));
		
		Endereco endereco = new Endereco ( "Avenida Arnaldo Sena", "328", "Prédio", "Água Vermelha", "Formiga", "MG");
		
		Cliente cliente = new Cliente("Fulano de Tal", "12345678911", "3799995566", endereco);
		Cliente cliente1 = new Cliente("José Maria" ,"04123555596", "3199995633", endereco);
		Cliente cliente2 = new Cliente("Maria José", "05449633325", "3599995622", endereco);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastra(categoria);
		categoriaDao.cadastra(categoria1);
		categoriaDao.cadastra(categoria2);
		
		produtoDao.cadastra(produto);
		produtoDao.cadastra(produto1);
		produtoDao.cadastra(produto2);
		
		clienteDao.cadastra(cliente);
		clienteDao.cadastra(cliente1);
		clienteDao.cadastra(cliente2);
				
		em.getTransaction().commit();
		em.close();
	
	}

}
