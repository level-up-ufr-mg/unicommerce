package br.com.alura.unicommerce.funcoes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.CategoriaDao;
import br.com.alura.unicommerce.dao.ClienteDao;
import br.com.alura.unicommerce.dao.PedidoDao;
import br.com.alura.unicommerce.dao.ProdutoDao;
import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.Endereco;
import br.com.alura.unicommerce.modelo.ItemPedido;
import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.util.JPAUtil;

public class FuncoesPedido {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		popularBancoDeDados(em);
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		Produto produto = produtoDao.buscaPorId(1l);
		Cliente cliente = clienteDao.buscaPorId(1l);
		
		em.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente );
		pedido.adicionarItem(new ItemPedido(produto, pedido, 10));
		
		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastra(pedido);
		
		em.getTransaction().commit();
		em.close();
	}

	private static void popularBancoDeDados(EntityManager em) {
		CategoriaDao categoriaDao = new CategoriaDao(em);
		Categoria categoria = categoriaDao.buscaPorId(2l);
		Produto produto = new Produto("i5 12700h", new BigDecimal("1300.00"), "Computador", 4, categoria);
		
		Endereco endereco = new Endereco("Rua da Praia", 789, "Casa 2", "Bairro Praiano", "Cidade Litorânea", "SC");
		Cliente cliente = new Cliente("Samanta", "111.111.111-11", "(37) 89795-8575", endereco);
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);

		em.getTransaction().begin();
		
		categoriaDao.cadastra(categoria);
		produtoDao.cadastra(produto);
		clienteDao.cadastra(cliente);
		
		em.getTransaction().commit();
	}
}
