package br.com.alura.unicommerce.funcoes;

import java.math.BigDecimal;
import java.time.LocalDate;

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
import br.com.alura.unicommerce.modelo.TipoDeDescontoItemDePedido;
import br.com.alura.unicommerce.modelo.TipoDeDescontoPedido;
import br.com.alura.unicommerce.util.JPAUtil;

public class PopulaBancoDeDados {
	
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		Categoria categoria = new Categoria("Eletrônicos", true);
		Categoria categoria2 = new Categoria("Moda", true);
		Categoria categoria3 = new Categoria("Esportes", false);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		Produto produto = new Produto("Samsung Galaxy S21", new BigDecimal("999.99"), "Smartphone", 10, categoria);
		Produto produto2 = new Produto("Camiseta Polo", new BigDecimal("29.99"), "Vestuário", 50, categoria2);
		Produto produto3 = new Produto("Tênis de Corrida", new BigDecimal("89.99"), "Calçados", 20, categoria3);
		ProdutoDao produtoDao = new ProdutoDao(em);

		Endereco endereco = new Endereco("Rua da Praia", 789, "Casa 2", "Bairro Praiano", "Cidade Litorânea", "SC");
		Cliente cliente = new Cliente("Marcelo", "111.111.111-11", "(37) 89795-8575", endereco);
		Endereco endereco1 = new Endereco("Avenida Central", 456, "Bloco A", "Centro", "Cidade Grande", "SP");
		Cliente cliente2 = new Cliente("Ana", "222.222.222-22", "(11) 98765-4321", endereco1);
		Endereco endereco2 = new Endereco("Rua das Flores", 123, "Casa 5", "Jardim Primavera", "Cidade Pequena", "RJ");
		Cliente cliente3 = new Cliente("Carlos", "333.333.333-33", "(21) 87654-3210", endereco2);
		ClienteDao clienteDao = new ClienteDao(em); 

		Pedido pedido = new Pedido(cliente, LocalDate.now(), new BigDecimal(2), TipoDeDescontoPedido.NENHUM, 
				new BigDecimal(0));
		pedido.adicionarItem(new ItemDePedido(produto, pedido, 10, new BigDecimal(0), 
				TipoDeDescontoItemDePedido.NENHUM));
		Pedido pedido2 = new Pedido(cliente2, LocalDate.now(), new BigDecimal(1), TipoDeDescontoPedido.NENHUM, 
				new BigDecimal(0));
		pedido2.adicionarItem(new ItemDePedido(produto2, pedido2, 5, new BigDecimal(0), 
				TipoDeDescontoItemDePedido.NENHUM));
		Pedido pedido3 = new Pedido(cliente3, LocalDate.now(), new BigDecimal(4), TipoDeDescontoPedido.NENHUM, 
				new BigDecimal(0));
		pedido3.adicionarItem(new ItemDePedido(produto3, pedido3, 7, new BigDecimal(0), 
				TipoDeDescontoItemDePedido.NENHUM));
		PedidoDao pedidoDao = new PedidoDao(em);
		
		em.getTransaction().begin();
		categoriaDao.cadastra(categoria);
		categoriaDao.cadastra(categoria2);
		categoriaDao.cadastra(categoria3);
		
		produtoDao.cadastra(produto);
		produtoDao.cadastra(produto2);
		produtoDao.cadastra(produto3);
		
		clienteDao.cadastra(cliente);
		clienteDao.cadastra(cliente2);
		clienteDao.cadastra(cliente3);
		
		pedidoDao.cadastra(pedido);
		pedidoDao.cadastra(pedido2);
		pedidoDao.cadastra(pedido3);

		em.getTransaction().commit();
		em.close();
	}
}
