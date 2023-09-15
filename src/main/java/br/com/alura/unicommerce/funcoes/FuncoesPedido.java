package br.com.alura.unicommerce.funcoes;

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

		Produto produto = produtoDao.buscaPorId(19l);
		Produto produto2 = produtoDao.buscaPorId(20l);
		Produto produto3 = produtoDao.buscaPorId(21l);
		Cliente cliente = clienteDao.buscaPorId(1l);

		em.getTransaction().begin();

		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(produto, pedido, 10));
		pedido.adicionarItem(new ItemPedido(produto2, pedido, 40));

		Pedido pedido2 = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(produto3, pedido, 2));

		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastra(pedido);
		pedidoDao.cadastra(pedido2);

		em.getTransaction().commit();

		BigDecimal totalVendidoBigDecimal = pedidoDao.valorTotalVendido();
		System.out.println("Valor total vendido: " + totalVendidoBigDecimal);

		List<Object[]> relatorio = pedidoDao.relatorioDeVendas();
		for (Object[] obj : relatorio) {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			System.out.println(obj[2]);
		}

		em.close();
	}

	private static void popularBancoDeDados(EntityManager em) {
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		Categoria categoria = categoriaDao.buscaPorId(1l);
		Categoria categoria2 = categoriaDao.buscaPorId(2l);
		Categoria categoria3 = categoriaDao.buscaPorId(3l);
		
		Produto produto = new Produto("Smartphone Samsung", new BigDecimal("699.99"), "Eletrônicos", 15, categoria);
		Produto produto2 = new Produto("Vestido Floral", new BigDecimal("49.99"), "Moda", 30, categoria2);
		Produto produto3 = new Produto("Tênis de Corrida Nike", new BigDecimal("129.99"), "Esportes", 25, categoria3);

		Endereco endereco = new Endereco("Rua da Praia", 789, "Casa 2", "Bairro Praiano", "Cidade Litorânea", "SC");
		Cliente cliente = new Cliente("Marcelo", "111.111.111-11", "(37) 89795-8575", endereco);

		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);

		em.getTransaction().begin();

		categoriaDao.cadastra(categoria);
		produtoDao.cadastra(produto);
		produtoDao.cadastra(produto2);
		produtoDao.cadastra(produto3);
		clienteDao.cadastra(cliente);

		em.getTransaction().commit();
	}
}
