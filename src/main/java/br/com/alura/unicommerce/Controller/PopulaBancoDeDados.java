//package br.com.alura.unicommerce.Controller;
//
//import java.math.BigDecimal;
//
//import br.com.alura.unicommerce.dao.CategoriaDao;
//import br.com.alura.unicommerce.dao.ClienteDao;
//import br.com.alura.unicommerce.dao.PedidoDao;
//import br.com.alura.unicommerce.dao.ProdutoDao;
//import br.com.alura.unicommerce.modelo.Categoria;
//import br.com.alura.unicommerce.modelo.Cliente;
//import br.com.alura.unicommerce.modelo.Endereco;
//import br.com.alura.unicommerce.modelo.ItemDePedido;
//import br.com.alura.unicommerce.modelo.Pedido;
//import br.com.alura.unicommerce.modelo.Produto;
//import br.com.alura.unicommerce.modelo.TipoDeDescontoItemDePedido;
//import br.com.alura.unicommerce.modelo.TipoDeDescontoPedido;
//import jakarta.persistence.EntityManager;
//
//public class PopulaBancoDeDados {
//	
//	public static void main(String[] args) {
//		EntityManager em = JPAUtil.getEntityManager();
//		
//		Categoria categoria01 = new Categoria("Eletrônicos");
//		Categoria categoria02 = new Categoria("Moda");
//		Categoria categoria03 = new Categoria("Esportes");
//		Categoria categoria04 = new Categoria("Decoração");
//		Categoria categoria05 = new Categoria("Eletrodomésticos");
//		
//		Produto produto01 = new Produto("Vestido de Seda", new BigDecimal("1300.00"),
//				"Vestido", 10, categoria01);
//		Produto produto02 = new Produto("Samsung Galaxy S21", new BigDecimal("999.99"),
//				"Smartphone", 10, categoria02);
//		Produto produto03 = new Produto("Camiseta Polo", new BigDecimal("29.99"),
//				"Vestuário", 50, categoria03);
//		Produto produto04 = new Produto("Quadro Picasso", new BigDecimal("19999.99"),
//				"Quadro", 2, categoria04);
//		Produto produto05 = new Produto("Geladeira Eletrolux", new BigDecimal("3500.99"),
//				"Eletrodomésticos", 30, categoria05);
//
//		Endereco endereco01 = new Endereco("Rua da Praia", 789, "Casa 2", "Bairro Praiano", "Cidade Litorânea", "SC");
//		Cliente cliente01 = new Cliente("Ana Costa", "456.789.123-00", "(48) 55555-5555", endereco01);
//		
//		Endereco endereco02 = new Endereco("Rua da Praia", 789, "Casa 2", "Bairro Praiano", "Cidade Litorânea", "SC");
//		Cliente cliente02 = new Cliente("Marcelo", "111.111.111-11", "(37) 89795-8575", endereco02);
//		
//		Endereco endereco03 = new Endereco("Avenida Central", 456, "Bloco A", "Centro", "Cidade Grande", "SP");
//		Cliente cliente03 = new Cliente("Ana Maria", "222.222.222-22", "(11) 98765-4321", endereco03);
//		
//		Endereco endereco04 = new Endereco("Rua das Flores", 123, "Casa 5", "Jardim Primavera", "Cidade Pequena", "RJ");
//		Cliente cliente04 = new Cliente("Carlos", "333.333.333-33", "(21) 87654-3210", endereco04);
//		
//		Endereco endereco05 = new Endereco("Avenida das Árvores", 456, "Apartamento 10", "Centro", "Cidade Grande", "SP");
//		Cliente cliente05 = new Cliente("Ana", "444.444.444-44", "(11) 98765-4321", endereco05);
//
//		Pedido pedido01 = new Pedido(cliente01, new BigDecimal(1), TipoDeDescontoPedido.NENHUM, 
//				new BigDecimal(0));
//		pedido01.adicionarItem(new ItemDePedido(produto01, pedido01, 10, new BigDecimal(0), 
//				TipoDeDescontoItemDePedido.NENHUM));
//		
//		Pedido pedido02 = new Pedido(cliente02, new BigDecimal(2), TipoDeDescontoPedido.FIDELIDADE, 
//				new BigDecimal(15));
//		pedido02.adicionarItem(new ItemDePedido(produto02, pedido02, 3, new BigDecimal(0), 
//				TipoDeDescontoItemDePedido.NENHUM));
//		
//		Pedido pedido03 = new Pedido(cliente03, new BigDecimal(1), TipoDeDescontoPedido.NENHUM, 
//				new BigDecimal(0));
//		pedido03.adicionarItem(new ItemDePedido(produto03, pedido03, 10, new BigDecimal(20), 
//				TipoDeDescontoItemDePedido.PROMOCAO));
//		
//		Pedido pedido04 = new Pedido(cliente04, new BigDecimal(3), TipoDeDescontoPedido.NENHUM, 
//				new BigDecimal(0));
//		pedido04.adicionarItem(new ItemDePedido(produto04, pedido04, 8, new BigDecimal(30), 
//				TipoDeDescontoItemDePedido.QUANTIDADE));
//		
//		Pedido pedido05 = new Pedido(cliente05, new BigDecimal(1), TipoDeDescontoPedido.FIDELIDADE, 
//				new BigDecimal(15));
//		pedido05.adicionarItem(new ItemDePedido(produto05, pedido05, 2, new BigDecimal(20), 
//				TipoDeDescontoItemDePedido.PROMOCAO));
//		
//		
//		em.getTransaction().begin();
//		
//		CategoriaDao categoriaDao = new CategoriaDao(em);
//
//		categoriaDao.cadastra(categoria01);
//		categoriaDao.cadastra(categoria02);
//		categoriaDao.cadastra(categoria03);
//		categoriaDao.cadastra(categoria04);
//		categoriaDao.cadastra(categoria05);
//				
//		ProdutoDao produtoDao= new ProdutoDao(em);
//		produtoDao.cadastra(produto01);
//		produtoDao.cadastra(produto02);
//		produtoDao.cadastra(produto03);
//		produtoDao.cadastra(produto04);
//		produtoDao.cadastra(produto05);
//		
//		ClienteDao clienteDao = new ClienteDao(em);
//		clienteDao.cadastra(cliente01);
//		clienteDao.cadastra(cliente02);
//		clienteDao.cadastra(cliente03);
//		clienteDao.cadastra(cliente04);
//		clienteDao.cadastra(cliente05);
//		
//		PedidoDao pedidoDao= new PedidoDao(em);
//		pedidoDao.cadastra(pedido01);
//		pedidoDao.cadastra(pedido02);
//		pedidoDao.cadastra(pedido03);
//		pedidoDao.cadastra(pedido04);
//		pedidoDao.cadastra(pedido05);
//		
//		em.getTransaction().commit();
//		em.close();
//	}
//}
