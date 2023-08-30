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
import br.com.alura.unicommerce.util.JPAUtil;
import br.com.alura.unicommerce.vo.RelatorioDeVendasVo;

public class CadastraPedido {
	
	
	public static void main(String[] args) {
	        
		popularBancoDeDados();  
		
		EntityManager em = JPAUtil.getEntityManager();
		
		// recupera dados
		ProdutoDao produtoDao = new ProdutoDao(em);
		Produto produto = produtoDao.buscaPorId(1l);
		Produto produto2 = produtoDao.buscaPorId(2l);
		Produto produto3 = produtoDao.buscaPorId(3l);
		
		ClienteDao clienteDao = new ClienteDao(em);
		Cliente cliente = clienteDao.buscaPorId(1l);
		
		em.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente, new BigDecimal("30"), TipoDescontoPedido.NENHUM);
		pedido.adicionarItem(new ItemDePedido(2, pedido, produto, new BigDecimal("30") , TipoDescontoItemPedido.NENHUM));
		pedido.adicionarItem(new ItemDePedido(1, pedido, produto2, new BigDecimal("10") , TipoDescontoItemPedido.NENHUM));
		
		Pedido pedido2 = new Pedido(cliente, new BigDecimal("30"), TipoDescontoPedido.NENHUM);
		pedido2.adicionarItem(new ItemDePedido(4, pedido2, produto3, new BigDecimal("10") , TipoDescontoItemPedido.NENHUM));
		
		Pedido pedido3 = new Pedido(cliente, new BigDecimal("30"), TipoDescontoPedido.NENHUM);
		pedido3.adicionarItem(new ItemDePedido(2, pedido3, produto3, new BigDecimal("10") , TipoDescontoItemPedido.NENHUM));
		
		Pedido pedido4 = new Pedido(cliente, new BigDecimal("30"), TipoDescontoPedido.NENHUM);
		pedido4.adicionarItem(new ItemDePedido(1, pedido4, produto3, new BigDecimal("10") , TipoDescontoItemPedido.NENHUM));
		
		Pedido pedido5 = new Pedido(cliente, new BigDecimal("30"), TipoDescontoPedido.NENHUM);
		pedido5.adicionarItem(new ItemDePedido(1, pedido5, produto3, new BigDecimal("10") , TipoDescontoItemPedido.NENHUM));
		
		PedidoDao pedidoDao = new PedidoDao(em);
//		pedidoDao.cadastra(pedido);
//		pedidoDao.cadastra(pedido2);
		pedidoDao.cadastra(pedido3);
		pedidoDao.cadastra(pedido4);
		pedidoDao.cadastra(pedido5);
	         
		em.getTransaction().commit();
		
		BigDecimal totalVendido = pedidoDao.valorTotalVendido();
		System.out.println("Valor Total: " + totalVendido);
		
		List<RelatorioDeVendasVo> relatorio = pedidoDao.relatorioDeVendas();
			relatorio.forEach(System.out::println);
		
		
	 }
	
	private static void popularBancoDeDados() {
		
		Categoria categoria = new Categoria("Eletrônicos", true);
		Categoria categoria1 = new Categoria("Eletrodomésticos", true);
		Categoria categoria2 = new Categoria("Brinquedos", true);
		
		Produto produto = new Produto ("Mouse","Mouse Gamer",3, categoria, new BigDecimal("120"));
		Produto produto1 = new Produto ("Geladeira","Potente",3, categoria1, new BigDecimal("4000"));
		Produto produto2 = new Produto ("Barbie","Barbie Sereia",3, categoria2, new BigDecimal("90"));
		
		Endereco endereco = new Endereco ( "Avenida Brasil", "168", "Casa", "Ouro Negro", "Formiga", "MG");
		Cliente  cliente = new Cliente("Dayane Costa", "00000000000", "37998751208", endereco);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		em.getTransaction().begin();
		
//		categoriaDao.cadastra(categoria);
//		categoriaDao.cadastra(categoria1);
//		categoriaDao.cadastra(categoria2);
//		
//		produtoDao.cadastra(produto);
//		produtoDao.cadastra(produto1);
//		produtoDao.cadastra(produto2);
//		
//		clienteDao.cadastra(cliente);
				
		em.getTransaction().commit();
		em.close();
	
	}
	
	
}
