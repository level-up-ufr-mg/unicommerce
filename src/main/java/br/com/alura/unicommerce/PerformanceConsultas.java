package br.com.alura.unicommerce;

import java.math.BigDecimal;

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

public class PerformanceConsultas {

	public static void main(String[] args) {
        
		popularBancoDeDados();  
		
		EntityManager em = JPAUtil.getEntityManager();
		PedidoDao pedidoDao = new PedidoDao(em);
		Pedido pedido = pedidoDao.buscaPedidoComCliente(1l);
		em.close();
		System.out.println(pedido.getCliente().getNome());
	
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
		
		Pedido pedido = new Pedido(cliente, new BigDecimal("30"), TipoDescontoPedido.NENHUM);
		pedido.adicionarItem(new ItemDePedido(1, pedido, produto, new BigDecimal("30") , TipoDescontoItemPedido.NENHUM));
		pedido.adicionarItem(new ItemDePedido(1, pedido, produto2, new BigDecimal("10") , TipoDescontoItemPedido.NENHUM));
		
		Pedido pedido2 = new Pedido(cliente, new BigDecimal("30"), TipoDescontoPedido.NENHUM);
		pedido.adicionarItem(new ItemDePedido(1, pedido2, produto, new BigDecimal("10") , TipoDescontoItemPedido.NENHUM));
		
		EntityManager em = JPAUtil.getEntityManager();
		
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		PedidoDao pedidoDao = new PedidoDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastra(categoria);
		categoriaDao.cadastra(categoria1);
		categoriaDao.cadastra(categoria2);
		
		produtoDao.cadastra(produto);
		produtoDao.cadastra(produto1);
		produtoDao.cadastra(produto2);
		clienteDao.cadastra(cliente);
		pedidoDao.cadastra(pedido);
		pedidoDao.cadastra(pedido2);
				
		em.getTransaction().commit();
		em.close();
		
	}
}
