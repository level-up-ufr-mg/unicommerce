package br.edu.uniformg.unicommerce.controller;

import javax.persistence.EntityManager;
import br.edu.uniformg.unicommerce.dao.ProdutoDao;
import br.edu.uniformg.unicommerce.modelo.Produto;
import br.edu.uniformg.unicommerce.modelo.TipoDesconto;
import br.edu.uniformg.unicommerce.modelo.Cliente;
import br.edu.uniformg.unicommerce.modelo.Pedido;
import br.edu.uniformg.unicommerce.dao.ClienteDao;
import br.edu.uniformg.unicommerce.dao.PedidoDao;
import br.edu.uniformg.unicommerce.modelo.Categoria;
import br.edu.uniformg.unicommerce.dao.CategoriaDao;
import br.edu.uniformg.unicommerce.modelo.Endereco;
import br.edu.uniformg.unicommerce.modelo.ItemPedido;
import br.edu.uniformg.unicommerce.util.JPAUtil;
import java.math.BigDecimal;

public class CadastraPedido {
	
	public static void main(String[] args) {
			
		popularBD();
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		Produto produto = produtoDao.buscaProdutoPorId(1l);
		
		ClienteDao clienteDao = new ClienteDao(em);
		Cliente cliente = clienteDao.buscaClientePorId(1l);
		
		em.getTransaction().begin();
		Pedido pedido = new Pedido(new BigDecimal("30"), TipoDesconto.NENHUM, cliente);
		pedido.adicionarItem(new ItemPedido(12, new BigDecimal("300"), TipoDesconto.FIDELIDADE, pedido, produto));
		
		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastra(pedido);
		
		em.getTransaction().commit();
		em.close();
		
//        BigDecimal totalVendido = pedidoDao.valorTotalVendido();
//        System.out.println("Valor Total: " + totalVendido);
//        
//        List<Object[]> relatorioVendas = pedidoDao.relatorioDeVendas();
//        for (Object[] obj : relatorioVendas) {
//            System.out.println(obj[0]);
//            System.out.println(obj[1]);
//            System.out.println(obj[2]);
//        }
		
	}
	
	private static void popularBD() {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		Categoria categoria = new Categoria("Eletrônicos", true);
		Produto produto = new Produto("Mouse", "Mouse Gamer", new BigDecimal("120"), 2, categoria);
		Endereco endereco = new Endereco("Av. Dr. Arnaldo Sena", "328", "Prédio", "Água Vermelha", "Formiga", "MG");
		Cliente cliente = new Cliente("Evandro", "047623541689", "31992367889", endereco);

		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrarCategoria(categoria);
		produtoDao.cadastrarProduto(produto);	
		clienteDao.cadastrarCliente(cliente);
		
		em.getTransaction().commit();
		em.close();
	}

}
