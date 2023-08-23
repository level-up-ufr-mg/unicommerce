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

public class CadastraPedido {
	
	
	public static void main(String[] args) {
	        
		popularBancoDeDados();  
		
		EntityManager em = JPAUtil.getEntityManager();
		
		// recupera dados
		ProdutoDao produtoDao = new ProdutoDao(em);
		Produto produto = produtoDao.buscaPorId(1l);
		
		ClienteDao clienteDao = new ClienteDao(em);
		Cliente cliente = clienteDao.buscaPorId(1l);
		
		em.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente, new BigDecimal("30"), TipoDescontoPedido.NENHUM);
		pedido.adicionarItem(new ItemDePedido(1, pedido, produto, new BigDecimal("30") , TipoDescontoItemPedido.NENHUM));
		
		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastra(pedido);
	         
		em.getTransaction().commit();
		
		BigDecimal totalVendido = pedidoDao.valorTotalVendido();
		System.out.println("Valor Total: " + totalVendido);
		
		List<Object[]> relatorioVendas = pedidoDao.relatorioDeVendas();
		for (Object[] obj : relatorioVendas) {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			System.out.println(obj[2]);
		}
		
	 }
	
	private static void popularBancoDeDados() {
		
		Categoria categoria = new Categoria("Eletrônicos", true);
		Produto produto = new Produto ("Mouse","Mouse Gamer",3, categoria, new BigDecimal("120"));
		
		Endereco endereco = new Endereco ( "Avenida Brasil", "168", "Casa", "Ouro Negro", "Formiga", "MG");
		Cliente  cliente = new Cliente("Dayane Costa", "00000000000", "37998751208", endereco);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastra(categoria);
		produtoDao.cadastra(produto);
		clienteDao.cadastra(cliente);
		
		em.getTransaction().commit();
		em.close();
	
	}
	
	
}
